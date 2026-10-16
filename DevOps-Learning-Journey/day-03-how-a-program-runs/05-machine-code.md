# Machine code

## What is machine code?

Machine code is the encoded set of instructions a CPU can execute directly. Those instructions follow a particular CPU architecture, such as x86-64 or ARM64.

Developers usually write source code instead of machine instructions. A compiler or runtime helps turn that code into work the CPU can perform.

```text
Source code = instructions written for people to work with
Machine code = instructions encoded for a particular CPU
```

An interpreter itself also runs as native instructions while carrying out the program's operations. C# intermediate language is not the same as CPU machine code.

## Detailed explanation

A binary built for one CPU architecture cannot generally run directly on another. The operating system, executable format, and library requirements also matter.

```text
Linux ARM64 executable != Windows x64 executable
```

Emulation and multi-platform tooling can bridge some differences, but compatibility should be checked explicitly.

## Practical example

On Linux:

```bash
uname -m
```

This reports the machine architecture visible to the running environment. Common results include `x86_64` and `aarch64`. It does not establish whether a particular application or image supports that architecture.

## DevOps scenario: executable format error

A container works on an ARM laptop but fails on an x64 deployment host. Compare the image platform and the executable's target architecture. Also inspect the entrypoint: an invalid script interpreter or file format can cause startup failures too.

Choose a supported platform build rather than renaming the executable or assuming that all Linux binaries are interchangeable.

## Quick revision

- **Is C# IL the same as CPU machine code?** No.
- **Does matching architecture guarantee compatibility?** No; the OS and dependencies also matter.

## References

- [Multi-platform container builds](https://docs.docker.com/build/building/multi-platform/)
- [uname command](https://www.gnu.org/software/coreutils/manual/html_node/uname-invocation.html)

[Back to Day 3](README.md) | [Next: Runtime](06-runtime.md)
