# SIGTERM versus SIGKILL

**Module:** Linux

**Topic:** Linux processes

## What is SIGTERM versus SIGKILL?

SIGTERM requests termination and can be handled by an application. SIGKILL cannot be caught, blocked, or ignored and does not let the application run a shutdown handler.

SIGTERM is “finish safely and close the shop”. SIGKILL is cutting off the shop’s work without allowing its closing routine.

## Why does this matter in DevOps?

Graceful shutdown matters during rolling deployments. An application may need time to stop accepting requests, finish work, and close connections before it exits.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
sleep 300 &
practice_pid=$!
kill -TERM "$practice_pid"
wait "$practice_pid"
sleep 300 &
practice_pid=$!
kill -KILL "$practice_pid"
wait "$practice_pid"
```

This deliberately creates two disposable timers to compare signal names. It does not show application cleanup because `sleep` has no business requests to drain. Use names rather than memorising signal numbers.

**What you should see:**

```text
Both separate practice timers stop. A real application may behave differently when it handles SIGTERM. Signal termination makes wait return nonzero.
```

## Real scenario: Requests fail during every deployment even though the new version is healthy.

Inspect shutdown handling, load-balancer draining, and the time allowed before forced termination. Make sure the intended application receives the signal and has enough bounded time to finish its cleanup.

## Important detail

SIGKILL is not a cleanup strategy. A task stuck in uninterruptible kernel sleep can remain visible until that kernel operation completes, even after a fatal signal is pending. A zombie is already finished and needs its exit status collected, rather than another kill signal.

## What to remember

**TERM gives the application a chance. KILL gives it no handler.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man7/signal.7.html)

[Previous: kill: send a signal to a process](03-kill.md) | [Next: Background jobs: what the ampersand does](05-background-jobs.md)
