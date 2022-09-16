package org.cryptolosers.samples

import org.cryptolosers.history.HistoryService
import org.cryptolosers.history.HistoryTickerId
import org.cryptolosers.history.Timeframe

/**
 * Sample
 * Download full history from Finam to C:\Users\username\.koto-trader\finam\Si\1 day
 */
fun main() {
    val service = HistoryService()
    service.downloadFullHistory(HistoryTickerId("Si"), Timeframe.ONE_DAY)
}