# Day 8: Linux permissions

**Module:** Linux

Understand who can read, change, enter, or run something, and why permission denied does not mean “use 777”.

## Topics

1. [rwx: read, write, and execute](01-rwx.md)
2. [chmod: set file permissions](02-chmod.md)
3. [chown: change who owns a file](03-chown.md)
4. [chgrp: choose the owning group](04-chgrp.md)
5. [umask: filter initial permissions](05-umask.md)
6. [sudo: run an allowed command as another user](06-sudo.md)
7. [Root and ordinary users](07-root-vs-user.md)
8. [setuid: a program with a different effective owner](08-setuid-basics.md)

## Before starting

Start with files in your own Linux home directory. Most examples need no administrator privileges. Ownership changes and special bits are explained without asking you to turn your practice machine into a privileged service. On WSL, practise under `~` in the Linux filesystem; `/mnt/c` permissions can behave differently depending on mount settings.

## The connection to real work

Permission problems are about identity, access bits, and the path to the file. Understand the failed operation before changing access. Ownership does not move files, and a group name does not itself grant permissions.

[Learning journey](../../README.md)
