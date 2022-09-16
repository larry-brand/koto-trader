package org.cryptolosers.transaq

import org.cryptolosers.trading.model.OrderBook
import org.cryptolosers.trading.model.Position
import org.cryptolosers.trading.model.TickerId
import org.cryptolosers.trading.model.Wallet
import org.cryptolosers.transaq.connector.concurrent.Transaction
import org.cryptolosers.transaq.xml.callback.*
import org.cryptolosers.transaq.xml.callback.internal.FortsPosition
import org.cryptolosers.transaq.xml.callback.internal.MoneyPosition
import org.cryptolosers.transaq.xml.callback.internal.SecPosition
import org.cryptolosers.transaq.xml.callback.internal.UnitedLimits
import java.math.BigDecimal
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicReference


class TransaqMemory {

    // technical
    var responseServerStatuses: BlockingQueue<ServerStatus> = LinkedBlockingQueue()

    // not technical
    var markets: ConcurrentMap<Long, Markets.Market> = ConcurrentHashMap()
    var boards: MutableList<Boards.Board> = CopyOnWriteArrayList()
    var tickerMap: MutableMap<TickerId, TransaqTickerInfo> = ConcurrentHashMap()

    var priceMap: ConcurrentMap<TickerId, BigDecimal> = ConcurrentHashMap()
    var orderBookMap: ConcurrentMap<TickerId, OrderBook> = ConcurrentHashMap()

    var clients: MutableList<Client> = CopyOnWriteArrayList()
    var portfolioTpluses: AtomicReference<PortfolioTplus> = AtomicReference(PortfolioTplus())
    var wallet: AtomicReference<Wallet?> = AtomicReference()

    var secPositionMap: MutableMap<TickerId, SecPosition> = ConcurrentHashMap()
    var fortsPositionMap: MutableMap<TickerId, FortsPosition> = ConcurrentHashMap()
    var moneyPositionMap: MutableMap<TickerId, MoneyPosition> = ConcurrentHashMap()
    var positions: AtomicReference<List<Position>> = AtomicReference(ArrayList())

    var unitedLimits: MutableList<UnitedLimits> = CopyOnWriteArrayList()

    var orders: AtomicReference<Orders> = AtomicReference(Orders())
    var transactions: AtomicReference<Transactions> = AtomicReference(Transactions())

    fun reset() {
        //TODO
    }
}

class Transactions {
    var ordersMap: ConcurrentHashMap<String, Transaction> = ConcurrentHashMap()
}