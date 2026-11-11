plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(ktorLibs.plugins.ktor)
}

group = "com.example"
version = "1.0.0-SNAPSHOT"

application {
    mainClass.set("com.example.MainKt")
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(ktorLibs.server.core)
    implementation(ktorLibs.server.cio)
    implementation(ktorLibs.server.statusPages)
    implementation(libs.logback.classic)
    implementation(ktorLibs.server.config.yaml)
}

tasks.named<Jar>("jar") {
    enabled = false
}

tasks.named<Jar>("shadowJar") {
    archiveFileName.set("function.jar")
    manifest {
        attributes["Main-Class"] = "com.example.MainKt"
    }
}

tasks.named("assemble") {
    dependsOn("shadowJar")
}

tasks.named("startScripts") {
    dependsOn("shadowJar")
}