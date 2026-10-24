# sudo: run an allowed command as another user

**Module:** Linux

**Topic:** Linux permissions

## What is sudo?

`sudo` runs a command as another user if the configured policy allows it. The usual default target is root, but another target can be selected.

It is a controlled permission slip for a specific job, rather than a permanent change to who you are.

## Why does this matter in DevOps?

An administrator may need to restart a service, install a package, or inspect a protected resource. Use the access required for that job and keep application work under its intended account.

## Simple practice

```bash
whoami
sudo -l
sudo whoami
whoami
```

`sudo -l` checks policy and may ask for your password. A password prompt does not show typed characters. `sudo whoami` runs one command under the target identity; it does not permanently turn the original shell into root.

**What you should see:**

```text
Your username
A list of your allowed sudo actions, or a policy denial
root, if the whoami command is allowed
Your username again
```

## Real scenario: A command fails without sudo but succeeds with it. Is “always add sudo” the fix?

First identify the permission the task needs. A root-owned file in a user workspace may be an ownership mistake. Running every build as root can create more inaccessible files and hide the original problem.

## Important detail

`sudo -u ananya id` targets an existing account named ananya when allowed. Authentication and allowed commands depend on policy; not every sudo invocation asks for a password. Also, `sudo echo text > /protected/file` does not elevate the shell’s redirection.

## What to remember

**sudo changes the identity for an allowed command, not the meaning of every command around it.**

## Further reading

[Sudo documentation](https://www.sudo.ws/docs/man/sudo.man/)

[Previous: umask: filter initial permissions](05-umask.md) | [Next: Root and ordinary users](07-root-vs-user.md)
