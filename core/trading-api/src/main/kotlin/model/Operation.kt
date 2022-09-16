package org.cryptolosers.trading.model

import java.math.BigDecimal
import java.time.Instant

data class Position(val tickerId: TickerId, var size: Int, var openPrice: BigDecimal? = null) {
    fun getType(): PositionType {
        return if (size > 0) {
            PositionType.LONG
        } else if (size < 0) {
            PositionType.SHORT
        } else {
            throw IllegalStateException()
        }
    }
}

enum class PositionType {
    LONG, SHORT
}

data class Wallet(var balance: BigDecimal, var equity: BigDecimal = balance)

data class Operation(val id: String, val tickerId: TickerId, val price: BigDecimal, val size: Int, val timestamp: Instant, val status: OperationStatus)

enum class OperationStatus {
    IN_PROGRESS, COMPLETED, CANCELLED
}