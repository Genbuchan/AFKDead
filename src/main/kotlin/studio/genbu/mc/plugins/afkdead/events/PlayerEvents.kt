package studio.genbu.mc.plugins.afkdead.events

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import studio.genbu.mc.plugins.afkdead.AFKDead

class PlayerEvents(private val main: AFKDead): Listener {

    private val manager = main.manager;

    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player

        manager.registerPlayer(player)
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerQuit(event: PlayerQuitEvent) {
        val player = event.player

        manager.unregisterPlayer(player)
    }

}
