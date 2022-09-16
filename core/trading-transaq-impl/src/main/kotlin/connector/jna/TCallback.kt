package org.cryptolosers.transaq.connector.jna

/**
 * Transaq Connector JNA callback
 * If method throws exception it is caught and logged
 */
interface TCallback {
    fun invoke(response: String)
}