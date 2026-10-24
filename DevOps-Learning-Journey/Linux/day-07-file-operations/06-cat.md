# cat: print a small text file

**Module:** Linux

**Topic:** File operations

## What is cat?

`cat` reads file contents and writes them to standard output, usually your terminal. It can also join files in order.

Imagine reading a short note straight through, without stopping to turn pages.

## Why does this matter in DevOps?

Inspect a small configuration or sample output. For a huge log, choose a pager or a targeted command instead of flooding the terminal.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07
cd ~/devops-practice/day07
printf "Application: shop\nEnvironment: practice\n" > cat-demo.txt
cat cat-demo.txt
```

`printf` creates a real sample file so the next command works. `cat` displays its contents; it does not open an editor or change the file.

**What you should see:**

```text
Application: shop
Environment: practice
```

## Real scenario: `cat app.log` says “No such file or directory”.

`app.log` may only have been an example name. Run `pwd` and `ls`, then supply the real path. A command cannot inspect a sample file until that file exists.

## Important detail

`cat input.txt > input.txt` can empty the file because the shell truncates the output before `cat` reads it. Use a different destination when redirecting. Do not print passwords or secret configuration into logs or screenshots.

## What to remember

**cat prints the whole file; it does not edit it.**

## Further reading

[Command reference](https://www.gnu.org/software/coreutils/manual/html_node/cat-invocation.html)

[Previous: touch: create an empty file or update its time](05-touch.md) | [Next: less: read a file one screen at a time](07-less.md)
