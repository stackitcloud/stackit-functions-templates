plugins {
    kotlin("jvm") version "2.3.0"
    alias(ktorLibs.plugins.ktor)
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(ktorLibs.server.core)
    implementation(ktorLibs.server.cio)
    implementation("org.slf4j:slf4j-simple:2.0.16")
}

tasks.named<Jar>("jar") {
    enabled = false
}

tasks.named<Jar>("shadowJar") {
    archiveFileName.set("function.jar")
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}

tasks.named("assemble") {
    dependsOn("shadowJar")
}
