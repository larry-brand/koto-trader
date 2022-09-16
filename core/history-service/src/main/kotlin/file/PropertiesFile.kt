package org.cryptolosers.history.file

import org.cryptolosers.commons.file.ProjectHomeFile
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

class PropertiesFile : ProjectHomeFile("index.properties") {

    fun readProperties(): Properties {
        if (!file.exists()) {
            file.createNewFile()
        }
        val prop = Properties()
        FileInputStream(file).use {
            prop.load(it)
        }
        return prop
    }

    fun saveProperties(key: String, value: String) {
        if (!file.exists()) {
            file.createNewFile()
        }
        val prop = Properties()
        FileInputStream(file).use {
            prop.load(it)
            prop.setProperty(key, value)
            val out: OutputStream = FileOutputStream(file)
            prop.store(out, null)
        }
    }
}