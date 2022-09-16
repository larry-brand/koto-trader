package org.cryptolosers.history.download.api

import org.cryptolosers.history.HistoryCandle
import org.cryptolosers.history.HistoryTick
import org.cryptolosers.history.HistoryTickerId
import org.cryptolosers.history.Timeframe
import java.time.LocalDate

/**
 * Need to implement it for provider of historical stocks data
 */
interface DownloadHistoryApi {

    fun tickers(): List<HistoryTickerId>

    fun download(tickerId: HistoryTickerId, periodicity: Timeframe, startDate: LocalDate, endDate: LocalDate): ByteArray

    fun parseBytesToCandles(data: ByteArray): List<HistoryCandle>

    fun parseBytesToTiks(data: ByteArray): List<HistoryTick>
}