# useradd: create a local account

**Module:** Linux

**Topic:** Users and groups

## What is useradd?

`useradd` creates a local account using the options you supply and the system’s defaults. Home-directory creation, group creation, and shell selection must not be assumed.

A new employee needs an identity card, team assignment, and sometimes a workspace. Those are related but separate choices.

## Why does this matter in DevOps?

Provision an account for a person or service. Production accounts are usually managed through an approved provisioning process so ownership and access remain consistent.

## Simple practice

```bash
sudo useradd -m -U -s /bin/bash devopsdemo
getent passwd devopsdemo
id devopsdemo
ls -ld /home/devopsdemo
```

Run this only in a disposable Linux practice VM if you want to create an account. `-m` creates its home, `-U` creates a matching group, and `-s` selects a shell. A usable password is not set by these commands. You can read the example without executing it.

**What you should see:**

```text
A new devopsdemo account, matching private group, and home directory are created if the name is unused and you have administrator access.
```

## Real scenario: A new account exists, but /home/devopsdemo is missing.

Check the creation options and defaults. A passwd entry can name a home that was never created. Provision the intended directory with correct ownership through your account-management process rather than making an unrelated directory world-writable.

## Important detail

A matching private group does not guarantee private files: umask and directory modes still matter. `useradd -g release-demo -m -N anotheruser` deliberately uses an existing primary group, which must already exist. On Ubuntu, `adduser` is a more interactive helper with different defaults.

## What to remember

**An account record, a home directory, and a password are separate pieces of setup.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man8/useradd.8.html)

[Previous: /etc/shadow: protected password information](02-etc-shadow.md) | [Next: Groups: give a team shared access](04-groups.md)
