# Groups: give a team shared access

**Module:** Linux

**Topic:** Users and groups

## What is Groups?

A Linux group is a named collection of account identities used for access decisions. An account has one primary group and can belong to supplementary groups.

One employee can have a home department and also belong to the release team. Access can be granted to the team instead of configuring each person separately.

## Why does this matter in DevOps?

Allow a release team to read an artifact or collaborate in a shared directory without running everything as root.

## Simple practice

```bash
id
groups
id -gn
```

These commands only inspect your account. In an isolated administrative practice VM, create a team with `sudo groupadd release-demo`, then add an existing test user with `sudo usermod -aG release-demo devopsdemo`. A fresh login is normally needed for that user’s processes to gain the new membership.

**What you should see:**

```text
Your UID, primary and supplementary groups, then your primary group name. Names and IDs vary by machine.
```

## Real scenario: An administrator added Ananya to a group, but her current shell still cannot read the team file.

Check the configured membership with `id ananya` and the current session with `id`. Start a fresh login session, then confirm the file’s group, its group permission bits, and the parent-directory access.

## Important detail

Keep `-a` with `usermod -aG` when adding supplementary groups. Using `-G` alone can replace the existing supplementary list. One file has one owning group; use a deliberate shared group or an appropriate ACL when two teams need different access.

## What to remember

**Membership says who belongs to the team. File permissions say what the team can do.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man8/usermod.8.html)

[Previous: useradd: create a local account](03-useradd.md) | [Next: su versus sudo: switch sessions or run a command](05-su-vs-sudo.md)
