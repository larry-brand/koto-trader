package org.cryptolosers.transaq

import com.google.gson.Gson
import org.cryptolosers.commons.file.ConfigFile

class ConfigTransaqFile : ConfigFile(TRANSAQ_TERMINAL_FILE) {
    var profileName: String = ""
    var terminalName: String = ""
    var login: String = ""
    var password: String = ""
    var host: String = ""
    var port: String =""

    fun init() {
        val config = Gson().fromJson(readText(), ConfigTransaqFile::class.java)
        profileName = config.profileName
        terminalName = config.terminalName
        login = config.login
        password = config.password
        host = config.host
        port = config.port
    }

    override fun toString(): String {
        return "profileName='$profileName', terminalName='$terminalName', login='$login', password='*', host='$host', port='$port'"
    }

}