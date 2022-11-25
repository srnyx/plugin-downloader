description = "PluginDownloader"
version = "0.0.1"
group = "xyz.srnyx"

plugins {
    java
}

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // org.spigotmc:spigot-api
    mavenCentral() // org.spigotmc:spigot-api
}

dependencies {
    compileOnly("org.spigotmc", "spigot-api", "1.19.2-R0.1-SNAPSHOT")
    implementation("org.apache.commons", "commons-text", "1.10.0")
    implementation("org.jetbrains:annotations:23.0.0")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    processResources {
        inputs.property("version", project.version)
        filesMatching("**/plugin.yml") {
            expand("version" to project.version)
        }
    }
}