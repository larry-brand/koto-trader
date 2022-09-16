package org.cryptolosers.trading.model

import java.math.BigDecimal
import java.time.Instant

data class OrderBook(val tickerId: TickerId, val ask: List<BigDecimal>, val bid: List<BigDecimal>)

data class OrderBookEntry(val price: BigDecimal, val size: Int)

data class Candle(
    val timestamp: Instant,
    val openPrice: BigDecimal,
    val highPrice: BigDecimal,
    val lowPrice: BigDecimal,
    val closePrice: BigDecimal,
    val volume: Int
)

enum class Timeframe {
    _TIKS, _1_MIN, _5_MIN, _15_MIN, _1_HOUR, _1_DAY
}