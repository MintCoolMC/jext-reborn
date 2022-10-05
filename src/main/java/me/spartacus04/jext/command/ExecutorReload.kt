package me.spartacus04.jext.command

import me.spartacus04.jext.config.ConfigData.Companion.CONFIG
import me.spartacus04.jext.config.ConfigData.Companion.LANG
import me.spartacus04.jext.config.ConfigManager
import me.spartacus04.jext.language.LanguageManager
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

internal class ExecutorReload(private val plugin: JavaPlugin) : ExecutorAdapter("jext") {
    override fun executePlayer(sender: Player, args: Array<String>): Boolean {
        return mergedExecute(sender)
    }

    override fun executeCommand(sender: CommandSender, args: Array<String>): Boolean {
        return mergedExecute(sender)
    }

    private fun mergedExecute(sender: CommandSender): Boolean {
        ConfigManager.load(this.plugin)
        LANG = LanguageManager(CONFIG.LANGUAGE_MODE.lowercase() == "auto", plugin)

        sender.sendMessage(
            LANG.format(sender, "reloaded")
        )
        return true
    }
}