# Source code

**Module:** Foundations

**Topic:** How a program runs

## What is source code?

Source code is the set of instructions a developer writes in a programming language. It is written so people can read and change it.

For example, `Program.cs` contains C# source code, while `app.py` contains Python source code. These instructions describe what the program should do, such as accept a request or calculate a total.

Source code is not always the file deployed to a server. A build may turn it into an executable, an assembly, or a package. Some applications deploy source files together with the interpreter needed to run them.

## Detailed explanation

For a C# service, the repository might contain:

```text
Program.cs         application instructions
Orders.csproj      project settings and dependency references
appsettings.json   application configuration
```

These files serve different purposes. Configuration affects behavior, but is not the same as the application instructions.

## Practical example

In an existing C# project, open `Program.cs` in the editor. Locate where the application starts and compare it with the files in a published release folder. Reading the file does not run the application.

No project is required for this lesson: the file names above illustrate the distinction.

## DevOps scenario: which code is deployed?

A fix exists in Git, but production still shows the old behavior. Check which commit produced the deployed artifact, whether the build included the fix, and which artifact was released. Changing source in Git does not automatically replace a running application.

## Quick revision

- **Does a commit deploy the application?** Only if an associated workflow performs that deployment.
- **Must every production server contain source code?** No. It depends on the application and packaging.

## Reference

[.NET application publishing](https://learn.microsoft.com/en-us/dotnet/core/deploying/)

[Back to Day 3](README.md) | [Next: Compiler vs. interpreter](02-compiler-vs-interpreter.md)
