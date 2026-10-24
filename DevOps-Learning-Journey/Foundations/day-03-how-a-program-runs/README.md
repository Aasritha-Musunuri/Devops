# Day 3: How a program runs

**Module:** Foundations

Week 1 - Foundations. From source code to a running application, following Day 3 of the preparation plan.

A successful build does not guarantee a successful deployment. The application still needs compatible dependencies, the right runtime, configuration, and enough resources. These topics explain where each part fits.

## Topics

1. [Source code](01-source-code.md)
2. [Compiler vs. interpreter](02-compiler-vs-interpreter.md)
3. [Compilation](03-compilation.md)
4. [Linking](04-linking.md)
5. [Machine code](05-machine-code.md)
6. [Runtime](06-runtime.md)
7. [Stack vs. heap memory](07-stack-vs-heap.md)
8. [Process vs. thread](08-process-vs-thread.md)
9. [Exit codes](09-exit-codes.md)
10. [.NET CLR, JIT, and MSIL](10-dotnet-clr-jit-msil.md)
11. [Managed vs. unmanaged code](11-managed-vs-unmanaged.md)
12. [Environment variables at runtime](12-environment-variables-at-runtime.md)

## The overall picture

For a typical C# application using JIT compilation:

```text
C# source -> compiler -> assembly containing IL and metadata
         -> .NET runtime -> JIT -> native instructions -> CPU
```

Other languages and deployment modes use different paths. Native AOT, for example, compiles native code before deployment.

## Examples

Start with the explanation, then read the practical example and troubleshooting scenario. Commands are deliberately short, with their purpose explained alongside them.

- `bash` examples run in Linux, such as Ubuntu in WSL.
- `powershell` examples run in PowerShell on Windows.
- .NET inspection commands need .NET installed. Compilation examples also need the SDK and an existing project; they are optional.
- Illustrative logs and scenarios are examples, not recorded results from this computer.
- No cloud resources, installations, or deployments are needed to read these notes.

[Learning journey](../../README.md) | [Day 2: OS basics](../day-02-os-basics/README.md)
