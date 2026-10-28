# ColorThemeApp

A simple .NET web app packaged with Docker. Choose red, green, blue, or yellow and the preview box changes to that color.

The page calls `/api/color/{color}`. The API accepts the four supported colors and returns HTTP 400 for anything else.

## Run locally

Install Docker Desktop and use Linux containers. The application uses .NET 9; the Docker build provides the SDK and runtime.

Clone this repository, then run:

```bash
cd Docker/ColorThemeApp
docker build -t colorthemeapp:local .
docker run -d --name color-theme-app -p 127.0.0.1:8080:8080 colorthemeapp:local
```

After the container starts, open `http://localhost:8080` on your computer. This address runs your own copy of the app; it is not a hosted demo.

## Docker setup

The Dockerfile has two stages:

- The SDK image restores dependencies and builds the application.
- The ASP.NET runtime image runs the published files as a non-root user.

The project file is copied first so Docker can reuse the restore layer when only the source changes. Build outputs and editor files are excluded through `.dockerignore`.

The app listens on port 8080 inside the container. The run command maps it to port 8080 on your computer, with access limited to the local machine.

## API examples

```text
GET /api/color/blue    -> 200  {"color":"blue"}
GET /api/color/BLUE    -> 200  {"color":"blue"}
GET /api/color/purple  -> 400  {"message":"Invalid color"}
```

## Container commands

Check whether the container is running and view its logs:

```bash
docker ps
docker logs color-theme-app
```

Stop and remove it when finished:

```bash
docker stop color-theme-app
docker rm color-theme-app
```

After editing the source, build the image again and create a new container. If port 8080 is already in use, change the mapping to `127.0.0.1:8081:8080` and use port 8081 in your browser.
