package org.cryptolosers.trading.service.transaq.impl;

import api.entity.common.History;
import api.entity.common.Ticker;
import api.entity.common.Wallet;
import api.entity.position.Position;
import api.entity.price.OrderBook;
import api.entity.price.Price;
import api.exception.TerminalErrorCode;
import api.exception.TerminalException;
import api.interfaces.AsyncTradingApi;
import org.cryptolosers.commons.utils.JAXBUtils;
import org.cryptolosers.trading.model.AbstractOrder;
import org.cryptolosers.trading.model.IOrder;
import org.cryptolosers.trading.model.MarketOrder;
import org.cryptolosers.trading.service.transaq.entity.Transaction;
import org.cryptolosers.trading.service.transaq.entity.TransaqTicker;
import org.cryptolosers.trading.service.transaq.jna.TXmlConnector;
import org.cryptolosers.trading.service.transaq.xml.callback.Client;
import org.cryptolosers.trading.service.transaq.xml.callback.internal.Order;
import org.cryptolosers.trading.service.transaq.xml.command.NewOrder;
import org.cryptolosers.trading.service.transaq.xml.command.NewStopOrder;
import org.cryptolosers.trading.service.transaq.xml.command.internal.Security;
import org.cryptolosers.trading.service.transaq.xml.command.internal.Stoploss;
import org.cryptolosers.trading.service.transaq.xml.command.internal.Takeprofit;
import org.cryptolosers.trading.service.transaq.xml.misc.Result;
import org.cryptolosers.transaq.TransaqMemory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Supplier;

public class TransaqAsyncTradingApi implements AsyncTradingApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransaqAsyncTradingApi.class);

    private TransaqTerminalManager terminalManager;
    private TransaqMemory memory;
    private TransaqSubscribtionTradingApi subscribtionTradingApi;

    public TransaqAsyncTradingApi(TransaqTerminalManager terminalManager, TransaqMemory memory, TransaqSubscribtionTradingApi subscribtionTradingApi) {
        this.terminalManager = terminalManager;
        this.memory = memory;
        this.subscribtionTradingApi = subscribtionTradingApi;
    }

    @Override
    public CompletableFuture<List<Ticker>> getAllTickers() {
        return supplyAsyncAndWaitConnectionStatus(() -> new ArrayList<>(memory.tickerMap.keySet()));
    }

    @Override
    public CompletableFuture<Price> getPrice(Ticker ticker) {
        //TODO: subscribe to price
        return CompletableFuture.supplyAsync(() -> { return memory.priceMap.get(ticker); });
    }

    @Override
    public CompletableFuture<OrderBook> getOrderBook(Ticker ticker) {
        //TODO: subscribe to OrderBook
        return CompletableFuture.supplyAsync(() -> { return memory.orderBookMap.get(ticker); });
    }

    @Override
    public CompletableFuture<History> getMyAllHistory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<History> getMyHistory(Ticker ticker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Void> sendOrder(IOrder iOrder) {
        return supplyAsyncAndWaitConnectionStatus(() -> {
            if (iOrder instanceof LimitOrder || iOrder instanceof MarketOrder) {
                // !!! ORDER !!!
                AbstractOrder order = (AbstractOrder) iOrder;
                if (!memory.tickerMap.containsKey(order.getTicker())) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_TICKER));
                }
                NewOrder newOrder = new NewOrder();
                newOrder.setSecurity(new Security());
                newOrder.getSecurity().setSeccode(order.getTicker().getName());

                TransaqTicker t = memory.tickerMap.get(order.getTicker());
                Long market = t.getExchangeId();

                Client clientForMarket = null;
                for (Client c : memory.clients) {
                    if (c.getMarket().equals(market)) {
                        clientForMarket = c;
                        break;
                    }
                }
                if (clientForMarket == null) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }
                newOrder.setClient(clientForMarket.getId());
                newOrder.setUnion(clientForMarket.getUnion());

                if (iOrder instanceof LimitOrder) {
                    newOrder.setPrice(((LimitOrder) order).getPrice().toString());
                } else if (iOrder instanceof MarketOrder) {
                    newOrder.setBymarket("");
                }

                newOrder.setQuantity(order.getSize());
                if (order.getOrderOperation() == OrderOperation.BUY) {
                    newOrder.setBuysell("B");
                } else if (order.getOrderOperation() == OrderOperation.SELL) {
                    newOrder.setBuysell("S");
                } else {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }

                try {
                    String newOrderXml = JAXBUtils.marshall(newOrder);
                    String resultXml = TXmlConnector.sendCommand(newOrderXml);
                    Result result = JAXBUtils.unmarshall(resultXml, Result.class);
                    if (result.getSuccess() == null || result.getSuccess() == false) {
                        throw new CompletionException(new TerminalException(TerminalErrorCode.PLACE_ORDER_ERROR, result.getMessage()));
                    }
                    LOGGER.info("order " + order.getTicker() + " , size=" + order.getSize() + " was placed");

                    Long transactionId = result.getTransactionid();
                    // wait order
                    Transaction transaction = Transaction.from(transactionId.toString(), memory.transactions);
                    Order transactionOrder = transaction.await();

                } catch (JAXBException e) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }


                //TODO: wait and get Response from memory.transactionMap
            } else if (iOrder instanceof StopOrder) {
                // !!! STOP ORDER !!!
                StopOrder stopOrder = (StopOrder) iOrder;
                if (!memory.tickerMap.containsKey(stopOrder.getTicker())) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_TICKER));
                }
                NewStopOrder newStopOrder = new NewStopOrder();
                newStopOrder.setSecurity(new Security());
                newStopOrder.getSecurity().setSeccode(stopOrder.getTicker().getName());

                TransaqTicker t = memory.tickerMap.get(stopOrder.getTicker());
                newStopOrder.getSecurity().setBoard(t.getBoard());

                Long market = t.getExchangeId();
                Client clientForMarket = null;
                for (Client c : memory.clients) {
                    if (c.getMarket().equals(market)) {
                        clientForMarket = c;
                        break;
                    }
                }
                if (clientForMarket == null) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }
                newStopOrder.setClient(clientForMarket.getId());
                newStopOrder.setUnion(clientForMarket.getUnion());
                if (stopOrder.getOrderOperation() == OrderOperation.BUY) {
                    newStopOrder.setBuysell("B");
                } else if (stopOrder.getOrderOperation() == OrderOperation.SELL) {
                    newStopOrder.setBuysell("S");
                } else {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }

                newStopOrder.setStoploss(new Stoploss());
                newStopOrder.getStoploss().setActivationprice(stopOrder.getActivationPrice().toString());
                newStopOrder.getStoploss().setOrderprice(stopOrder.getPrice().toString());
                newStopOrder.getStoploss().setQuantity(stopOrder.getSize());

                try {
                    String newOrderXml = JAXBUtils.marshall(newStopOrder);
                    String resultXml = TXmlConnector.sendCommand(newOrderXml);
                    Result result = JAXBUtils.unmarshall(resultXml, Result.class);
                    if (result.getSuccess() == null || result.getSuccess() == false) {
                        throw new CompletionException(new TerminalException(TerminalErrorCode.PLACE_ORDER_ERROR, result.getMessage()));
                    }
                    LOGGER.info("stop order  " + stopOrder.getTicker() + " , size=" + stopOrder.getSize() + " was placed");

                    Long transactionId = result.getTransactionid();
                    // wait order
                    Transaction transaction = Transaction.from(transactionId.toString(), memory.transactions);
                    Order transactionOrder = transaction.await();

                } catch (JAXBException e) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }


            } else if (iOrder instanceof TakeProfitOrder) {
                //TODO
            } else if (iOrder instanceof StopAndTakeProfitOrder) {
                // !!! STOP AND TAKE ORDER !!!
                StopAndTakeProfitOrder stopAndTakeProfitOrder = (StopAndTakeProfitOrder) iOrder;
                StopOrder stopOrder = stopAndTakeProfitOrder.getStopOrder();
                TakeProfitOrder takeProfitOrder = stopAndTakeProfitOrder.getTakeProfitOrder();
                if (!memory.tickerMap.containsKey(stopOrder.getTicker())) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_TICKER));
                }

                NewStopOrder newStopOrder = new NewStopOrder();
                newStopOrder.setSecurity(new Security());
                newStopOrder.getSecurity().setSeccode(stopOrder.getTicker().getName());
                TransaqTicker t = memory.tickerMap.get(stopOrder.getTicker());
                newStopOrder.getSecurity().setBoard(t.getBoard());

                Long market = t.getExchangeId();
                Client clientForMarket = null;
                for (Client c : memory.clients) {
                    if (c.getMarket().equals(market)) {
                        clientForMarket = c;
                        break;
                    }
                }
                if (clientForMarket == null) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }
                newStopOrder.setClient(clientForMarket.getId());
                newStopOrder.setUnion(clientForMarket.getUnion());
                if (stopOrder.getOrderOperation() == OrderOperation.BUY) {
                    newStopOrder.setBuysell("B");
                } else if (stopOrder.getOrderOperation() == OrderOperation.SELL) {
                    newStopOrder.setBuysell("S");
                } else {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }

                newStopOrder.setStoploss(new Stoploss());
                newStopOrder.getStoploss().setActivationprice(stopOrder.getActivationPrice().toString());
                newStopOrder.getStoploss().setOrderprice(stopOrder.getPrice().toString());
                newStopOrder.getStoploss().setQuantity(stopOrder.getSize());

                newStopOrder.setTakeprofit(new Takeprofit());
                newStopOrder.getTakeprofit().setActivationprice(takeProfitOrder.getActivationPrice().toString());
                newStopOrder.getTakeprofit().setQuantity(takeProfitOrder.getSize());
                newStopOrder.getTakeprofit().setBymarket("");

                try {
                    String newOrderXml = JAXBUtils.marshall(newStopOrder);
                    String resultXml = TXmlConnector.sendCommand(newOrderXml);
                    Result result = JAXBUtils.unmarshall(resultXml, Result.class);
                    if (result.getSuccess() == null || result.getSuccess() == false) {
                        throw new CompletionException(new TerminalException(TerminalErrorCode.PLACE_ORDER_ERROR, result.getMessage()));
                    }
                    LOGGER.info("stop order and take " + stopAndTakeProfitOrder.getStopOrder().getTicker() + " , size=" + stopAndTakeProfitOrder.getStopOrder().getSize() + " was placed");

                    Long transactionId = result.getTransactionid();
                    // wait order
                    Transaction transaction = Transaction.from(transactionId.toString(), memory.transactions);
                    Order transactionOrder = transaction.await();
                } catch (JAXBException e) {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                }

            }
            return null;
        });
    }

    @Override
    public CompletableFuture<List<IOrder>> getOrders(Ticker ticker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<List<IOrder>> getAllOrders() {
        return supplyAsyncAndWaitConnectionStatus(() -> getAllOrdersFromMemory(memory));
    }

    public static List<IOrder> getAllOrdersFromMemory(TransaqMemory memory) {
        List<IOrder> retVal = new ArrayList<>();
        if (memory.orders.getOrder() != null) {
            for (Order o : memory.orders.getOrder()) {
                if ("active".equals(o.getStatus()) || "forwarding".equals(o.getStatus()) || "watching".equals(o.getStatus())) {
                    // market
                    if (o.getPrice().compareTo(new BigDecimal(0)) == 0) {
                        MarketOrder marketOrder = new MarketOrder();
                        Ticker ticker = null;
                        for (TransaqTicker t: memory.tickerMap.values()) {
                            if (t.getName().equals(o.getSeccode()) && t.getBoard().equals(o.getBoard())) {
                                ticker = t;
                                break;
                            }
                        }
                        marketOrder.setTicker(ticker);
                        marketOrder.setOrderId(o.getTransactionid());
                        marketOrder.setSize(o.getQuantity());
                        if ("B".equals(o.getBuysell())) {
                            marketOrder.setOrderOperation(OrderOperation.BUY);
                        } else if ("S".equals(o.getBuysell())) {
                            marketOrder.setOrderOperation(OrderOperation.SELL);
                        } else {
                            throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                        }
                        retVal.add(marketOrder);
                    }
                    // limit
                    else {
                        LimitOrder limitOrder = new LimitOrder();
                        Ticker ticker = null;
                        for (TransaqTicker t: memory.tickerMap.values()) {
                            if (t.getName().equals(o.getSeccode()) && t.getBoard().equals(o.getBoard())) {
                                ticker = t;
                                break;
                            }
                        }
                        limitOrder.setTicker(ticker);
                        limitOrder.setOrderId(o.getTransactionid());
                        limitOrder.setPrice(o.getPrice());
                        limitOrder.setSize(o.getQuantity());
                        if ("B".equals(o.getBuysell())) {
                            limitOrder.setOrderOperation(OrderOperation.BUY);
                        } else if ("S".equals(o.getBuysell())) {
                            limitOrder.setOrderOperation(OrderOperation.SELL);
                        } else {
                            throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                        }
                        retVal.add(limitOrder);
                    }
                }

            }
        }
        if (memory.orders.getStoporder() != null) {
            for (org.cryptolosers.trading.service.transaq.xml.callback.internal.StopOrder o : memory.orders.getStoporder()) {
                if ("active".equals(o.getStatus()) || "forwarding".equals(o.getStatus()) || "watching".equals(o.getStatus())) {
                    if (o.getStoploss() != null) {
                        StopOrder stopOrder = new StopOrder();
                        Ticker ticker = null;
                        for (TransaqTicker t: memory.tickerMap.values()) {
                            if (t.getName().equals(o.getSeccode()) && t.getBoard().equals(o.getBoard())) {
                                ticker = t;
                                break;
                            }
                        }
                        stopOrder.setTicker(ticker);
                        stopOrder.setOrderId(o.getTransactionid());
                        stopOrder.setActivationPrice(o.getStoploss().getActivationprice());
                        try {
                            Long size = Long.parseLong(o.getStoploss().getQuantity());
                            stopOrder.setSize(size);
                        } catch (NumberFormatException e) {
                            // quantity :double (в случае %)
                            throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                        }
                        if ("B".equals(o.getBuysell())) {
                            stopOrder.setOrderOperation(OrderOperation.BUY);
                        } else if ("S".equals(o.getBuysell())) {
                            stopOrder.setOrderOperation(OrderOperation.SELL);
                        } else {
                            throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                        }
                        retVal.add(stopOrder);
                    }

                    if (o.getTakeprofit() != null) {
                        TakeProfitOrder takeProfitOrder = new TakeProfitOrder();
                        Ticker ticker = null;
                        for (TransaqTicker t: memory.tickerMap.values()) {
                            if (t.getName().equals(o.getSeccode()) && t.getBoard().equals(o.getBoard())) {
                                ticker = t;
                                break;
                            }
                        }
                        takeProfitOrder.setTicker(ticker);
                        takeProfitOrder.setOrderId(o.getTransactionid());
                        takeProfitOrder.setActivationPrice(o.getTakeprofit().getActivationprice());
                        try {
                            Long size = Long.parseLong(o.getTakeprofit().getQuantity());
                            takeProfitOrder.setSize(size);
                        } catch (NumberFormatException e) {
                            // quantity :double (в случае %)
                            throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                        }
                        if ("B".equals(o.getBuysell())) {
                            // invert
                            takeProfitOrder.setOrderOperation(OrderOperation.SELL);
                        } else if ("S".equals(o.getBuysell())) {
                            // invert
                            takeProfitOrder.setOrderOperation(OrderOperation.BUY);
                        } else {
                            throw new CompletionException(new TerminalException(TerminalErrorCode.UNKNOWN_ERROR));
                        }
                        retVal.add(takeProfitOrder);
                    }
                }
            }
        }
        return retVal;
    }

    @Override
    public CompletableFuture<Void> removeOrder(long orderId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Position> getOpenPosition(Ticker ticker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<List<Position>> getAllOpenPositions() {
        return supplyAsyncAndWaitConnectionStatus(() -> (List<Position>) (List<?>) memory.positions.get());
    }

    @Override
    public CompletableFuture<Wallet> getWallet() {
        return supplyAsyncAndWaitConnectionStatus(() -> memory.wallet.get());
    }

    private <T> CompletableFuture<T> supplyAsyncAndWaitConnectionStatus(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (terminalManager.connectedStatus) {
                // if NOT connected
                if (terminalManager.connectedStatus.get() != 1) {
                    try {
                        // wain until manager.connect() finished
                        terminalManager.connectedStatus.wait(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // if connected
                    if (terminalManager.connectedStatus.get() == 1) {
                        return supplier.get();
                    } else {
                        throw new CompletionException(new TerminalException(TerminalErrorCode.CONNECTION_ERROR));
                    }
                }
                // if connected
                else {
                    return supplier.get();
                }
            }
        });

    }

    /*private <T> CompletableFuture<T> supplyAsyncAndWaitConnectionStatusReentrantLock(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (terminalManager.connectedStatusLock.tryLock(60, TimeUnit.SECONDS)) {
                    // if connected
                    if (terminalManager.connectedStatus.get() == 1) {
                        return supplier.get();
                    } else {
                        throw new CompletionException(new TerminalException(TerminalErrorCode.CONNECTION_ERROR));
                    }
                } else {
                    throw new CompletionException(new TerminalException(TerminalErrorCode.CONNECTION_ERROR));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new CompletionException(new TerminalException(TerminalErrorCode.CONNECTION_ERROR));
            } finally {
                terminalManager.connectedStatusLock.unlock();
            }
        });
    }*/

}
