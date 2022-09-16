package org.cryptolosers.simulator

import org.cryptolosers.history.HistoryCandle
import org.cryptolosers.history.HistoryService
import org.cryptolosers.history.HistoryTickerId
import org.cryptolosers.history.Timeframe
import java.math.BigDecimal
import java.time.LocalDateTime

class HistorySimulator {

    val tradingApi = SimulatorTradingApi(INITIAL_MONEY)
    private val historyService = HistoryService()

    companion object {
        val INITIAL_MONEY = BigDecimal(100_000)
    }

    fun runOnCandles(
        tickerId: HistoryTickerId,
        periodicity: Timeframe,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
        onNextCandle: (HistoryCandle) -> Unit
    ) {

        val onNextCandleUpdated: (HistoryCandle) -> Unit = {
            tradingApi.nowPrice = it.closePrice
            onNextCandle(it)
        }

        historyService.runOnCandles(tickerId, periodicity, startDate, endDate, onNextCandleUpdated)
    }
}