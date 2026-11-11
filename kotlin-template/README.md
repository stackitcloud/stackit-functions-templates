# STACKIT Functions - Kotlin Function Template

This template provides a basic structure for developing serverless functions using Kotlin (Ktor) for STACKIT Functions.

## Project Structure

* `src/main/Main.kt`: This is the main entry point for your function, initializing and running the Ktor server.
* `src/main/kotlin/Routing.kt`: Defines the HTTP routes and endpoint handling logic for your function.
* `stackit-functions.yaml`: Manifest file for STACKIT Functions. Contains environment settings and other configured data.

## Server Wrapper and Exposed Routes

This template is designed to work with a server wrapper that facilitates HTTP request handling.

By default the template exports the following route:

* `GET /`: The default HTTP handler for your function. In this template, it responds with `Hello from STACKIT Functions`.

Other requests will return a 404 response.

## Local Development

We highly recommend using the STACKIT Functions CLI in development.

To build this function:

```bash
sfn function build --image IMAGE_NAME

```

Run the function locally:

```bash
sfn function run

```

This command will start a local server, making your function accessible for testing at `http://localhost:8080` (or another port if configured).

## Function Deployment

Deploy your function to STACKIT Functions by using the following command:

```bash
sfn function deploy

```