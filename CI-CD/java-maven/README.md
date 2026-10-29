# Java build with Maven

A small shipping calculator built with Java 21. Orders below Rs 500 have a Rs 50 shipping charge. Orders of Rs 500 or more have free shipping. Negative amounts are rejected.

The GitHub Actions workflow builds the application, runs the tests, checks the packaged program, and saves the JAR and test reports.

## Build and run locally

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
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Maven compiles the source, runs the five tests, and creates `target/shipping-quote-1.0.0.jar`. Download messages are normal: Maven fetches the libraries and build tools it needs. Without a persistent Maven cache, this command downloads dependencies into each new container.

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

This is a terminal application; the result prints in PowerShell. Use whole rupees. Negative amounts, decimals, and missing arguments return an error.

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
- `src/test/java/`: five unit tests covering the shipping rule.
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

In GitHub, open **Actions > Java Maven build**. Changes to this project trigger a run. You can also select **Run workflow** on the main branch.

A failed test stops the build from producing a successful release artifact. Test reports are uploaded even when tests fail, if Maven has generated them. Download the JAR from the successful run's **Artifacts** section to run it with Java 21 or later.

This first exercise covers continuous integration and artifact delivery. It does not deploy to a persistent server. Deployment, SAST, and DAST are separate steps we can add as the practice progresses.

## Maven in a few words

Java is the language. The JDK supplies the compiler and runtime. Maven manages the build and downloads declared dependencies. JUnit is the test library downloaded for this project.

`mvn clean verify` removes old output, compiles the Java code, runs the tests, packages the JAR, and completes verification. Maven executes the earlier lifecycle phases in order.

A JAR is a Java archive, roughly comparable to the packaged output of a .NET application. It needs a compatible Java runtime to execute.

References: [Maven introduction](https://maven.apache.org/what-is-maven.html), [Maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html), [GitHub Java setup](https://github.com/actions/setup-java).
