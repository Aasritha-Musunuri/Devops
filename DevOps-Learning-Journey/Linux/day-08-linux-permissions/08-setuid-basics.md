# setuid: a program with a different effective owner

**Module:** Linux

**Topic:** Linux permissions

## What is setuid?

The set-user-ID bit can make an executable run with the file owner’s effective user ID. This is different from manually prefixing a command with sudo.

A purpose-built machine may hold a special key internally so it can perform one controlled operation. That does not hand the key to everyone who presses the button.

## Why does this matter in DevOps?

Some system programs need controlled access to protected resources. A common example is a setuid-root `passwd` binary that updates password information after checking the caller’s right to do so.

## Simple practice

```bash
command -v passwd
ls -l /usr/bin/passwd
```

A lowercase `s` in the owner execute position indicates setuid plus owner execute permission. An uppercase `S` means setuid is set but that execute bit is absent. This exercise only inspects an existing program; it does not change special bits.

**What you should see:**

```text
On many Linux systems, the mode includes rws for the owner, for example -rwsr-xr-x. The exact path and setup can vary.
```

## Real scenario: “Why can an ordinary user change their password without being allowed to edit /etc/shadow?”

On systems using this design, the privileged password program performs a constrained operation after its checks. The ordinary user’s shell does not become root, and the user does not gain arbitrary write access to the password database.

## Important detail

Do not add setuid to your own shell or script as a shortcut. Linux does not honour setuid on interpreted scripts in the same way as executable binaries. `nosuid`, `no_new_privs`, and other restrictions can suppress elevation. A writable privileged executable is a serious design problem.

## What to remember

**setuid changes a program’s effective identity; sudo checks policy before running a chosen command.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man2/execve.2.html)

[Previous: Root and ordinary users](07-root-vs-user.md) | [Chapter overview](README.md)
