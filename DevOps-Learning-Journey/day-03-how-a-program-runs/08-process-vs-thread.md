# Process vs. thread

## What is a process?

A process is a running instance of a program. The operating system gives it an address space, resources, and a process ID (PID).

Opening a command-line application starts a process. Running another instance can create a separate process using the same executable.

## What is a thread?

A thread is an execution path inside a process. One process can have multiple threads performing different work.

Threads share their process's memory and resources, but each has its own stack and execution state. A thread is not a separate application or a CPU core.

This builds on [Day 2's process and thread notes](../day-02-os-basics/02-processes-vs-threads.md).

## Detailed explanation

Starting a web API might create a process that uses a thread pool for request work. A background task can run within the same process. It is not necessarily another independently restartable service.

Asynchronous requests also do not each require a dedicated thread for their entire lifetime.

## Practical example

In Windows PowerShell:

```powershell
Get-Process -Id $PID
```

`$PID` is the current PowerShell process ID. The command inspects that process; it does not start or stop another application.

## DevOps scenario: restart affects background work

A web application sends email through a background worker inside the same process. Restarting the application also interrupts that worker. Determine whether unfinished work is durably queued and can resume; do not assume separate threads provide separate failure boundaries.

## Quick revision

- **Does a background thread survive its process exiting?** No.
- **Can multiple processes run the same executable?** Yes.
- **Are threads equivalent to CPU cores?** No; the OS schedules threads onto available cores.

## Reference

[Processes and threads - Microsoft Learn](https://learn.microsoft.com/en-us/windows/win32/procthread/about-processes-and-threads)

[Back to Day 3](README.md) | [Next: Exit codes](09-exit-codes.md)
