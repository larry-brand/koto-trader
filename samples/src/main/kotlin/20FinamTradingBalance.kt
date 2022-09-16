package org.cryptolosers.samples

import org.cryptolosers.trading.connector.Connector
import org.cryptolosers.transaq.FinamFutureInstrument
import org.cryptolosers.transaq.connector.concurrent.InternalTransaqConnector

/**
 * Sample
 * Connect to Finam via Transaq connector and print balance, positions, orders. It is not modify anything.
 * Before run:
 * - copy config/terminalConfig-example.json to config/terminalConfig.json
 * - insert your login and password (of Finam Transaq connector) to config/terminalConfig.json
 */
suspend fun main() {
    val conn  = Connector(InternalTransaqConnector())
    conn.connect()
    println("tickers " + conn.tradingApi().getAllTickers().filter { it.id.ticker.startsWith("BR") && it.type == FinamFutureInstrument })
    conn.abort()
}