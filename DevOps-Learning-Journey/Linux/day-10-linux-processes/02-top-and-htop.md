# top and htop: watch resource usage

**Module:** Linux

**Topic:** Linux processes

## What is top and htop?

`top` is an updating view of system and process activity. `htop` is an alternative interactive process viewer that may need to be installed separately.

If `ps` is a photograph, `top` is a live scoreboard that refreshes while the match is happening.

## Why does this matter in DevOps?

Look for CPU-heavy processes, memory pressure, and changes while reproducing a performance issue. A trend is more useful than a single unexplained number.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
top
```

On common Linux versions, `P` sorts by CPU use and `M` by memory use. Read the header as well as process rows. If htop is installed, run `htop` and use its on-screen help. You do not need to install it to understand the lesson.

**What you should see:**

```text
A live process view opens. Press q to leave it.
```

## Real scenario: The website is slow, but CPU usage is low.

The application could be waiting for a database, network, disk, or lock. Check request latency, logs, dependency timings, and resource pressure. Adding CPU or more threads will not necessarily fix waiting on another system.

## Important detail

On multicore Linux systems, a multithreaded process can show more than 100% CPU in common display modes. Also, low “free” RAM alone is not enough to diagnose a memory problem: Linux uses RAM for reclaimable caches. Check available memory, limits, swapping, and workload evidence.

## What to remember

**Watch the pattern, then connect it to the user’s symptom.**

## Further reading

[Linux command reference](https://gitlab.com/procps-ng/procps/-/blob/master/man/top.1)

[Previous: ps: take a snapshot of processes](01-ps.md) | [Next: kill: send a signal to a process](03-kill.md)
