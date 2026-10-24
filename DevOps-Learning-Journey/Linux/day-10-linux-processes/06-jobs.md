# jobs: list this shell’s jobs

**Module:** Linux

**Topic:** Linux processes

## What is jobs?

`jobs` lists the background and stopped jobs tracked by the current interactive shell. It is not a system-wide process list.

It is your own task notebook, rather than the company-wide employee directory.

## Why does this matter in DevOps?

See which test commands are running or paused in the terminal you are using. Use `ps` or a service manager when the question is about the whole machine or a managed application.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
sleep 20 &
practice_pid=$!
jobs -l
wait "$practice_pid"
jobs
```

`-l` includes process IDs in Bash’s job output. Bash may also print a `[1]+ Done sleep 20` notification when a job completes. That message is normal and is not an error from another command you happened to run.

**What you should see:**

```text
The first jobs command shows a Running entry with a job number and PID. After the timer is reaped, the final list may be empty.
```

## Real scenario: A timer appears in terminal A, but `jobs` in terminal B shows nothing.

Each shell tracks its own jobs. Inspect it from the shell that launched it, or use a process tool if you need to inspect a PID from another terminal.

## Important detail

A job can contain multiple processes when it is a pipeline, so a shell job is not always one PID. Completed-job notifications are not application health checks. Reading an empty jobs list does not prove no applications are running on the server.

## What to remember

**jobs is local to this shell; ps shows processes in its selected view.**

## Further reading

[Linux command reference](https://www.gnu.org/software/bash/manual/html_node/Job-Control-Builtins.html)

[Previous: Background jobs: what the ampersand does](05-background-jobs.md) | [Next: nohup: ignore hangup for a command](07-nohup.md)
