package com.example

import io.ktor.server.cio.*
import io.ktor.server.engine.*

fun main() {
    val serverPort = System.getenv("PORT")?.toIntOrNull() ?: 8080

    embeddedServer(CIO, port = serverPort, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}