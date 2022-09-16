package org.cryptolosers.trading

import org.cryptolosers.trading.model.*
import java.math.BigDecimal
import java.time.Instant

interface TradingApi {
    /** tickers data */
    suspend fun getAllTickers(): List<TickerInfo>


    /** quotes data */
    suspend fun getPrice(tickerId: TickerId): BigDecimal
    suspend fun getOrderBook(tickerId: TickerId): OrderBook
    suspend fun getCandles(tickerId: TickerId, periodicity: Timeframe, startTimestamp: Instant, endTimestamp: Instant)


    /** orders commands */
    suspend fun sendOrder(order: IOrder)
    suspend fun removeOrder(orderId: Long)


    /** operations */
    suspend fun getOpenPosition(tickerId: TickerId): Position?
    suspend fun getAllOpenPositions(): List<Position>
    suspend fun getOrders(tickerId: TickerId): List<IOrder>
    suspend fun getAllOrders(): List<IOrder>
    suspend fun getOperations(tickerId: TickerId): List<Operation>
    suspend fun getAllOperations(): List<Operation>
    suspend fun getWallet(): Wallet
}