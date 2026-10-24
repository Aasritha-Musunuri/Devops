# Day 4: Build and release lifecycle

**Module:** Foundations

How an application goes from code written by a developer to something people can use.

## Topics

1. [Source, build, artifact, package, deploy, and run](01-source-to-running-application.md)
2. [Dependencies](02-dependencies.md)
3. [Package managers: NuGet, npm, and pip](03-package-managers.md)
4. [Semantic versioning](04-semantic-versioning.md)
5. [Development, test, staging, and production](05-application-environments.md)
6. [Configuration per environment](06-configuration-per-environment.md)
7. [Mapping the lifecycle to CI/CD stages](07-lifecycle-in-cicd.md)

## The overall picture

```text
Get code -> get the libraries it needs -> build -> test
         -> pack and save -> deploy -> run -> check
```

A saved package is an artifact. Some tools do several of these steps together.

The examples follow a shopping application, with discounts, invoices, orders, and payments.

## Examples

Each topic starts with what it means, uses a familiar example, and explains a problem that can happen at work. No installations or cloud account are needed.

[Learning journey](../../README.md) | [Day 3: How a program runs](../day-03-how-a-program-runs/README.md)
