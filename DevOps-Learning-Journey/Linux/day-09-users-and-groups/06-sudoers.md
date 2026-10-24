# sudoers: define allowed administrative actions

**Module:** Linux

**Topic:** Users and groups

## What is sudoers?

The sudoers policy describes who may run which commands, as which target users, on which hosts. It may include rules from additional files or policy sources.

It is the permission-slip rulebook: having the sudo tool installed does not mean every request is approved.

## Why does this matter in DevOps?

A support or deployment account may need a narrowly scoped administrative action without unrestricted root access. The exact rule should match the intended task and organisational policy.

## Simple practice

```bash
sudo -l
```

This is a policy inspection, not a policy edit. Administrators should use `visudo` for local sudoers edits because it provides syntax checks. `sudo visudo -c` checks the existing configuration when allowed. Do not add rules merely to make a lesson example work.

**What you should see:**

```text
Your permitted sudo commands, or a message that your account is not allowed. Authentication may be requested.
```

## Real scenario: A deployment account can restart a service but cannot run an arbitrary administrator command.

That can be intentional least-privilege policy. Read the allowed command list and use the approved operation. If the workflow needs more access, request a reviewed policy change rather than opening a root shell as a workaround.

## Important detail

Rules for editors, shells, package managers, or writable scripts can allow more power than their names suggest. `NOPASSWD` changes an authentication requirement; it does not automatically make a rule safe. Keep an existing administrative session available while validating policy changes to avoid locking out recovery access.

## What to remember

**sudo is the tool; sudoers is a policy that decides which requests it accepts.**

## Further reading

[Sudo documentation](https://www.sudo.ws/docs/man/sudoers.man/)

[Previous: su versus sudo: switch sessions or run a command](05-su-vs-sudo.md) | [Chapter overview](README.md)
