package org.cryptolosers.simulator

import org.cryptolosers.trading.TradingApi
import org.cryptolosers.trading.model.*
import java.math.BigDecimal
import java.time.Instant
import kotlin.math.absoluteValue


class SimulatorTradingApi(money: BigDecimal): TradingApi {

    var nowPrice = BigDecimal(0)
    private val comissionPunkts = BigDecimal(0.04)
    private val wallet = Wallet(money)
    private var positionBR: Position? = null
    var dials = 0

    override suspend fun getAllTickers(): List<TickerInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getPrice(tickerId: TickerId): BigDecimal {
        return nowPrice
    }

    override suspend fun getOrderBook(tickerId: TickerId): OrderBook {
        TODO("Not yet implemented")
    }

    override suspend fun getCandles(tickerId: TickerId, periodicity: Timeframe, startTimestamp: Instant, endTimestamp: Instant) {
        TODO("Not yet implemented")
    }

    override suspend fun sendOrder(order: IOrder) {
        if (order is MarketOrder) {
            if (positionBR == null) { // new position
                var sizeSign = order.size
                if (order.orderDirection == OrderDirection.SELL) {
                    sizeSign = -order.size
                }
                positionBR = Position(order.tickerId, sizeSign, nowPrice)
                wallet.balance -= (getPrice(order.tickerId) * order.size.toBigDecimal()).abs()
            } else {
                var orderSizeWithSigh: Int = order.size
                if (order.orderDirection == OrderDirection.SELL) {
                    orderSizeWithSigh = - order.size
                }
                if (positionBR!!.size * orderSizeWithSigh > 0) { // 1 2    -2 -1
                    TODO()
                } else if (positionBR!!.size > 0 && orderSizeWithSigh < 0 && (positionBR!!.size.absoluteValue == orderSizeWithSigh.absoluteValue) ) { // 1 -1
                    var diffPunkts = (nowPrice - positionBR!!.openPrice!!)
                    positionBR = null
                    wallet.equity += (diffPunkts - comissionPunkts).times(orderSizeWithSigh.absoluteValue.toBigDecimal()) * BigDecimal(7.0) * BigDecimal(100)
                    dials++
                } else if (positionBR!!.size < 0 && orderSizeWithSigh > 0 && (positionBR!!.size.absoluteValue == orderSizeWithSigh.absoluteValue)) { // -1  1
                    var diffPunts = (- nowPrice + positionBR!!.openPrice!!)
                    positionBR = null
                    wallet.equity += (diffPunts - comissionPunkts ).times(orderSizeWithSigh.absoluteValue.toBigDecimal())* BigDecimal(7.0) * BigDecimal(100)
                    dials++
                } else {
                    TODO()
                }
            }
        } else {
            TODO()
        }
    }

    override suspend fun removeOrder(orderId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun getOpenPosition(tickerId: TickerId): Position? {
        return positionBR
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
        if (positionBR != null)
            wallet.equity = wallet.balance + (getPrice(positionBR!!.tickerId) * positionBR!!.size.toBigDecimal()).abs()
        return wallet
    }
}