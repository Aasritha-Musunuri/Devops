# .NET CLR, JIT, and MSIL

## What is the CLR?

CLR means **Common Language Runtime**. It is the .NET execution engine, providing services such as managed memory management and exception handling.

## What is IL or MSIL?

IL means **Intermediate Language**. It is also called CIL (Common Intermediate Language), or historically MSIL (Microsoft Intermediate Language).

The C# compiler commonly produces an assembly containing IL and metadata. IL is an intermediate form of the program, not native CPU instructions.

## What is the JIT compiler?

JIT means **Just-In-Time**. In a typical JIT-based .NET application, the JIT compiler translates IL into native machine code during execution, as methods are needed.

```text
C# compiler: C# source -> IL
JIT compiler: IL -> native machine code
```

These are two different translation stages. Not every .NET deployment uses JIT; Native AOT compiles native code before deployment.

## Detailed explanation

```text
Program.cs -> C# compiler -> assembly with IL
           -> runtime and JIT -> native code -> CPU
```

An assembly often has a `.dll` extension, but an extension alone does not tell you whether a file contains managed or native code.

The CLR is not the C# language compiler. Also, not every .NET deployment uses this exact path: Native AOT produces native code ahead of execution.

## Practical example

When reading a build log, distinguish a compiler failure from an exception logged after the application starts. Both may mention .NET, but they point to different stages.

## DevOps scenario: startup is slow

A fresh instance takes longer on its first requests. JIT compilation can contribute, but so can dependency calls, cache initialization, and configuration loading. Use startup timing and logs rather than blaming JIT without evidence.

## Quick revision

- **Are MSIL and CIL different CPUs?** No; they are terms for intermediate language.
- **Is IL itself native CPU code?** No.

## References

- [.NET managed execution process](https://learn.microsoft.com/en-us/dotnet/standard/managed-execution-process)
- [Native AOT](https://learn.microsoft.com/en-us/dotnet/core/deploying/native-aot/)

[Back to Day 3](README.md) | [Next: Managed vs. unmanaged](11-managed-vs-unmanaged.md)
