package org.cryptolosers.commons

import mu.KLogger

const val LOGGER_BORDER = "===================================="
const val ANSI_RESET = "\u001B[0m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_GREEN = "\u001B[32m"

fun printSuccess(message: String) {
    println(LOGGER_BORDER)
    println(ANSI_GREEN + "SUCCESS: " + message + ANSI_RESET)
    println(LOGGER_BORDER)
}

fun KLogger.printNeutral(message: () -> String) {
    info { LOGGER_BORDER }
    info { message() }
    info { LOGGER_BORDER }
}

fun KLogger.printSuccess(message: () -> String) {
    info { LOGGER_BORDER }
    info { ANSI_GREEN + message() + ANSI_RESET }
    info { LOGGER_BORDER }
}

fun KLogger.printFail(message: () -> String) {
    info { LOGGER_BORDER }
    error {ANSI_RED + message() + ANSI_RESET }
    info { LOGGER_BORDER }
}