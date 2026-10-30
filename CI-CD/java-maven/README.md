# Java build with Maven

A shipping calculator with a webpage and a Java 21 backend. Orders below Rs 500 have a Rs 50 shipping charge. Orders of Rs 500 or more have free shipping. Negative amounts are rejected.

The GitHub Actions workflow builds the application, runs the tests, checks the packaged program, and saves the JAR and test reports.

## Build and run locally

### Open the website with Docker

With Docker Desktop running in Linux container mode, open PowerShell in this project folder:

```powershell
docker build -t shipping-quote:local .
docker run -d --name shipping-quote -p 127.0.0.1:8082:8080 shipping-quote:local
```

Open **http://localhost:8082** on the same computer. Enter an amount or choose an example, then calculate the shipping charge. The page calls the Java API and displays the order amount, shipping, and total. It does not place an order or take payment.

The Docker build runs all 11 tests. The final container contains the Java runtime and application JAR and runs as a non-root user.

Check the server with `docker logs shipping-quote`. Stop and remove it with:

```powershell
docker stop shipping-quote
docker rm shipping-quote
```

After changing the source, rebuild the image and replace the container. If port 8082 is busy, choose another host port, such as `127.0.0.1:8083:8080`.

### Build without creating an application image

Start Docker Desktop and wait until the engine is running. Use Linux containers. These commands run Java and Maven inside Docker, so neither needs to be installed on your computer.

Open PowerShell at the root of your cloned repository, then enter the project folder:

```powershell
cd CI-CD/java-maven
```

### Build and test

```powershell
docker run --rm --mount "type=bind,source=$($PWD.Path),target=/workspace" -w /workspace maven:3.9.9-eclipse-temurin-21 mvn clean verify
```

Look for these lines in the output:

```text
Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Maven compiles the source, runs the tests, and creates `target/shipping-quote-1.0.0.jar`. Download messages are normal: Maven fetches the libraries and build tools it needs. Without a persistent Maven cache, this command downloads dependencies into each new container.

### Run the application

```powershell
docker run --rm --mount "type=bind,source=$($PWD.Path),target=/workspace" -w /workspace maven:3.9.9-eclipse-temurin-21 java -jar target/shipping-quote-1.0.0.jar 499
```

Expected output:

```text
Order total: Rs 499
Shipping: Rs 50
```

Run the same command with `500` instead of `499`:

```powershell
docker run --rm --mount "type=bind,source=$($PWD.Path),target=/workspace" -w /workspace maven:3.9.9-eclipse-temurin-21 java -jar target/shipping-quote-1.0.0.jar 500
```

```text
Order total: Rs 500
Shipping: Rs 0
```

With an amount argument, the application runs in terminal mode and prints its result in PowerShell. Without arguments, it starts the web server on port 8080. Use whole rupees. Negative amounts and decimals return an error. Running the JAR without arguments starts the web server.

The mount shares the current project folder with the container at `/workspace`. The generated JAR stays in your local `target/` folder even after `--rm` removes the container. After changing the source, run the build command again before running the JAR.

### With Java and Maven installed

If you already have JDK 21 and Maven 3.9, run these from the same folder without Docker:

```powershell
mvn clean verify
java -jar target/shipping-quote-1.0.0.jar 499
```

## Files

- `pom.xml`: project name, version, dependency, and build plugin configuration.
- `src/main/java/`: application code.
- `src/test/java/`: calculator and HTTP tests.
- `../../.github/workflows/java-maven.yml`: pipeline definition at the repository root.
- `target/shipping-quote-1.0.0.jar`: generated runnable application, excluded from source control.

## Pipeline

```text
Push or pull request
        |
Check out code
        |
Set up Java and restore Maven cache
        |
Compile -> unit tests -> package JAR
        |
Run the JAR and check its output
        |
Save JAR and test reports
```

In GitHub, open **Actions > Java Maven CI/CD**. Changes to this project trigger a run. You can also select **Run workflow** on the main branch.

A failed test stops the build from producing a successful release artifact. Test reports are uploaded even when tests fail, if Maven has generated them. Download the JAR from the successful run's **Artifacts** section to run it with Java 21 or later.

## Local deployment

The build job runs on a GitHub-hosted Ubuntu runner. After it passes on `main`, the deployment job runs on a Windows self-hosted runner connected to this repository. Pull requests only run the build job.

The deployment job downloads the tested JAR from the same workflow run. `Dockerfile.deploy` packages that JAR with the Java runtime; it does not compile the source again. `deploy.ps1` tags the image with the commit SHA, replaces the `shipping-quote` container, and checks the health endpoint, webpage, and shipping calculation. If those checks fail, it attempts to restore the previous container.

Open **http://localhost:8082** on the runner's computer to use the deployed website. Docker publishes the port only on that machine's loopback interface. This is a local deployment, not a public website.

Keep Docker Desktop and the runner's `run.cmd` terminal open during practice. If the runner is offline, deployment waits in GitHub Actions. Stopping the runner does not stop an already running application container. To disconnect the runner while it is idle, press Ctrl+C in its terminal.

To see which image is running:

```powershell
docker inspect shipping-quote --format '{{.Config.Image}}'
```

The image tag should match the commit SHA in the workflow run. SAST, DAST, and infrastructure configuration with Ansible are not included yet.

## Maven in a few words

Java is the language. The JDK supplies the compiler and runtime. Maven manages the build and downloads declared dependencies. JUnit is the test library downloaded for this project.

`mvn clean verify` removes old output, compiles the Java code, runs the tests, packages the JAR, and completes verification. Maven executes the earlier lifecycle phases in order.

A JAR is a Java archive, roughly comparable to the packaged output of a .NET application. It needs a compatible Java runtime to execute.

References: [Maven introduction](https://maven.apache.org/what-is-maven.html), [Maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html), [GitHub Java setup](https://github.com/actions/setup-java).
