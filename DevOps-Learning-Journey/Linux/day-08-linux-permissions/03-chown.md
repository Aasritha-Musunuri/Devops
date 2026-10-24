# chown: change who owns a file

**Module:** Linux

**Topic:** Linux permissions

## What is chown?

`chown` changes a file’s owning user and can also change its owning group. It does not transfer the file to another computer or automatically grant every permission.

Changing the name on a house deed changes ownership. The house does not move to the new owner’s street.

## Why does this matter in DevOps?

A deployment ran as root and created files the application’s normal service account cannot update. Correct ownership on the intended application files can be part of the fix.

## Simple practice

```bash
mkdir -p ~/devops-practice/day08
cd ~/devops-practice/day08
printf "practice ownership\n" > owner-demo.txt
ls -l owner-demo.txt
```

This practice only inspects your own file. An administrator could use `sudo chown ananya owner-demo.txt` to assign it to an existing account named ananya. That is a syntax example, not a command you need to run on your main machine.

**What you should see:**

```text
The listing shows your current user and a group next to owner-demo.txt.
```

## Real scenario: Ash runs `chown aasritha file.txt` on his laptop. Why does nothing appear on Aasritha’s laptop?

Ownership refers to an account identity on the filesystem being changed. Matching usernames on two independent laptops do not make one shared account. Use an actual transfer or shared filesystem to make the data available elsewhere.

## Important detail

On the same machine, an owner’s access still depends on owner permission bits and the containing directories. Owners can normally use `chmod` on their files even when the current owner bits grant no read/write access, provided the path and other controls allow it. Transferring ownership to another user normally needs privilege.

## What to remember

**chown changes who owns it. chmod changes access. File transfer changes where another computer can get it.**

## Further reading

[Linux command reference](https://www.gnu.org/software/coreutils/manual/html_node/chown-invocation.html)

[Previous: chmod: set file permissions](02-chmod.md) | [Next: chgrp: choose the owning group](04-chgrp.md)
