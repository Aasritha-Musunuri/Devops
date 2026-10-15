# CPU scheduling

## Question

How does an operating system decide which work gets CPU time? How would you investigate a slow Linux server?

## Short explanation

There are often more tasks ready to run than there are CPU cores available. The scheduler decides which runnable tasks execute and when they get CPU time.

## Answer

**CPU scheduling** is the kernel's process of selecting runnable tasks for execution on CPUs. Scheduling policies, priorities, CPU affinity, and resource controls influence that selection. Switching execution between tasks is called a **context switch**.

On Linux, threads are schedulable tasks. Scheduling distributes CPU time; it does not remove bottlenecks caused by slow storage, locks, or application bugs.

## Detailed explanation

### Running, runnable, and waiting

- **Running:** currently executing on a CPU.
- **Runnable:** ready to execute but waiting for CPU time.
- **Waiting:** unable to proceed until an event occurs, such as I/O completing.

A task waiting for a database response does not necessarily consume a CPU continuously.

### Context switching

To switch tasks, the OS saves the execution state of one task and restores another's. A simplified single-core example is:

```text
CPU runs task A -> switches to task B -> later resumes task A
```

With multiple cores, tasks can also execute in parallel. Excessive contention and switching can add overhead, so increasing worker counts is not always helpful.

### Priority and resource limits

For normal Linux scheduling policies, nice values range from `-20` to `19`. Lower values favor the task; higher values make it less favored. The effect depends on scheduling policy and task grouping, and it is not a fixed CPU reservation.

Containers can also have CPU quotas. A service may be throttled by its quota even when the host has spare CPU capacity.

## Practical example

In a Linux terminal:

```bash
nproc
uptime
ps -eo pid,comm,ni,pcpu --sort=-pcpu | head
top
```

- `nproc`: processing units available to the current process; environment constraints can affect the result.
- `uptime`: uptime and load averages for roughly 1, 5, and 15 minutes.
- `ps`: process IDs, names, nice values, and CPU usage. Its CPU percentage is a lifetime average, rather than an instant sample.
- `top`: continuously updated resource information. Press `q` to exit.

## DevOps scenario: high load, low CPU usage

On Linux, load average includes runnable tasks and tasks in uninterruptible sleep, commonly waiting for I/O. High load is therefore not proof of high CPU consumption.

1. Check the trend and available CPU capacity.
2. Use `top` to identify CPU-heavy work and examine task states.
3. Check storage latency, memory pressure, and application dependencies if CPU is not saturated.
4. For containers, inspect CPU limits and throttling metrics.
5. Choose a fix based on the evidence, then check whether latency and errors improve.

## Quick revision

- **Does every active process run simultaneously?** No. CPU capacity is limited.
- **Does high load always mean CPU saturation?** No. Linux load can include I/O waits.
- **Does raising priority create more CPU capacity?** No. It changes how existing capacity is shared.

## References

- [Scheduling policies and priorities - Linux manual](https://man7.org/linux/man-pages/man7/sched.7.html)
- [Load average - Linux manual](https://man7.org/linux/man-pages/man3/getloadavg.3.html)
- [ps CPU percentage behavior](https://man7.org/linux/man-pages/man1/ps.1.html)
- [Container CPU constraints - Docker Docs](https://docs.docker.com/engine/containers/resource_constraints/)

[Back to Day 2](README.md) | [Next: File system tree](06-file-system-tree.md)
