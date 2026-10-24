# fg and bg: resume a paused job

**Module:** Linux

**Topic:** Linux processes

## What is fg and bg?

`fg` brings a shell job to the foreground. `bg` resumes a stopped job in the background. Stopped means paused; it is different from running in the background.

Pausing a video stops its progress. Playing it in a small side window keeps it moving while you do something else.

## Why does this matter in DevOps?

Recover an interactive command you accidentally paused, or manage a temporary command in your current terminal.

## Simple practice

Use an interactive Bash terminal. Commands that create a timer affect only the sample process you start here.

```bash
sleep 300
```

After Ctrl+Z, run `jobs` to see the Stopped state. Run `bg %+` to resume the current job in the background. Run `fg %+` to bring it back to the foreground, then Ctrl+C to end this practice timer. `%+` refers to the shell’s current job, not a system PID.

**What you should see:**

```text
The terminal waits while the timer runs. Press Ctrl+Z, then run the commands below from the same terminal.
```

## Real scenario: An editor shows Stopped and its task is making no progress.

It may have been suspended with Ctrl+Z. Use `jobs` in the original shell, then `fg` to resume the editor interactively. Starting an unrelated replacement editor can create competing edits rather than resuming the original work.

## Important detail

Ctrl+C normally sends an interrupt to the foreground job; Ctrl+Z normally suspends it. A background command that needs terminal input can stop again. Job specifications such as `%1` are interpreted by shell builtins, not interchangeable with PIDs in arbitrary tools.

## What to remember

**Stopped is paused. Background is still running. fg gives the terminal back to the job.**

## Further reading

[Linux command reference](https://www.gnu.org/software/bash/manual/html_node/Job-Control-Builtins.html)

[Previous: nohup: ignore hangup for a command](07-nohup.md) | [Next: Zombie and orphan processes](09-zombie-and-orphan-processes.md)
