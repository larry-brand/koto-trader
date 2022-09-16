package org.cryptolosers.trading.service.transaq.impl;

import api.entity.common.Ticker;
import api.exception.TerminalErrorCode;
import api.exception.TerminalException;
import api.interfaces.SubscribtionTradingApi;
import org.cryptolosers.commons.utils.JAXBUtils;
import org.cryptolosers.trading.service.transaq.jna.TXmlConnector;
import org.cryptolosers.trading.service.transaq.xml.command.Subscrube;
import org.cryptolosers.trading.service.transaq.xml.command.Unsubscribe;
import org.cryptolosers.trading.service.transaq.xml.command.internal.Security;
import org.cryptolosers.transaq.TransaqMemory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.util.function.Function;

public class TransaqSubscribtionTradingApi implements SubscribtionTradingApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransaqSubscribtionTradingApi.class);
    private TransaqMemory memory;

    public TransaqSubscribtionTradingApi(TransaqMemory memory) {
        this.memory = memory;
    }

    @Override
    public void subscribeOrderBook(Ticker ticker, Function channelListener) throws TerminalException {
        try {
            if (!memory.tickerMap.containsKey(ticker)) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_TICKER);
            }

            String xmlRequest = null;
            Subscrube subscrube = new Subscrube();
            Security security = new Security();

            String board = memory.tickerMap.get(ticker).getBoard();
            if (board == null) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
            }
            security.setBoard(board);

            security.setSeccode(ticker.getName());
            // подписка на изменения стакана
            subscrube.setQuotes(new Subscrube.Quotes());
            subscrube.getQuotes().getSecurity().add(security);

            xmlRequest = JAXBUtils.marshall(subscrube);

            if (xmlRequest != null) {
                LOGGER.info("subscribe orderBook : " + ticker.getName());
                String xmlResult = TXmlConnector.sendCommand(xmlRequest);
                LOGGER.debug("request: " + xmlRequest.replaceAll("[\\t\\n\\r]+","") + "\nresponse: " + xmlResult);
            }
        } catch (JAXBException e) {
            throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public void unsubscribeOrderBook(Ticker ticker) throws TerminalException {
        try {
            if (!memory.tickerMap.containsKey(ticker)) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_TICKER);
            }
            String xmlRequest = null;
            Unsubscribe unsubscribe = new Unsubscribe();
            Security security = new Security();

            String board = memory.tickerMap.get(ticker).getBoard();
            if (board == null) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
            }
            security.setBoard(board);

            security.setSeccode(ticker.getName());
            // подписка на изменения стакана
            unsubscribe.setQuotes(new Subscrube.Quotes());
            unsubscribe.getQuotes().getSecurity().add(security);

            xmlRequest = JAXBUtils.marshall(unsubscribe);

            if (xmlRequest != null) {
                String xmlResult = TXmlConnector.sendCommand(xmlRequest);
                LOGGER.debug("request: " + xmlRequest.replaceAll("[\\t\\n\\r]+","") + "\nresponse: " + xmlResult);
            }
        } catch (JAXBException e) {
            throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public void subscribePrice(Ticker ticker, Function channelListener) throws TerminalException {
        try {
            if (!memory.tickerMap.containsKey(ticker)) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_TICKER);
            }

            String xmlRequest = null;
            Subscrube subscrube = new Subscrube();
            Security security = new Security();

            String board = memory.tickerMap.get(ticker).getBoard();
            if (board == null) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
            }
            security.setBoard(board);

            security.setSeccode(ticker.getName());
            // подписка на котировки
            subscrube.setQuotations( new Subscrube.Quotations());
            subscrube.getQuotations().getSecurity().add(security);

            xmlRequest = JAXBUtils.marshall(subscrube);


            if (xmlRequest != null) {
                LOGGER.info("subscribed price : " + ticker.getName());
                String xmlResult = TXmlConnector.sendCommand(xmlRequest);
                LOGGER.debug("request: " + xmlRequest.replaceAll("[\\t\\n\\r]+","") + "\nresponse: " + xmlResult);
            }
        } catch (JAXBException e) {
            throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public void unsubscribePrice(Ticker ticker) throws TerminalException {
        try {
            if (!memory.tickerMap.containsKey(ticker)) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_TICKER);
            }
            String xmlRequest = null;
            Unsubscribe unsubscribe = new Unsubscribe();
            Security security = new Security();

            String board = memory.tickerMap.get(ticker).getBoard();
            if (board == null) {
                throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
            }
            security.setBoard(board);

            security.setSeccode(ticker.getName());
            // подписка на котировки
            unsubscribe.setQuotations( new Subscrube.Quotations());
            unsubscribe.getQuotations().getSecurity().add(security);

            xmlRequest = JAXBUtils.marshall(unsubscribe);

            if (xmlRequest != null) {
                String xmlResult = TXmlConnector.sendCommand(xmlRequest);
                LOGGER.debug("request: " + xmlRequest.replaceAll("[\\t\\n\\r]+","") + "\nresponse: " + xmlResult);

            }
        } catch (JAXBException e) {
            throw new TerminalException(TerminalErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public void subscribePositions(Function channelListener) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void unsubscribePositions() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void subscribeOrders(Function channelListener) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void unsubscribeOrders() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void subscribeWallet(Function channelListener) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void unsubscribeWallet() {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public void unsubscribeAll() {
        throw new UnsupportedOperationException("not implemented");
    }
}
