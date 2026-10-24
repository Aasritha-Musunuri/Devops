# tail: read recent lines and follow a log

**Module:** Linux

**Topic:** File operations

## What is tail?

`tail` prints the end of a file. With `-f`, it keeps watching for appended text.

Open a diary at the newest entry rather than reading from the first page.

## Why does this matter in DevOps?

Watch recent application events while reproducing an error. A fresh log line can show whether a request reached the service and what failed next.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07
cd ~/devops-practice/day07
printf "INFO Start\nINFO Ready\nERROR Checkout failed\n" > tail-demo.log
tail -n 2 tail-demo.log
tail -f tail-demo.log
```

Press Ctrl+C to stop this `tail` viewer and return to the prompt. In another terminal, append a line with `printf "INFO Recovered\n" >> ~/devops-practice/day07/tail-demo.log` to see a live update. `>>` appends rather than replacing the file.

**What you should see:**

```text
INFO Ready
ERROR Checkout failed
The follow command stays open, waiting for new lines.
```

## Real scenario: Log messages stop appearing after log rotation, although the service is still running.

A rotation may replace the file at that name. On GNU systems, `tail -F` follows the filename with retries, which is useful when a log is replaced. Confirm which logging system the application actually uses.

## Important detail

Following a log does not restart or fix the application. Services managed by systemd or containers may write to a journal or container logging stream rather than a conventional file. Ctrl+C normally stops this viewer, not the separate application producing the log.

## What to remember

**tail reads the latest lines; -f keeps watching.**

## Further reading

[Command reference](https://www.gnu.org/software/coreutils/manual/html_node/tail-invocation.html)

[Previous: head: read the beginning](08-head.md) | [Next: nano and vim: edit text in a terminal](10-nano-vim-basics.md)
