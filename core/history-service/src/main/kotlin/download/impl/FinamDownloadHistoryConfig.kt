package org.cryptolosers.history.download.impl

class FinamDownloadHistoryConfig {
    val tickers: List<FinamDownloadHistroryTicker> = emptyList()
}

class FinamDownloadHistroryTicker(
    val tickerName: String,
    val market: String,
    val em: String,
    val code: String
)

class FinamDownloadHistoryCredentialsConfig(
    val token: String
)