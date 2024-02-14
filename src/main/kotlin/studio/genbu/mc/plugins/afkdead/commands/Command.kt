package studio.genbu.mc.plugins.afkdead.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import studio.genbu.mc.plugins.afkdead.AFKDead

class Command(private val main: AFKDead): CommandExecutor, TabCompleter {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): Boolean {
        if (command.name.equals("afkdead", ignoreCase = true)) {
            args?.let {
                if (it.isEmpty()) return false

                when (it[0]) {
                    "reload" -> {
                        main.reloadConfig()
                        sender.sendMessage(Component.text("AFKDead has been reloaded.", NamedTextColor.GREEN))
                    }
                    else -> return false
                }
            }
        }

        return true;
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String>? {
        if (command.name.equals("afkdead", ignoreCase = true)) {
            args?.let {
                if (it.size == 1) {
                    if (it[0].isEmpty())
                        return mutableListOf("reload")
                    else
                        if ("reload".startsWith(it[0])) return mutableListOf("reload")

                    return args.toMutableList()
                }
            }
        }

        return null
    }

}
