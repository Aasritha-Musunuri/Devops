# Runtime

## What is a runtime?

A runtime is the software support an application uses while it executes. Depending on the platform, it can provide services such as loading code, managing memory, and handling exceptions.

For example, a framework-dependent .NET application needs a compatible .NET runtime on its target machine.

## What is an SDK?

An SDK, or Software Development Kit, contains tools for developing and building applications. The .NET SDK includes build tools and runtime components; a runtime installation alone does not provide all the development tools.

```text
SDK = tools to develop and build the application
Runtime = support to execute the application
```

A self-contained .NET deployment includes its .NET runtime, but still has operating-system and platform requirements.

## Detailed explanation

“Runtime” can mean the execution software or the period when a program is running. In deployment discussions, clarify which meaning is intended.

Building on a machine with an SDK does not prove the target server has what the published application needs. Web applications may need the ASP.NET Core runtime rather than only the base .NET runtime.

## Practical example

If `dotnet` is installed, inspect its environment:

```powershell
dotnet --list-sdks
dotnet --list-runtimes
```

These commands list installed SDKs and runtimes without creating a project. If the command is unavailable, inspect the deployment documentation instead; no installation is required for this lesson.

## DevOps scenario: app will not start

A framework-dependent app reports a missing framework. Compare its target framework with installed runtimes and the supported version-selection rules. Avoid assuming any newer runtime will automatically satisfy the requirement.

## Quick revision

- **Does a production host always need the SDK?** No.
- **Does self-contained mean independent of the OS?** No.

## Reference

[.NET deployment modes](https://learn.microsoft.com/en-us/dotnet/core/deploying/)

[Back to Day 3](README.md) | [Next: Stack vs. heap](07-stack-vs-heap.md)
