# Zombie and orphan processes

**Module:** Linux

**Topic:** Linux processes

## What is Zombie and orphan processes?

A zombie is a process that has exited but still has an exit-status record waiting for its parent to collect. An orphan is a process whose parent exited before it; the orphan can still be running.

A zombie is a finished job with uncollected paperwork. An orphan is an unfinished job whose original supervisor has left.

## Why does this matter in DevOps?

Explain unusual process states and parent relationships during incident investigation. These terms describe different lifecycle situations, not two names for a busy application.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
ps -eo pid,ppid,stat,comm
```

PID is the process ID, PPID its current parent ID, and STAT includes its state. The command only inspects processes; there is no need to deliberately create zombies. A non-Z process with an adoptive parent is not automatically faulty.

**What you should see:**

```text
Process rows appear. A state containing Z indicates a zombie. It is normal not to find one on a healthy system.
```

## Real scenario: `kill -9` does not remove a process shown as Z.

The process has already exited. Its parent needs to collect the exit status using a wait operation. Investigate the parent application and its child-handling behaviour; restarting a parent is a service-impacting recovery action that needs the normal operational process.

## Important detail

An orphan is normally reparented to an appropriate subreaper or the namespace’s init process. An adopted process does not automatically become a zombie. Large numbers of unreaped zombies consume process-table resources, but a zombie is not actively executing application code or retaining the full memory of the running program.

## What to remember

**Zombie: child finished, status not collected. Orphan: original parent finished first.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man2/wait.2.html)

[Previous: fg and bg: resume a paused job](08-foreground-and-bg.md) | [Chapter overview](README.md)
