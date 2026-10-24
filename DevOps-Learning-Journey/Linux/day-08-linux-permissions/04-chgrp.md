# chgrp: choose the owning group

**Module:** Linux

**Topic:** Linux permissions

## What is chgrp?

`chgrp` changes a file’s owning group. The group permission bits still determine what members of that group can do.

Choosing the marketing team as the audience is different from deciding whether that audience may only read or also edit.

## Why does this matter in DevOps?

Share a project file with a team while keeping its individual owner. You often use `chgrp` to choose the team and `chmod` to set its permitted actions.

## Simple practice

```bash
mkdir -p ~/devops-practice/day08
cd ~/devops-practice/day08
printf "release notes\n" > group-demo.txt
chgrp "$(id -gn)" group-demo.txt
chmod 640 group-demo.txt
ls -l group-demo.txt
```

`id -gn` prints your primary group name. Substitution supplies that name to `chgrp`, so this works without inventing a team on your machine. An owner can normally change a file to a group they belong to; other changes can require privilege.

**What you should see:**

```text
The file has your primary group, owner read/write, group read, and no permissions for others.
```

## Real scenario: A file was assigned to marketing, but support also needs access.

One file has one owning group. Decide whether a shared collaboration group fits, or whether a filesystem ACL should grant named additional groups access. Do not repeatedly switch the owning group and expect both memberships to remain attached.

## Important detail

Changing the group alone does not grant read/write access. Team members must also be able to traverse parent directories. Newly added group memberships normally require a fresh session before existing processes use them. Day 9 covers group creation and membership.

## What to remember

**chgrp chooses which team; chmod chooses what that team may do.**

## Further reading

[Linux command reference](https://www.gnu.org/software/coreutils/manual/html_node/chgrp-invocation.html)

[Previous: chown: change who owns a file](03-chown.md) | [Next: umask: filter initial permissions](05-umask.md)
