package studio.genbu.mc.plugins.afkdead.runnables

import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitTask
import studio.genbu.mc.plugins.afkdead.AFKDead

class PlayerSchedulersManager(private val main: AFKDead) {

    private var afkTasks = mutableMapOf<Player, BukkitTask>()

    fun registerPlayer(player: Player): BukkitTask? {
        afkTasks[player]?.let { return null }

        val task = PlayerScheduler(main, player, player.location).runTaskTimer(main, 0L, 20L)
        afkTasks[player] = task

        return afkTasks[player]!!
    }

    fun unregisterPlayer(player: Player): Boolean {
        afkTasks[player]?.let {
            it.cancel()
            afkTasks.remove(player)

            return true
        }

        return false
    }

}
