# /etc/passwd: the local account directory

**Module:** Linux

**Topic:** Users and groups

## What is /etc/passwd?

`/etc/passwd` describes local user accounts. Each entry contains colon-separated fields such as the username, UID, primary GID, home directory, and login shell.

It is an address book of accounts, not a list of everyone’s readable passwords.

## Why does this matter in DevOps?

Check whether a local service account exists, where its home is configured, and which shell it uses. Account identity helps explain file ownership and which user a process is running as.

## Simple practice

```bash
getent passwd "$(id -un)"
```

The seven fields are name, password placeholder, UID, primary GID, comment, home, and shell. In a typical shadow-password setup, `x` points to password information stored separately; it is not the password.

**What you should see:**

```text
An example entry:
aasritha:x:1000:1000:Aasritha:/home/aasritha:/bin/bash
```

## Real scenario: An account can log in, but its name is not listed directly in /etc/passwd.

It may come from a central identity provider through the system’s name-service configuration. `getent passwd accountname` asks the configured account sources, whereas reading only `/etc/passwd` checks only that local file.

## Important detail

A listed home path does not prove the directory already exists or is private. A shell such as `/usr/sbin/nologin` commonly indicates an account not intended for interactive login, but other execution paths depend on policy. Do not edit account records by hand as a first troubleshooting step.

## What to remember

**/etc/passwd describes who the local accounts are; it does not normally reveal their password hashes.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man5/passwd.5.html)

[Back to Day 9](README.md) | [Next: /etc/shadow: protected password information](02-etc-shadow.md)
