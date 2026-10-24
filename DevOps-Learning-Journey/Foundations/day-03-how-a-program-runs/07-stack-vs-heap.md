# Stack vs. heap memory

**Module:** Foundations

**Topic:** How a program runs

## What is stack memory?

A thread's stack keeps track of its active function calls and the execution data associated with them. A call adds a stack frame, and returning from the call removes that frame.

For example, if function A calls function B, the stack helps the program return to the correct place in A when B finishes.

## What is heap memory?

A heap is an area used for dynamically allocated data. That data can remain available after the function that created it has returned, provided its lifetime is managed correctly.

In .NET, garbage collection reclaims ordinary managed heap objects once they are no longer reachable.

## What is the difference?

The stack tracks calls for a thread. The heap holds dynamically allocated data that can be accessed through references within the process. Exact storage choices depend on the language, runtime, and optimizations.

## Detailed explanation

Avoid the shortcut “all value types live on the stack.” Placement depends on context and implementation. A value-type field can be stored inside a heap object, and optimizations may change storage choices.

For troubleshooting, the more useful distinction is what grows and why:

- Calls that recurse too deeply can exhaust a thread's stack.
- Objects retained unnecessarily can make the managed heap grow.

## Practical example

Consider a service that keeps every processed request in an ever-growing collection. Those objects remain reachable, so garbage collection cannot simply discard them. This is a design problem even though memory is managed automatically.

## DevOps scenario: increasing memory use

Check process and container memory trends, application logs, and relevant runtime diagnostics. Overall memory includes more than the managed heap: stacks, native allocations, and other mappings also contribute. A higher memory limit may buy time but does not identify the cause.

## Quick revision

- **Does garbage collection prevent every memory leak?** No.
- **Is stack overflow the same as running out of heap memory?** No.

## References

- [.NET garbage collection fundamentals](https://learn.microsoft.com/en-us/dotnet/standard/garbage-collection/fundamentals)
- [Stack and heap allocation nuances](https://devblogs.microsoft.com/dotnet/allocating-on-the-stack-or-the-heap/)

[Back to Day 3](README.md) | [Next: Process vs. thread](08-process-vs-thread.md)
