# Compiler vs. interpreter

**Module:** Foundations

**Topic:** How a program runs

## What is a compiler?

A compiler is a tool that translates source code into another form, such as machine code or intermediate code. The translation process is called **compilation**.

For example, the C# compiler commonly translates `.cs` files into an assembly containing intermediate language (IL).

## What is an interpreter?

An interpreter is a program that executes code through a software engine. It can work with source code or an intermediate representation, depending on the implementation.

For example, the standard Python implementation, CPython, compiles source into bytecode and then executes that bytecode in its interpreter.

## How are they different?

A compiler translates code; an interpreter executes instructions through an engine. These approaches can work together in the same language implementation. An interpreter does not necessarily read and execute source one line at a time.

## Detailed explanation

Two useful examples:

- C# commonly compiles to intermediate language, then uses the .NET JIT compiler during execution.
- CPython compiles Python source to bytecode and executes it in its interpreter.

Calling a language “compiled” or “interpreted” is shorthand. The implementation and deployment mode determine the actual execution path.

## Practical example

Consider a Python automation script and a C# web API. The script needs a suitable Python interpreter and its dependencies. A framework-dependent C# deployment needs a compatible .NET runtime.

Neither requirement is satisfied merely by copying the files onto a server.

## DevOps scenario: works locally, fails in CI

A Python script succeeds on a laptop but fails on the runner. Compare interpreter versions and installed packages before assuming the source is wrong. A C# compiler error, by contrast, belongs to the build stage; an application startup error happens later.

## Quick revision

- **Does interpreted mean no compilation occurs?** No; CPython uses bytecode compilation.
- **Does compilation always produce machine code?** No; it can produce intermediate code.

## References

- [Python glossary: bytecode and interpreter](https://docs.python.org/3/glossary.html)
- [.NET managed code](https://learn.microsoft.com/en-us/dotnet/standard/managed-code)

[Back to Day 3](README.md) | [Next: Compilation](03-compilation.md)
