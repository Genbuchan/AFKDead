package studio.genbu.mc.plugins.afkdead

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import studio.genbu.mc.plugins.afkdead.commands.Command
import studio.genbu.mc.plugins.afkdead.events.PlayerEvents
import studio.genbu.mc.plugins.afkdead.runnables.PlayerScheduler
import studio.genbu.mc.plugins.afkdead.runnables.PlayerSchedulersManager

class AFKDead: JavaPlugin() {

    internal var manager = PlayerSchedulersManager(this);

    override fun onEnable() {
        saveDefaultConfig()
        server.pluginManager.registerEvents(PlayerEvents(this), this)
        getCommand("afkdead")!!.setExecutor(Command(this))

        logger.info("AFKDead is enabled.")
    }

    override fun onDisable() {
        logger.info("AFKDead is disabled.")
    }

}
