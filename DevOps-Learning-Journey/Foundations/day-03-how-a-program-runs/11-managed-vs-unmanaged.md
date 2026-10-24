# Managed vs. unmanaged code

**Module:** Foundations

**Topic:** How a program runs

## What is managed code?

Managed code runs under the services of a managed runtime, such as .NET. The runtime provides support including garbage collection for managed memory and exception handling.

A typical C# application uses this managed execution model.

## What is unmanaged code?

Unmanaged, or native, code executes outside that managed runtime model. Its components use their own memory and resource-management rules.

A native C or C++ library called by a C# application is a common example. One application can contain both managed and native components.

## Why does the distinction matter?

Installing .NET does not automatically provide every native library an application needs. Also, garbage collection does not automatically release every file handle or database connection promptly; those resources still need appropriate cleanup.

## Detailed explanation

“Managed” does not mean all cleanup happens automatically. Database connections, file handles, and sockets still need appropriate lifetimes and disposal. Garbage collection primarily handles managed memory, not every operational resource.

Likewise, native code is not inherently unsafe or poorly written. Libraries can use disciplined resource management; the distinction concerns execution and responsibility, not code quality.

## Practical example

A C# application processes images through a native library. Its deployment must include compatible native binaries and any required system libraries. Having .NET installed does not supply every third-party dependency.

## DevOps scenario: memory rises but the managed heap is stable

Investigate native allocations and resource handles as well as managed objects. A managed-heap metric measures only part of the process. Compare runtime diagnostics with operating-system or container metrics before concluding that the observations conflict.

## Quick revision

- **Can managed code call native code?** Yes, through interoperability mechanisms.
- **Does garbage collection automatically close every connection promptly?** No.

## References

- [Managed code](https://learn.microsoft.com/en-us/dotnet/standard/managed-code)
- [Cleaning up unmanaged resources](https://learn.microsoft.com/en-us/dotnet/standard/garbage-collection/unmanaged)

[Back to Day 3](README.md) | [Next: Environment variables](12-environment-variables-at-runtime.md)
