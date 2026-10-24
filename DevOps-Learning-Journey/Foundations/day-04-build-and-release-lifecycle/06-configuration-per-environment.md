# Configuration per environment

**Module:** Foundations

**Topic:** Build and release lifecycle

## What is configuration?

Configuration is the settings an application uses, such as its database address or how much detail to write in logs.

## Why use different settings?

The same application can run in testing, staging, and production, but it should not connect to the same systems in every environment.

```text
Testing:    DB_HOST=test-database
Staging:    DB_HOST=staging-database
Production: DB_HOST=production-database
```

`DB_HOST` is an example name. The application must be written to read it.

**The application code stays the same. The database setting changes.**

The application may have the correct database library but still fail to connect because the database address or password is wrong. This is why dependency checks and configuration checks belong together.

Think of a delivery driver: the job stays the same, but the delivery address changes.

## What other settings can change?

- **Logging:** more detail for investigation, with an appropriate level in production.
- **Payments:** a sandbox for testing and a live payment account in production. A sandbox is a test system, rather than the real payment system.
- **Feature flags:** settings that turn a feature on or off without necessarily changing the application code.

## How do we supply settings?

Applications can read configuration files, environment variables, or a configuration service. The application decides which setting takes priority if several places provide it.

Passwords need secure handling, such as a secret-management service. Do not save production passwords in Git or inside the application package.

## Real example: production uses the payment sandbox

**Possible cause:** Production received the test payment settings.

**What to do:** Confirm the actual address and account being used, correct the settings, and reload or restart as required. Verify the payment flow.

Investigate affected transactions before retrying them. A failed response does not prove that no payment happened; retrying blindly can cause duplicate charges.

## Should we rebuild for each environment?

Usually, prefer the same tested application package and supply the correct settings for each environment.

## What to remember

**Code describes the work. Configuration provides the settings.**

## Further reading

[Configuration in ASP.NET Core](https://learn.microsoft.com/en-us/aspnet/core/fundamentals/configuration/)

[Back to Day 4](README.md) | [Next: CI/CD stages](07-lifecycle-in-cicd.md)
