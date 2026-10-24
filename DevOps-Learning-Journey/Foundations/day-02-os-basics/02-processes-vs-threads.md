# Processes vs. threads

**Module:** Foundations

**Topic:** OS basics

## Question

What is the difference between a process and a thread? How does this help with troubleshooting?

## Short explanation

A process is a running instance of a program. A thread is an execution path inside that process. One process can have several threads doing different pieces of work.

## Answer

A **process** has an address space and operating-system resources. A **thread** executes within a process. Threads in the same process share memory and resources such as open files, but each thread has its own stack and execution state.

Separate processes normally have separate address spaces. They can communicate through mechanisms such as sockets, pipes, or explicitly shared memory.

## Detailed explanation

### Program vs. process

A program is code stored on disk. Starting it creates a process. Starting the same program again can create another process with a different **process ID (PID)**.

For example, two separate runs of a command-line application can use the same executable while maintaining their own runtime state.

### Why have multiple threads?

Imagine a web API process with work to do:

```text
Web API process
  Thread A: handles some request work
  Thread B: performs another computation
  Thread C: performs background work
```

This is a simplified example. Applications may also use asynchronous I/O and thread pools; one request does not always require one dedicated thread.

**Concurrency** means tasks can make progress during the same period. **Parallelism** means tasks execute at the same time on multiple CPU cores. Multiple threads can be concurrent even when only one core is available.

### What can go wrong?

Sharing memory makes communication convenient, but concurrent updates need coordination. A race condition can produce incorrect results; a deadlock can leave threads waiting for each other.

An unhandled fatal fault in one thread can terminate the whole process. Threads are not independent crash-isolation boundaries.

## Practical example

In Linux, list processes and their thread counts:

```bash
ps -eo pid,comm,nlwp --sort=-nlwp | head
```

- `pid`: process ID.
- `comm`: command name.
- `nlwp`: number of threads, also called lightweight processes in this output.
- `--sort=-nlwp`: places larger thread counts first.

In PowerShell on Windows:

```powershell
Get-Process -Id $PID | Select-Object Id, ProcessName,
    @{Name='ThreadCount'; Expression={$_.Threads.Count}}
```

`$PID` identifies the current PowerShell process. Thread counts can change while a program runs.

## DevOps scenario: one busy thread

A service responds slowly. Process-level CPU metrics show activity, but you need to know whether one thread is consuming most of the CPU.

On Linux, select a PID from `ps`, then replace `1234` below with that actual PID:

```bash
top -H -p 1234
```

`-H` displays threads and `-p` selects the process. Press `q` to exit. Correlate the busy thread with application diagnostics and logs. Adding threads does not automatically fix a bottleneck caused by a lock or a serial computation.

## Quick revision

- **Can one program have multiple processes?** Yes.
- **Do threads share all their state?** No. They share process resources but keep their own execution state and stacks.
- **Does more threads always mean faster?** No. Coordination costs, contention, and CPU capacity matter.

## References

- [Processes and threads - Microsoft Learn](https://learn.microsoft.com/en-us/windows/win32/procthread/about-processes-and-threads)
- [POSIX threads - Linux manual](https://man7.org/linux/man-pages/man7/pthreads.7.html)
- [ps command reference](https://man7.org/linux/man-pages/man1/ps.1.html)

[Back to Day 2](README.md) | [Next: RAM vs. disk](03-ram-vs-disk.md)
