package org.cryptolosers.commons.file

import java.io.File

open class ConfigFile(filename: String) : File(wrapFilename(filename)) {

    companion object {
        const val FINAM_DOWNLOAD_HISTORY_FILE = "finam-download-history.json"
        const val FINAM_DOWNLOAD_HISTORY_CRED_FILE = "finam-download-history-credentials.json"
        const val TRANSAQ_TERMINAL_FILE = "transaq-terminal.json"

        fun wrapFilename(filename: String): String {
            return System.getProperty("user.dir") + separator + "config" + separator + filename
        }
    }

}