# Background jobs: what the ampersand does

**Module:** Linux

**Topic:** Linux processes

## What is Background jobs?

Adding `&` starts a command as a background job in the shell. The shell can show a new prompt while that job continues.

Start the washing machine and return to another task. You did not move the machine to a different house or give it a permanent supervisor.

## Why does this matter in DevOps?

Run a temporary diagnostic or test while using the same terminal. This is convenient for learning, but it is not the same as configuring a reliable production service.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
sleep 30 &
practice_pid=$!
printf "Timer PID: %s\n" "$practice_pid"
jobs
wait "$practice_pid"
```

A result such as `[1] 12345` has two different identifiers: job 1 belongs to this shell; 12345 is the process ID in this example. The actual numbers on your computer will differ.

**What you should see:**

```text
Bash shows a job number and PID. jobs lists the timer as Running. wait finishes when the timer ends.
```

## Real scenario: A command started with `&` exits after the SSH session closes.

Backgrounding alone does not detach all terminal relationships or guarantee survival of session cleanup. For a real long-running application, use an appropriate service manager. The nohup topic explains a limited alternative for temporary work.

## Important detail

Background does not mean faster or lower priority. A job that tries to read from the terminal may be stopped by job-control rules. Capture `$!` immediately because starting a different background command changes its value.

## What to remember

**& gives the prompt back. It does not make a service permanent.**

## Further reading

[Linux command reference](https://www.gnu.org/software/bash/manual/html_node/Job-Control-Basics.html)

[Previous: SIGTERM versus SIGKILL](04-sigterm-vs-sigkill.md) | [Next: jobs: list this shell’s jobs](06-jobs.md)
