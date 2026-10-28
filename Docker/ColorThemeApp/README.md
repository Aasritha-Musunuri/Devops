# ColorThemeApp — .NET with Docker

A small ASP.NET Core application with four color buttons. Clicking a button calls the API, which checks the color and returns it to the page. The browser then changes the preview box's color.

This project demonstrates building a Docker image and running a web application in a container.

## How it works

```text
Browser: localhost:8080
       | GET /api/color/blue
       v
Docker container: ASP.NET Core on port 8080
       | { "color": "blue" }
       v
Browser updates the preview box
```

The application uses .NET 9. Docker Desktop must be running with Linux containers. The Docker build includes the SDK, so you do not need to install it locally.

## Build and run

From the repository root:

```bash
cd Docker/ColorThemeApp
docker build -t colorthemeapp:local .
docker run -d --name color-theme-app -p 127.0.0.1:8080:8080 colorthemeapp:local
```

Open **http://localhost:8080** and click the color buttons.

`127.0.0.1:8080:8080` connects port 8080 on this computer to port 8080 inside the container. Binding to 127.0.0.1 keeps it accessible locally.

Try these paths in the browser:

- `/api/color/blue` returns `{"color":"blue"}`.
- `/api/color/BLUE` also returns `{"color":"blue"}`.
- `/api/color/purple` returns HTTP 400 with `{"message":"Invalid color"}`.

## What the Dockerfile does

The **build stage** uses the .NET SDK to restore dependencies and publish the application. Copying the project file before the source lets Docker reuse the dependency restore layer when only application code changes.

The **runtime stage** copies the published application into an ASP.NET Core runtime image. The final image does not include the SDK. It runs `ColorThemeApp.dll` as the image's built-in non-root user.

`EXPOSE 8080` documents the port; `docker run -p` actually publishes it. `.dockerignore` keeps build outputs and local editor files out of the build context.

## Inspect and troubleshoot

```bash
docker ps
docker logs color-theme-app
docker stop color-theme-app
docker start color-theme-app
```

If port 8080 is busy, use `-p 127.0.0.1:8081:8080` and open http://localhost:8081. If the container exits, check its logs first.

After changing the source, rebuild the image and replace the container:

```bash
docker build -t colorthemeapp:local .
docker rm -f color-theme-app
docker run -d --name color-theme-app -p 127.0.0.1:8080:8080 colorthemeapp:local
```

To finish:

```bash
docker stop color-theme-app
docker rm color-theme-app
```

## Why this matters in DevOps

An image packages the application and its runtime together. The same built image can be tested and deployed to a compatible container host. Networking, configuration, and secrets still need to be managed for each environment.

This is a local Docker project. It does not include a database, cloud deployment, or CI/CD pipeline.

## Interview explanation

“I containerized a .NET web application with a multi-stage Dockerfile. The SDK stage builds the application, and the final stage contains the runtime and published files. I run it as a non-root user, publish its port, and check container logs when troubleshooting.”
