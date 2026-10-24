# rwx: read, write, and execute

**Module:** Linux

**Topic:** Linux permissions

## What is rwx?

`r`, `w`, and `x` are permission bits. They apply separately to a file’s owner, owning group, and others.

A building has rules for its owner, team, and visitors. The same person does not combine every set of keys: Linux normally chooses the applicable owner, group, or others class.

## Why does this matter in DevOps?

An application needs to read its configuration and write its logs, while other accounts may need less access. Directory permissions also determine whether the application can reach those files.

## Simple practice

```bash
mkdir -p ~/devops-practice/day08
cd ~/devops-practice/day08
printf "practice only\n" > rwx-demo.txt
chmod 640 rwx-demo.txt
ls -l rwx-demo.txt
```

Ignore the initial `-`, which means a regular file. Split the next nine characters into `rw- | r-- | ---`: owner can read/write, group can read, others have no file permissions.

**What you should see:**

```text
-rw-r----- ... rwx-demo.txt
```

## Real scenario: A user owns a readable file but receives “Permission denied” when opening it.

Check the parent directories as well as the file. The user needs execute/search permission on each directory in the path. On Linux, `namei -l /path/to/file` can help inspect that chain when available.

## Important detail

For directories, `r` lists names, `x` lets you traverse/search known names, and `w` permits directory-entry changes with suitable `x` access. File write permission is not the same as permission to delete the file. ACLs and other security controls can add further rules.

## What to remember

**Owner, group, others answer who. rwx answers what.**

## Further reading

[Linux command reference](https://www.gnu.org/software/coreutils/manual/html_node/File-permissions.html)

[Back to Day 8](README.md) | [Next: chmod: set file permissions](02-chmod.md)
