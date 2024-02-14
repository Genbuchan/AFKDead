import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.2.2"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

group = "studio.genbu.minecraft.plugins"
version = "0.1.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://os.sonatype.org/content/repositories/snapshots")

}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("org.khelekore", "prtree", "1.7.0")
    bukkitLibrary("com.google.code.gson", "gson", "2.10.1")
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    testImplementation(kotlin("test"))
}

tasks {

    test {
        useJUnitPlatform()
    }

    shadowJar {
        archiveClassifier = ""
        minimize()
    }

    runServer {
        dependsOn("jar")
        minecraftVersion("1.20.4")
    }

}

runPaper.folia.registerTask()

bukkit {
    name = "AFKDead"
    version = project.version.toString()
    description = "Kick AFKing player"
    website = "https://genbu.studio/"
    authors = listOf("Genbuchan")

    main = "studio.genbu.mc.plugins.afkdead.AFKDead"
    foliaSupported = true
    apiVersion = "1.20"

    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD

    prefix = "AFKDEAD"

    permissions {
        register("afkdead.*") {
            children = listOf("afkdead.reload")
            childrenMap = mapOf("afkdead.reload" to true)
        }
    }

    commands {
        register("afkdead") {
            description = "Detect AFK player"
            permission = "afkdead.afkdead"
            usage = "/afkdead reload - Reload configuration."
            permissionMessage = "You are not permitted to execute this command."
        }
    }
}

kotlin {
    jvmToolchain(17)
}
