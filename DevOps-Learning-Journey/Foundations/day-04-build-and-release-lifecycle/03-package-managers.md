# Package managers: NuGet, npm, and pip

**Module:** Foundations

**Topic:** Build and release lifecycle

## What is a package?

A package is a bundle of software files, usually with a name, a version, and information about other packages it needs.

For example, a PDF library can be distributed as a package.

## What is a package manager?

A package manager is a tool that helps obtain and manage these packages. It saves the developer from manually finding and copying every library file.

Common examples are:

- **NuGet:** used for .NET packages.
- **npm:** commonly used for JavaScript and Node.js projects.
- **pip:** used to install Python packages.

## Example: an application needs a PDF library

The project records which package it needs. The package manager finds that package and resolves any additional packages required by it.

The developer still needs to choose suitable packages and test that the application works with them.

**Package = the bundle. Package manager = the tool that gets and manages it.**

## Does getting a package also provide the service?

Not necessarily. A database library helps the application communicate with a database. Installing that library does not create the database or give the application permission to use it.

**The library helps make the call. The service must still be available.**

## What is restore?

Restore means resolving and obtaining the packages recorded for a project, so the next steps can use them.

```text
Get source code -> restore packages -> build application
```

For .NET, `dotnet restore` is the command for this work. You do not need to run it in this notes folder; there is no application project here.

## Real example: restore fails in the pipeline

A pipeline is an automated sequence of tasks. It tries to download a package from a private package source, but access is denied.

**What to check:** Read the restore error, confirm the package source, and check the pipeline's permission to download it.

This is a package-access problem, not necessarily a problem with the application code.

## Why might it work on the laptop?

The laptop may already have a downloaded copy in its **cache**, which is local storage used to reuse files.

A fresh pipeline machine needs to download the package and may discover missing access or a network problem.

**A cached package can hide a download problem.**

## Further reading

[NuGet package restore](https://learn.microsoft.com/en-us/nuget/consume-packages/package-restore)

[Back to Day 4](README.md) | [Next: Semantic versioning](04-semantic-versioning.md)
