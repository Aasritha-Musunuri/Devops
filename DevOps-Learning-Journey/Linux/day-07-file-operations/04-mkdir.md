# mkdir: create folders

**Module:** Linux

**Topic:** File operations

## What is mkdir?

`mkdir` means make directory. It creates a folder; it does not create a text file.

Before putting project papers in a cupboard, you first create a labelled section to hold them.

## Why does this matter in DevOps?

Prepare a directory for build artifacts, application uploads, or practice logs. The application’s user must have access to the directory that will hold its files.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07/mkdir-demo/releases
ls -ld ~/devops-practice/day07/mkdir-demo/releases
```

`-p` creates missing parent directories. It also allows an existing directory to remain without reporting “File exists”. `ls -ld` inspects the directory itself, rather than its contents.

**What you should see:**

```text
A directory listing appears. The permission string begins with d.
```

## Real scenario: Creating an application’s upload folder returns “Permission denied”.

Confirm the intended path and the user running the command. For practice, use your own home directory. For a service directory, have its owner or an administrator provision the required access; do not make the whole filesystem writable.

## Important detail

A directory existing is different from the application being able to write into it. Check owner, group, permissions, and access through its parent directories. `mkdir -p` does not automatically correct permissions on folders that already exist.

## What to remember

**mkdir builds the folder; permissions decide who can use it.**

## Further reading

[Command reference](https://www.gnu.org/software/coreutils/manual/html_node/mkdir-invocation.html)

[Previous: rm: remove a file](03-rm.md) | [Next: touch: create an empty file or update its time](05-touch.md)
