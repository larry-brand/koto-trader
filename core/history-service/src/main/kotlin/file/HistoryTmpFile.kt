package org.cryptolosers.history.file

import org.cryptolosers.commons.file.ProjectHomeFile
import org.cryptolosers.history.HistoryTickerId
import org.cryptolosers.history.Timeframe
import java.io.File
import java.nio.file.Paths
import java.time.LocalDate
import kotlin.io.path.absolute

class HistoryTmpFile : ProjectHomeFile {

    companion object{
        const val DOT_DATA_TMP = ".data.tmp"
    }

    constructor(tickerId: HistoryTickerId, periodicity: Timeframe, date: LocalDate): super(HistoryFile.wrapFilenameTiks(tickerId, periodicity, date, DOT_DATA_TMP)) {
    }
    constructor(tickerId: HistoryTickerId, periodicity: Timeframe, year: Int): super(HistoryFile.wrapFilenameMinHourDay(tickerId, periodicity, year, DOT_DATA_TMP)) {
    }

    fun save(entries: Collection<Any>) {
        val dirsP = Paths.get(file.absolutePath).parent.absolute()
        val dirs = File(dirsP.toString());

        if (!dirs.exists()) {
            dirs.mkdirs()
        }
        if (!file.exists()) {
            file.createNewFile()
        }

        file.printWriter().use { out ->
            entries.forEach {
                out.println(it)
            }
        }
    }

    fun renameToOkFile() {
        val oldData = File(file.absolutePath.replace(DOT_DATA_TMP, HistoryFile.DOT_DATA))
        oldData.delete()
        file.renameTo(oldData)
    }
}