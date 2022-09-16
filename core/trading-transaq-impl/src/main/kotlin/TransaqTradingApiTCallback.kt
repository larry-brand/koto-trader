package org.cryptolosers.transaq

import mu.KotlinLogging
import org.cryptolosers.commons.utils.JAXBUtils
import org.cryptolosers.trading.model.ExchangeId
import org.cryptolosers.trading.model.InstrumentType
import org.cryptolosers.trading.model.TickerId
import org.cryptolosers.trading.model.TickerInfo
import org.cryptolosers.transaq.connector.jna.TCallback
import org.cryptolosers.transaq.xml.callback.*
import java.util.*
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException

class TransaqTradingApiTCallback(val memory: TransaqMemory) : TCallback {

    override fun invoke(response: String) {
        try {
            if (response.startsWith("<pits>") || response.contains("<news_header>")
                || response.startsWith("<candlekinds>") || response.startsWith("<trades>")
                || response.startsWith("<union") || response.startsWith("<overnight")) {
                logger.debug { "Response wont be handled, it is not supported: $response" }
                return
            }

            val resp: Any = JAXBUtils.unmarshall(response, jaxbContext)
            // ServerStatus
            if (resp is ServerStatus) {
                memory.responseServerStatuses.put(resp)
            } else if (resp is Markets) {
                resp.market.forEach { memory.markets[it.id] = it }
            } else if (resp is Boards) {
                memory.boards.clear()
                //memory.boards.addAll(boards.board)
            } else if (resp is Securities) {
                handleSecirity(resp)
            } else if (resp is SecInfoUpd) {
                //TODO add handle
            } else if (resp is Positions) {
                //handlePosition(resp)
            } else if (resp is Client) {
                //TODO: to map
                memory.clients.add(resp)
            } else if (resp is PortfolioTplus) {
                memory.portfolioTpluses.set(resp)
            } else if (resp is Quotes) {
                //handleQuotes(resp)
            } else if (resp is Quotations) {
                //handleQuotations(resp)
            } else if (resp is Orders) {
                //handleOrders(resp)
            } else if (resp is Messages) {
                logger.info { resp.toString() }
            } else  {
                logger.info {"Response is not handled, may be not instanced $response" }
            }
        } catch (e: JAXBException) {
            logger.warn { "Parsing is not supported or error: ${response.substring(0, 20)}" }
        } catch (e: InterruptedException) {
            logger.error(e) { "Thread was interrupted for: ${response.substring(0, 20)}" }
        } catch (e: RuntimeException) {
            logger.error(e) { "Parsing is not supported or error: ${response.substring(0, 20)}" }
            //e.printStackTrace()
        }
    }

    private fun handleSecirity(responseObj: Any) {
        val securities: Securities = responseObj as Securities
        for (s in securities.security) {
            try {
                // Secid действителен в течение сессии, постоянным уникальным ключом
                // инструмента между сессиями является Seccode+Market
                val key = TickerId(s.seccode, internalId = s.seccode + " " + s.market)
                val currency = Currency.getInstance("RUB") // TODO
                val marketName = memory.markets[s.market!!.toLong()]!!.market!!
                val info = TickerInfo(key, s.shortname!!, ExchangeId(marketName, s.market!!) , InstrumentType(s.sectype!!), currency)
                memory.tickerMap[key] = TransaqTickerInfo(info, s.board!!, s.decimals!!, s.minstep!!, s.lotsize!!, s.point_cost!!)
            } catch (e: RuntimeException) {
                logger.error(e) { "Can not handle security $s" }
            }
        }
    }
//
//    private fun handlePosition(responseObj: Any) {
//        val positions: Positions = responseObj as Positions
//        if (positions.getSec_position() != null) {
//            for (p in positions.getSec_position()) {
//                for (m in memory.markets) {
//                    if (m.getId().equals(p.getMarket())) {
//                        memory.secPositionMap.put(Ticker(p.getSeccode(), m.getMarket()), p)
//                    }
//                }
//            }
//        }
//        if (positions.getForts_position() != null) {
//            for (p in positions.getForts_position()) {
//                for (m in memory.markets) {
//                    if (m.getId().equals(p.getMarkets().getMarkets().get(0).getMarkets())) {
//                        memory.fortsPositionMap.put(Ticker(p.getSeccode(), m.getMarket()), p)
//                    }
//                }
//            }
//        }
//        if (positions.getMoney_position() != null) {
//            for (p in positions.getMoney_position()) {
//                for (m in memory.markets) {
//                    if (m.getId().equals(p.getMarkets().getMarket().get(0).getMarket())) {
//                        memory.moneyPositionMap.put(Ticker(p.getAsset(), m.getMarket()), p)
//                    }
//                }
//            }
//        }
//        if (positions.getUnited_limits() != null) {
//            memory.unitedLimits.clear()
//            memory.unitedLimits.addAll(positions.getUnited_limits())
//        }
//        // copy secPosition, fortsPosition to positions
//        val thisNewPositions: MutableList<Position> = ArrayList<Position>()
//        for (p in memory.secPositionMap.values) {
//            var pt: PositionType? = null
//            if (p.getSaldo() > 0) {
//                pt = PositionType.LONG
//            } else if (p.getSaldo() < 0) {
//                pt = PositionType.SHORT
//            } else {
//                // empty position, just display it
//                //LOGGER.error("invalid saldo");
//            }
//            if (pt != null) {
//                thisNewPositions.add(Position(p.getSeccode(), p.getSaldo(), pt))
//            }
//        }
//        for (p in memory.fortsPositionMap.values) {
//            var pt: PositionType? = null
//            if (p.getTotalnet() > 0) {
//                pt = PositionType.LONG
//            } else if (p.getTotalnet() < 0) {
//                pt = PositionType.SHORT
//            } else {
//                //LOGGER.error("invalid totalnet");
//                //return;
//            }
//            if (pt != null) {
//                thisNewPositions.add(Position(p.getSeccode(), p.getTotalnet(), pt))
//            }
//        }
//        for (m in memory.moneyPositionMap.values) {
//            thisNewPositions.add(Position(m.getAsset(), m.getSaldo().longValue(), null))
//        }
//        for (u in memory.unitedLimits) {
//            val oldWallet: Wallet = memory.wallet.get()
//            val newWallet = Wallet()
//            newWallet.setEquity(u.getEquity())
//            newWallet.setMargin(u.getRequirements())
//            newWallet.setFreeMargin(u.getFree())
//            memory.wallet.set(newWallet)
//            if (!newWallet.equals(oldWallet)) {
//                applyForChannelListener(WalletChannel(), Supplier<*> { newWallet })
//            }
//        }
//        memory.positions.set(thisNewPositions)
//        applyForChannelListener(WalletChannel()) { thisNewPositions }
//    }
//
//    private fun handleQuotes(responseObj: Any) {
//        val quotes: Quotes = responseObj as Quotes
//        val tickerSet: MutableSet<Ticker> = HashSet<Ticker>()
//        if (quotes.getQuote() != null) {
//            for (q in quotes.getQuote()) {
//                val ticker: Ticker = memory.tickerWithBoardMap.get(TickerWithBoard(q.getSeccode(), q.getBoard()))
//                if (!memory.orderBookMap.containsKey(ticker)) {
//                    memory.orderBookMap[ticker] = OrderBook()
//                }
//                tickerSet.add(ticker)
//                val orderBook: OrderBook? = memory.orderBookMap[ticker]
//                if (q.getBuy() != null && q.getBuy() !== 0L && q.getBuy() > 0) {
//                    orderBook.removeByPrice(q.getPrice())
//                    orderBook.getBid().add(OrderBookEntry(q.getPrice(), q.getBuy().longValue()))
//                    Collections.sort(orderBook.getBid())
//                } else if (q.getSell() != null && q.getSell() !== 0L && q.getSell() > 0) {
//                    orderBook.removeByPrice(q.getPrice())
//                    orderBook.getAsk().add(OrderBookEntry(q.getPrice(), q.getSell().longValue()))
//                    Collections.sort(orderBook.getAsk())
//                } else {
//                    //error
//                    orderBook.removeByPrice(q.getPrice())
//                }
//            }
//        }
//        for (ticker in tickerSet) {
//            applyForChannelListener(WalletChannel()) { memory.orderBookMap[ticker] }
//        }
//    }
//
//    private fun handleQuotations(responseObj: Any) {
//        val quotations: Quotations = responseObj as Quotations
//        val q: Quotations.Quotation = quotations.getQuotation()
//        if (q != null) {
//            val ticker: Ticker = memory.tickerWithBoardMap.get(TickerWithBoard(q.getSeccode(), q.getBoard()))
//            if (!memory.priceMap.containsKey(ticker)) {
//                memory.priceMap[ticker] = Price()
//            }
//            val price: Price? = memory.priceMap[ticker]
//            price.setTicker(ticker)
//            if (q.getBid() != null) {
//                price.setBidPrice(q.getBid())
//            }
//            if (q.getOffer() != null) {
//                price.setAskPrice(q.getOffer())
//            }
//            if (q.getLast() != null) {
//                price.setLastPrice(q.getLast())
//            }
//            if (price.getLastPrice() != null && price.getAskPrice() != null && price.getLastPrice().compareTo(price.getAskPrice()) >= 0) {
//                price.setLastPrice(price.getAskPrice())
//            }
//            if (price.getLastPrice() != null && price.getBidPrice() != null && price.getLastPrice().compareTo(price.getBidPrice()) === -1) {
//                price.setLastPrice(price.getBidPrice())
//            }
//            if (price.getLastPrice() == null && price.getAskPrice() != null) {
//                price.setLastPrice(price.getAskPrice())
//            }
//            try {
//                memory.subscriptionEventQueue.put(PriceChannel(ticker))
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//
//            // notify listener
//            applyForChannelListener(WalletChannel(), Supplier<*> { price })
//        }
//    }
//
//    private fun handleOrders(responseObj: Any) {
//        val orders: Orders = responseObj as Orders
//        if (orders.getOrder() != null) {
//            for (o in orders.getOrder()) {
//                if (memory.orders.getOrder() != null) {
//                    var iMemoryOrder: Int? = null
//                    for (i in 0 until memory.orders.getOrder().size()) {
//                        if (o.getOrderno().equals(memory.orders.getOrder().get(i).getOrderno())) {
//                            iMemoryOrder = i
//                            break
//                        }
//                    }
//                    if (iMemoryOrder != null) {
//                        memory.orders.getOrder().set(iMemoryOrder, o)
//                    } else {
//                        memory.orders.getOrder().add(o)
//                    }
//                } else {
//                    memory.orders.setOrder(orders.getOrder())
//                }
//            }
//        }
//        if (orders.getStoporder() != null) {
//            for (o in orders.getStoporder()) {
//                if (memory.orders.getStoporder() != null) {
//                    var iMemoryOrder: Int? = null
//                    for (i in 0 until memory.orders.getStoporder().size()) {
//                        if (o.getTransactionid().equals(memory.orders.getStoporder().get(i).getTransactionid())) {
//                            iMemoryOrder = i
//                            break
//                        }
//                    }
//                    if (iMemoryOrder != null) {
//                        memory.orders.getStoporder().set(iMemoryOrder, o)
//                    } else {
//                        memory.orders.getStoporder().add(o)
//                    }
//                } else {
//                    memory.orders.setStoporder(orders.getStoporder())
//                }
//            }
//        }
//
//        //memory.orders = orders;
//        if (orders.getOrder() != null) {
//            for (o in orders.getOrder()) {
//                if (o.getOrderno() != null && o.getOrderno() !== 0) {
//                    val transactionId: Long = o.getTransactionid()
//                    Transaction.signalAll(transactionId.toString(), o, memory.transactions)
//                }
//            }
//        }
//        if (orders.getStoporder() != null) {
//            for (o in orders.getStoporder()) {
//                val transactionId: Long = o.getTransactionid()
//                Transaction.signalAll(transactionId.toString(), o, memory.transactions)
//            }
//        }
//        applyForChannelListener(OrdersChannel(), Supplier<*> { TransaqAsyncTradingApi.getAllOrdersFromMemory(memory) })
//    }
//
//    private fun applyForChannelListener(iChannel: IChannel, applier: Supplier<*>) {
//        //TODO
//    }
//
//    private fun getMarketById(id: Long?): String {
//        var marketName = "Unknown"
//        if (id == null) {
//            return marketName
//        }
//        for (m in memory.markets) {
//            if (m.getId().equals(id)) {
//                marketName = m.getMarket()
//                break
//            }
//        }
//        return marketName
//    }

    companion object {
        private val logger = KotlinLogging.logger {}
        private var jaxbContext: JAXBContext? = null

        init {
            try {
                jaxbContext = JAXBContext.newInstance(
                    ServerStatus::class.java,
                    Markets::class.java, Boards::class.java, Securities::class.java,
                    SecInfoUpd::class.java, Positions::class.java, Client::class.java, PortfolioTplus::class.java, Quotations::class.java, Quotes::class.java,
                    Orders::class.java, Messages::class.java
                )
            } catch (e: JAXBException) {
                logger.error(e) { "Can not init JAXBContext" }
            }
        }
    }
}