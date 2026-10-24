# less: read a file one screen at a time

**Module:** Linux

**Topic:** File operations

## What is less?

`less` is a pager: it lets you navigate a text file without printing everything at once or editing its contents.

It is like reading a book a page at a time, with a bookmark and a search function.

## Why does this matter in DevOps?

Browse a long application log or configuration. Search for an error and read the surrounding lines to understand what happened before it.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07
cd ~/devops-practice/day07
printf "INFO Starting\nERROR Database unavailable\nINFO Retry scheduled\n" > less-demo.log
less less-demo.log
```

Use the arrow keys to move, Space for the next screen, `/ERROR` then Enter to search, and `n` for the next match. Searching does not change the text.

**What you should see:**

```text
A file viewer opens. Press q to return to your shell.
```

## Real scenario: A beginner thinks the terminal froze after opening a log.

The terminal is displaying the pager, not waiting at the shell prompt. Press `q` to leave `less`. You do not need to close the terminal or restart the server.

## Important detail

If `less` is not installed in a minimal container, inspect a small file with `head` or `tail`, or use the application’s logging interface. Do not assume all server images include interactive tools. A changing log may require follow mode or `tail -f`.

## What to remember

**less lets you look around; q brings you back.**

## Further reading

[Command reference](https://greenwoodsoftware.com/less/)

[Previous: cat: print a small text file](06-cat.md) | [Next: head: read the beginning](08-head.md)
