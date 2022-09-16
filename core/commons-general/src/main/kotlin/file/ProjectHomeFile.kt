package org.cryptolosers.commons.file

import java.io.File
import java.io.File.separator

open class ProjectHomeFile {

    val filename: String
    val path: String
    val file: File

    companion object {
        fun wrapFilename(filename: String): String {
            return System.getProperty("user.home") + separator + ".koto-trader" + separator + filename
        }
    }

    constructor(path: String): super() {
        this.path = path
        this.file = File(wrapFilename(path))
        this.filename = this.file.name
    }

}