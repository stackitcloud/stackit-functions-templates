import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080

    embeddedServer(CIO, port = port, host = "0.0.0.0") {
        routing {
            route("/") {
                handle {
                    call.respondText("Hello from STACKIT Functions")
                }
            }

            get("/status") {
                call.respondText("OK")
            }
        }
    }.start(wait = true)
}
