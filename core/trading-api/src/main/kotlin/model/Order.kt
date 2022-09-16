package org.cryptolosers.trading.model

import java.math.BigDecimal

interface IOrder {
}

abstract class AbstractOrder(
    open val tickerId: TickerId,
    open val size: Int,
    open val orderDirection: OrderDirection,
    open val orderId: String? = null
) : IOrder

enum class OrderDirection {
    BUY, SELL
}

data class MarketOrder(
    override val tickerId: TickerId,
    override val size: Int,
    override val orderDirection: OrderDirection,
    override val orderId: String? = null
) : AbstractOrder(tickerId, size, orderDirection, orderId)

data class StopOrder(
    override val tickerId: TickerId,
    override val size: Int,
    override val orderDirection: OrderDirection,
    val activationPrice: BigDecimal,
    val slippage: BigDecimal,
    override val orderId: String? = null
) : AbstractOrder(tickerId, size, orderDirection, orderId)