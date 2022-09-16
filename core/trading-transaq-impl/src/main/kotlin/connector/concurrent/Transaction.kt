package org.cryptolosers.transaq.connector.concurrent

import mu.KotlinLogging
import org.cryptolosers.transaq.Transactions
import org.cryptolosers.transaq.xml.callback.internal.Order
import org.cryptolosers.transaq.xml.callback.internal.StopOrder
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class Transaction private constructor(val id: String) {
    private val lock: Lock
    private val condition: Condition
    private var order: Order? = null
    private var stopOrder: StopOrder? = null

    init {
        lock = ReentrantLock()
        condition = lock.newCondition()
    }

    fun await(): Order? {
        lock.lock()
        try {
            condition.await(60, TimeUnit.SECONDS)
        } catch (e: InterruptedException) {
            logger.error(e) { "Transaction was interrupted" }
        }
        return order
    }

    fun awaitStop(): StopOrder? {
        lock.lock()
        try {
            condition.await(60, TimeUnit.SECONDS)
        } catch (e: InterruptedException) {
            logger.error(e) { "Transaction was interrupted" }
        }
        return stopOrder
    }

    companion object {
        private val logger = KotlinLogging.logger {}

        fun from(id: String?, transactions: Transactions): Transaction {
            return transactions.ordersMap.computeIfAbsent(id!!) { id: String -> Transaction(id) }
        }

        fun signalAll(id: String?, order: Order?, transactions: Transactions) {
            val transaction = transactions.ordersMap.remove(id)
            if (transaction != null) {
                transaction.lock.lock()
                transaction.order = order
                transaction.condition.signalAll()
                transaction.lock.unlock()
            }
        }

        fun signalAll(id: String?, stopOrder: StopOrder?, transactions: Transactions) {
            val transaction = transactions.ordersMap.remove(id)
            if (transaction != null) {
                transaction.lock.lock()
                transaction.stopOrder = stopOrder
                transaction.condition.signalAll()
                transaction.lock.unlock()
            }
        }
    }
}