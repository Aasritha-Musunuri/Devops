# pwd: where am I?

**Module:** Linux

**Topic:** Filesystem and navigation

## What is pwd?

`pwd` means **print working directory**. It shows the location your shell is currently using.

Think of the “You are here” marker on a shopping-mall map. Before choosing a route, you need to know your starting point.

## Simple example

In Linux:

```bash
pwd
```

An example result is:

```text
/home/aasritha
```

This means the shell is currently in the `aasritha` folder under `/home`. Your username and result may differ.

## Why does this matter in DevOps?

Commands often look for files relative to the current directory. A build command run in the wrong folder may not find its project, even though the project exists elsewhere.

## Real example: the project cannot be found

A build reports that no project file was found.

**What to check:** Run `pwd`, then `ls`. Confirm you are in the expected application folder before trying the build again. Do not create another project just because the command started in the wrong place.

## Important detail

Two terminal windows can be in different directories. Changing the location in one shell does not automatically move the other.

## What to remember

**When a file seems missing, first check where you are.**

## Further reading

[Bash directory commands](https://www.gnu.org/software/bash/manual/html_node/Bourne-Shell-Builtins.html)

[Back to Day 6](README.md) | [Next: ls](02-ls.md)
