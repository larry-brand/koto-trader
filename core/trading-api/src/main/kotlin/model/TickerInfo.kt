package org.cryptolosers.trading.model

import java.util.*

/** ticker=BR exchangeId="MOEX"  internalId=34 */
data class TickerId(val ticker: String, val exchange: ExchangeId? = null, val internalId: String? = null)

data class TickerInfo (
    val id: TickerId,
    val tickerName: String,
    val exchangeId: ExchangeId,
    val type: InstrumentType,
    val currency: Currency
)

data class ExchangeId(val name: String, val internalId: String? = null)

val MOEX_Exchange = ExchangeId("MOEX")
val NASDAQ_Exchange = ExchangeId("NASDAQ")
val NYSE_Exchange = ExchangeId("NYSE")

data class InstrumentType(val name: String)