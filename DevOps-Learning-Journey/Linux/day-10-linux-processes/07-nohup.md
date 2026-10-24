# nohup: ignore hangup for a command

**Module:** Linux

**Topic:** Linux processes

## What is nohup?

`nohup` starts a command with the hangup signal ignored. It is often used for temporary work that should not end merely because a terminal sends SIGHUP.

The worker is told not to stop just because the office phone disconnects. That still does not provide a replacement worker or a restart policy.

## Why does this matter in DevOps?

Run a small, temporary task outside the terminal’s normal hangup behaviour. Production applications need more lifecycle support than nohup supplies.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
mkdir -p ~/devops-practice/day10
cd ~/devops-practice/day10
nohup sleep 30 > nohup-demo.log 2>&1 < /dev/null &
practice_pid=$!
ps -p "$practice_pid" -o pid,comm
wait "$practice_pid"
```

`>` directs standard output to a sample log; `2>&1` directs errors to the same destination; `< /dev/null` avoids terminal input. `&` backgrounds the command. Without `&`, nohup does not itself return the prompt immediately.

**What you should see:**

```text
A background timer starts. The explicit log may remain empty because sleep normally prints nothing.
```

## Real scenario: A process started with nohup does not come back after the server reboots.

That is expected: nohup is not a startup configuration or a supervisor. Configure an appropriate service manager if the application needs restart-on-failure, boot startup, health management, and controlled shutdown.

## Important detail

Ignoring SIGHUP does not prevent termination from other signals, an OOM event, reboot, or session policies that kill processes. It also does not rotate its output file. If you leave output handling to nohup, it commonly uses nohup.out when stdout is a terminal.

## What to remember

**nohup handles hangup, not complete service reliability.**

## Further reading

[Linux command reference](https://www.gnu.org/software/coreutils/manual/html_node/nohup-invocation.html)

[Previous: jobs: list this shell’s jobs](06-jobs.md) | [Next: fg and bg: resume a paused job](08-foreground-and-bg.md)
