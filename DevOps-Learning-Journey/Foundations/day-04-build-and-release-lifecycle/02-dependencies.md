# Dependencies

**Module:** Foundations

**Topic:** Build and release lifecycle

## What is a dependency?

**A dependency is something your application relies on to work.**

Think of making tea: you depend on water, tea leaves, and a heat source. If one is missing, you may not be able to make it.

Applications have two common kinds of dependencies.

## 1. Code dependencies: libraries your application uses

**Example:** A .NET application uses a PDF library to generate invoices.

A library is reusable code that helps the application perform a task. Developers use the PDF library instead of writing all the PDF-generation code themselves.

**If it is missing or incompatible:** Invoice generation—or application startup—may fail.

**Solution:** Include the correct library version in the application's published package, as required by its deployment setup.

## 2. Service dependencies: systems your application communicates with

**Examples:** A database, payment service, or email service.

**If one is unavailable:** The application may still run, but the feature requiring that service can fail.

**Solution:** Check the service's availability, network access, credentials, and configuration.

For example, a database address tells the application where to connect. Credentials, such as a username and password, help it prove that it is allowed to connect.

## Production scenario: the website opens, but checkout fails

One possible cause is an unavailable payment service.

The website's process is running, but **checkout depends on another service**. Check the checkout error and payment-service response before changing or restarting the website.

The home page opening successfully does not prove that checkout, email, and database operations all work.

## Interview edge case: can updating a library break an application?

**Yes.** A new version may change behavior or remove functionality the application uses.

**Solution:** Use controlled dependency versions and test updates before production deployment. Read the release notes to understand what changed.

## What if a library needs another library?

Those additional libraries are called **transitive dependencies**.

```text
Shopping application needs library A
Library A needs library B
```

The package manager usually helps obtain both. Library B can affect the application even though the developer did not choose it directly.

## What to remember

**Libraries are dependencies you use in your code. Services are dependencies you call over a network.**

Next are **package managers**: tools that help obtain and manage code dependencies, such as NuGet, npm, and pip.

## Further reading

[How NuGet handles package dependencies](https://learn.microsoft.com/en-us/nuget/concepts/dependency-resolution)

[Back to Day 4](README.md) | [Next: Package managers](03-package-managers.md)
