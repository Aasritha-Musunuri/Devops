# umask: filter initial permissions

**Module:** Linux

**Topic:** Linux permissions

## What is umask?

`umask` is a creation mask. It removes permission bits from the permissions an application requests for a new file or directory. It does not set a user’s permissions when an account is created.

Think of crossing out options on a new form. A mask says what to block, not what to grant.

## Why does this matter in DevOps?

Control whether newly created application files are accessible to the team or private to a service. A restrictive deployment mask can explain why a newly created artifact is unreadable to another account.

## Simple practice

```bash
mkdir -p ~/devops-practice/day08
cd ~/devops-practice/day08
(
  umask 022
  touch umask-demo.txt
  mkdir -p umask-demo-dir
  ls -ld umask-demo.txt umask-demo-dir
)
```

The parentheses run a subshell, so your original shell’s mask is unchanged. Ordinary file creation commonly requests 666; directory creation commonly requests 777. Mask 022 blocks group and others write. Use new sample names when repeating because existing permissions are not reset.

**What you should see:**

```text
For newly created entries without a default ACL:
file:      644 = rw-r--r--
directory: 755 = rwxr-xr-x
```

## Real scenario: “Does umask 722 give the owner everything and the group write?”

No. The digits describe blocked bits. With ordinary defaults, 722 blocks all owner permissions and group/others write: new files become 044 and directories 055. A common intended mask is 022, not 722.

## Important detail

The rule is bit clearing, not ordinary decimal subtraction. A mask cannot add execute permission that the creating application did not request. Existing files are unchanged, and a parent directory’s default ACL can change the creation rules.

## What to remember

**chmod sets permissions now. umask filters permissions at creation.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man2/umask.2.html)

[Previous: chgrp: choose the owning group](04-chgrp.md) | [Next: sudo: run an allowed command as another user](06-sudo.md)
