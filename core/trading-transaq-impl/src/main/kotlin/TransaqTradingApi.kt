package org.cryptolosers.transaq

import org.cryptolosers.trading.TradingApi
import org.cryptolosers.trading.model.*
import java.math.BigDecimal
import java.time.Instant

class TransaqTradingApi(val memory: TransaqMemory): TradingApi {

    override suspend fun getAllTickers(): List<TickerInfo> {
        return memory.tickerMap.values.map{ it.tickerInfo }.toList()
    }

    override suspend fun getPrice(tickerId: TickerId): BigDecimal {
        TODO("Not yet implemented")
    }

    override suspend fun getOrderBook(tickerId: TickerId): OrderBook {
        TODO("Not yet implemented")
    }

    override suspend fun getCandles(tickerId: TickerId, periodicity: Timeframe, startTimestamp: Instant, endTimestamp: Instant) {
        TODO("Not yet implemented")
    }

    override suspend fun sendOrder(order: IOrder) {
        TODO("Not yet implemented")
    }

    override suspend fun removeOrder(orderId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun getOpenPosition(tickerId: TickerId): Position? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllOpenPositions(): List<Position> {
        TODO("Not yet implemented")
    }

    override suspend fun getOrders(tickerId: TickerId): List<IOrder> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllOrders(): List<IOrder> {
        TODO("Not yet implemented")
    }

    override suspend fun getOperations(tickerId: TickerId): List<Operation> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllOperations(): List<Operation> {
        TODO("Not yet implemented")
    }

    override suspend fun getWallet(): Wallet {
        TODO("Not yet implemented")
    }
}