# head: read the beginning

**Module:** Linux

**Topic:** File operations

## What is head?

`head` prints the first part of a file. By default, it prints the first ten lines.

Read the opening page to understand what kind of document you are holding.

## Why does this matter in DevOps?

Inspect a CSV header, the start of a generated report, or the first few lines of a log before deciding how to process it.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07
cd ~/devops-practice/day07
printf "name,status\nshop,healthy\npayments,degraded\n" > head-demo.csv
head -n 2 head-demo.csv
```

`-n 2` requests two lines. The file still contains all three lines; only the displayed selection is shorter.

**What you should see:**

```text
name,status
shop,healthy
```

## Real scenario: A log contains an old startup message, but it does not explain the current failure.

You may be looking at the beginning of a long-running log. Check timestamps. Use `tail` for recent lines and search around the incident time rather than assuming the first error is today’s error.

## Important detail

`head` selects lines, not logical CSV records. A quoted CSV field can contain a newline. For structured data with complex formatting, use a parser that understands that format.

## What to remember

**head shows the beginning; tail shows the end.**

## Further reading

[Command reference](https://www.gnu.org/software/coreutils/manual/html_node/head-invocation.html)

[Previous: less: read a file one screen at a time](07-less.md) | [Next: tail: read recent lines and follow a log](09-tail.md)
