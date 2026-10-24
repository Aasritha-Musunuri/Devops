# Linking

**Module:** Foundations

**Topic:** How a program runs

## What is linking?

Linking is the step that connects compiled pieces of a program and resolves references between them, such as a call to a function supplied by a library.

A **linker** is the tool that performs this step in a native build. For example, it can combine object files into an executable and connect the application with the libraries it needs.

With **static linking**, needed library code is included in the output. With **dynamic linking**, the program depends on shared libraries that must be available when they are loaded for execution.

This is why an application can build successfully but still fail to start when a required shared library is missing.

## Detailed explanation

Suppose an application calls a function provided by another library:

```text
Application object file + library -> linked application
```

An undefined-symbol error during linking differs from a shared-library loading error at startup. Both involve dependencies, but they occur at different stages.

.NET also resolves assembly dependencies, but its managed assembly model should not be treated as identical to native linking.

## Practical example

Read an illustrative Linux startup error:

```text
error while loading shared libraries: libexample.so: cannot open shared object file
```

The application cannot load a required library. This does not mean its source failed to compile.

## DevOps scenario: failure in a smaller container

An application runs on a build agent but fails in its runtime container. Check whether the image contains compatible native libraries. Adding the build tools alone is not a reliable fix; identify the actual runtime dependency and package it correctly.

## Quick revision

- **Does a successful build eliminate runtime dependencies?** No.
- **Are all dependencies copied inside every executable?** No; packaging and linking choices matter.

## References

- [GCC compilation and linking stages](https://gcc.gnu.org/onlinedocs/gcc/Invoking-GCC.html)
- [Linux dynamic loader](https://man7.org/linux/man-pages/man8/ld.so.8.html)

[Back to Day 3](README.md) | [Next: Machine code](05-machine-code.md)
