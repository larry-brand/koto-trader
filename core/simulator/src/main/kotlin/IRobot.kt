package org.cryptolosers.simulator

import org.cryptolosers.history.HistoryCandle
import org.cryptolosers.trading.TradingApi

interface IRobot {

    suspend fun onNextMinuteCandle(historyCandle: HistoryCandle, tradingApi: TradingApi)

}