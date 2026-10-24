# Day 10: Linux processes

**Module:** Linux

See what is running, understand signals, and control your own terminal jobs without confusing them with managed services.

## Topics

1. [ps: take a snapshot of processes](01-ps.md)
2. [top and htop: watch resource usage](02-top-and-htop.md)
3. [kill: send a signal to a process](03-kill.md)
4. [SIGTERM versus SIGKILL](04-sigterm-vs-sigkill.md)
5. [Background jobs: what the ampersand does](05-background-jobs.md)
6. [jobs: list this shell’s jobs](06-jobs.md)
7. [nohup: ignore hangup for a command](07-nohup.md)
8. [fg and bg: resume a paused job](08-foreground-and-bg.md)
9. [Zombie and orphan processes](09-zombie-and-orphan-processes.md)

## Before starting

Use an interactive Bash terminal. Timer examples create a harmless sleep process and capture its PID; they do not target an application service. Ctrl+C, Ctrl+Z, jobs, fg, and bg describe your terminal session, while a service manager controls production application lifecycles.

## The connection to real work

A process can exist without serving customers successfully. Inspect its state, follow its logs, and use the lifecycle owner’s controls before assuming that killing it is the fix.

[Learning journey](../../README.md)
