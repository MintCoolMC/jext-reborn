package me.spartacus04.jext.utils

import me.spartacus04.jext.State.PLUGIN
import me.spartacus04.jext.State.CONFIG
import me.spartacus04.jext.State.SCHEDULER
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URI

internal class PublicIP {
    fun getIP(consumer: (String) -> Unit) {
        SCHEDULER.runTaskAsynchronously {
            try {
                if (CONFIG.CUSTOM_PUBLIC_IP == "") {
                    val reader = BufferedReader(InputStreamReader(URI("https://api.ipify.org/").toURL().openStream()))
                    val text = reader.use {
                        it.readText()
                    }
                }
                else {
                    consumer(CONFIG.CUSTOM_PUBLIC_IP)
                }

                consumer(text)
            } catch (exception: IOException) {
                PLUGIN.logger.info("Unable to check for updates: " + exception.message)
            }
        }
    }
}