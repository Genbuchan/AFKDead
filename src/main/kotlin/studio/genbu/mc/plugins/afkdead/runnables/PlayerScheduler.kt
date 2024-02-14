package studio.genbu.mc.plugins.afkdead.runnables

import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import studio.genbu.mc.plugins.afkdead.AFKDead

class PlayerScheduler(
    private val main: AFKDead,
    private val player: Player,
    private var location: Location
): BukkitRunnable() {

    private var firstTimeLimit: Int = main.config.getInt("timeLimit")
    private var timeLimit = firstTimeLimit

    override fun run() {
        if (location != player.location) {
            timeLimit = firstTimeLimit
            this.location = player.location

            return
        }

        timeLimit--

        if (timeLimit <= 0) {
            player.kick(Component.text("AFKのためキックされました。"))
            cancel()
        }
    }

}
