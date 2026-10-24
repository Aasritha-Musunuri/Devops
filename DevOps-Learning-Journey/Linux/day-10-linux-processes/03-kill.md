# kill: send a signal to a process

**Module:** Linux

**Topic:** Linux processes

## What is kill?

`kill` sends a signal to a process. Without an explicit signal, it normally sends SIGTERM, which requests termination.

Think of delivering a message to a worker. The message may mean “please finish”, “pause”, or “continue”; the tool’s name does not mean every signal instantly destroys the process.

## Why does this matter in DevOps?

Ask an application to shut down or signal your own test process. For a managed service, normally use its service manager or orchestrator so its lifecycle stays consistent.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
sleep 300 &
practice_pid=$!
ps -p "$practice_pid" -o pid,comm
kill -TERM "$practice_pid"
wait "$practice_pid"
```

Only signal the PID captured from the timer you just started. `kill -TERM` names the signal clearly. These commands do not identify a real service or justify stopping one.

**What you should see:**

```text
Your sleep task terminates. Bash may print a Terminated job message; wait returns a nonzero status because a signal ended the task.
```

## Real scenario: “I killed the application, but it immediately came back.”

A service manager, container restart policy, or orchestrator may be maintaining the desired process. Check who owns its lifecycle and use the manager’s intended control command. Repeatedly killing the new PID fights the controller.

## Important detail

A successful `kill` means a signal was sent, not necessarily that shutdown completed. A process may handle or ignore SIGTERM, and permissions can prevent signalling another user’s process. Verify state afterwards before deciding on further action.

## What to remember

**kill sends a signal; check what the process actually did next.**

## Further reading

[Linux command reference](https://www.gnu.org/software/bash/manual/html_node/Bash-Builtins.html)

[Previous: top and htop: watch resource usage](02-top-and-htop.md) | [Next: SIGTERM versus SIGKILL](04-sigterm-vs-sigkill.md)
