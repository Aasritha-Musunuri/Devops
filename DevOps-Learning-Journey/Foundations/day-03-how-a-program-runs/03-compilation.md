# Compilation

**Module:** Foundations

**Topic:** How a program runs

## What is compilation?

Compilation is the process of translating source code into another form that later tools or an execution engine can use. A **compiler** is the tool that performs this process.

```text
Compiler = the tool
Compilation = the translation process
```

During compilation, the compiler checks language rules and can report problems such as invalid syntax or an unknown method name. The output may be machine code, object code, or intermediate code, depending on the toolchain.

For example, C# source commonly compiles into IL. That successful compilation does not prove that the running application can connect to its database.

## Detailed explanation

Imagine a developer calls a method that does not exist. A C# compiler can reject that source during the build. A database outage, however, normally becomes visible only when the application tries to connect.

A successful compilation is therefore not proof that the application behaves correctly. Tests and deployment health checks address different questions.

## Practical example

If the .NET SDK is installed, run this from an existing C# project folder:

```powershell
dotnet build
```

This builds the project and normally restores dependencies if needed. It can create `bin` and `obj` folders and access package feeds. It does not deploy the application. Read the error messages and the final build summary.

## DevOps scenario: build failure

Check the failing stage. A dependency download error can indicate feed access or authentication problems; a compiler error can indicate invalid source or incompatible references. Fix the reported cause rather than repeatedly rerunning the pipeline.

## Quick revision

- **Does build success prove the app can connect to its database?** No.
- **Is dependency restore the same as compilation?** No, though a build command can perform both.

## Reference

[dotnet build](https://learn.microsoft.com/en-us/dotnet/core/tools/dotnet-build)

[Back to Day 3](README.md) | [Next: Linking](04-linking.md)
