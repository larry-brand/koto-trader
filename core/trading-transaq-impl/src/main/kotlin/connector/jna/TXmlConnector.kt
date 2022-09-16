package org.cryptolosers.transaq.connector.jna

import com.sun.jna.Callback
import com.sun.jna.Native
import com.sun.jna.Pointer
import org.cryptolosers.transaq.connector.jna.TXmlConnector.NativeMapping.TXMLCallback
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets

/**
 * Transaq connector JNA mapping
 */
object TXmlConnector {
    private val UTF_8 = StandardCharsets.UTF_8.name()
    private val txmlconnector64Filename = "txmlconnector64"

    /**
     * Returns initialization state
     * @return library state
     */
    @Volatile
    var isInitialized = false
        private set

    @Volatile
    // reference to callback must be strongly held otherwise it can cause crash if collected by GC
    private var txmlCallback: TXMLCallback? = null
    private val LOGGER = LoggerFactory.getLogger(TXmlConnector::class.java)

    /**
     * Initialize library. Required before further usage
     *
     * @param logPath  path to existing directory to write logs to
     * @param logLevel log level (1 - 3)
     */
    @Synchronized
    fun initialize(logPath: String?, logLevel: Int) {
        if (isInitialized) {
            throw TConnectorException("Library already initialized")
        }
        val result = NativeMapping.Initialize(logPath, logLevel)
        if (result != null) {
            val string = result.getString(0, UTF_8)
            NativeMapping.FreeMemory(result)
            throw TConnectorException("Error during initialization: $string")
        } else {
            isInitialized = true
        }
    }

    /**
     * Uninitialize library. Use after finishing work
     */
    @Synchronized
    fun unInitialize() {
        if (!isInitialized) {
            throw TConnectorException("Library is not initialized")
        }
        val result = NativeMapping.UnInitialize()
        if (result != null) {
            val string = result.getString(0, UTF_8)
            NativeMapping.FreeMemory(result)
            throw TConnectorException("Error during uninitialization: $string")
        } else {
            isInitialized = false
        }
    }

    /**
     * Sends command
     */
    fun sendCommand(command: String): String {
        return if (isInitialized) {
            LOGGER.debug("sendCommand request: $command")
            val pointer = NativeMapping.SendCommand(command)
            val response = pointer.getString(0, UTF_8)
            LOGGER.debug("sendCommand result: $response")
            NativeMapping.FreeMemory(pointer)
            response
        } else {
            throw TConnectorException("Library is not initialized")
        }
    }

    /**
     * Sets callback function
     */
    @Synchronized
    fun setCallback(tCallback: TCallback): Boolean {
        return if (isInitialized) {
            txmlCallback = object : TXMLCallback {
                override fun invoke(value: Pointer?): Boolean {
                    if (value != null) {
                        try {
                            tCallback.invoke(value.getString(0, UTF_8))
                        } catch (e: Exception) {
                            LOGGER.error("Uncaught exception in TXMLConnector Callback:" + e.message, e)
                        } finally {
                            NativeMapping.FreeMemory(value)
                        }
                    }
                    return true
                }
            }
            NativeMapping.SetCallback(txmlCallback)
        } else {
            throw TConnectorException("Library is not initialized")
        }
    }

    /**
     * Mappings
     * see TXmlConnector documentation
     * supports only x64 version
     * SetCallbackEx is intentionally not supported
     */
    object NativeMapping {
        init {
            Native.register(txmlconnector64Filename)
        }

        external fun Initialize(pPath: String?, logLevel: Int): Pointer?
        external fun SendCommand(command: String?): Pointer
        external fun UnInitialize(): Pointer?
        external fun FreeMemory(pointer: Pointer?): Boolean
        external fun SetCallback(callback: TXMLCallback?): Boolean
        interface TXMLCallback : Callback {
            fun invoke(`val`: Pointer?): Boolean
        }
    }
}