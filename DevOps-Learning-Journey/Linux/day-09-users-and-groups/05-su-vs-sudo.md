# su versus sudo: switch sessions or run a command

**Module:** Linux

**Topic:** Users and groups

## What is su versus sudo?

`su` starts a command or shell with another user’s identity. `sudo` authorises a command as another user through a policy. They are different tools, even when both can lead to a root shell.

`su - ananya` is like entering Ananya’s workspace for a session. `sudo -u ananya command` is like being authorised to do one named job under that identity.

## Why does this matter in DevOps?

Reproduce an application’s behaviour as its service user, or perform a controlled administrative operation while recording which user requested it.

## Simple practice

```bash
whoami
sudo -l
sudo -u root id
whoami
```

A separate example, `su - ananya`, opens a login-style shell as an existing account and normally asks a non-root caller for Ananya’s password. `sudo -u ananya id` normally uses sudo policy and its configured authentication. Use `exit` to leave a shell opened with `su`.

**What you should see:**

```text
If allowed, id reports root for the single elevated command. The final whoami still reports your original account.
```

## Real scenario: A test succeeds with sudo but fails in the service’s real session.

The effective identity or environment may differ. Compare user/group IDs, home directory, working directory, PATH, and required configuration. A privileged test may bypass the exact access rule you needed to investigate.

## Important detail

Password and environment handling depend on system configuration. Do not teach “su always means root” or “sudo always asks for your password”. `sudo -i` deliberately starts a login-style shell and remains active until you exit, unlike a single `sudo command`.

## What to remember

**Know whose identity is running the command and whether you opened a lasting shell.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man1/su.1.html)

[Previous: Groups: give a team shared access](04-groups.md) | [Next: sudoers: define allowed administrative actions](06-sudoers.md)
