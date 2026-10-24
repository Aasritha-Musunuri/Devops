# Linux distributions

**Module:** Foundations

**Topic:** Windows vs. Linux

## What is a distribution?

A Linux distribution, often shortened to **distro**, is a complete operating system built around the Linux kernel. It includes tools, a way to install software, and an update process.

Think of different school bags containing the same essential books but different organizers and accessories. Distributions share many foundations while making different choices about tools and support.

## What are Ubuntu and RHEL?

- **Ubuntu:** a distribution commonly encountered on developer machines and servers. It uses the `apt` package-management tools.
- **RHEL:** Red Hat Enterprise Linux, a distribution with enterprise support options. Its package-management tools include `dnf`.

RHEL is an abbreviation, not a separate kind of kernel.

## What about CentOS?

Older tutorials may describe CentOS Linux. That product has reached end of life. CentOS Stream is a different distribution involved in RHEL development; do not treat the names as interchangeable.

Check the distribution and supported release before following installation instructions from an old tutorial.

## A simple way to check

In a typical modern Linux terminal:

```bash
cat /etc/os-release
```

`cat` displays a file's contents. This file normally identifies the distribution and version. Look for `PRETTY_NAME`. On unusual or minimal systems, the file may be absent.

## Real example: an install command is missing

A tutorial says `apt`, but the server runs RHEL.

**What to check:** Read `/etc/os-release` and use instructions for that distribution. Do not assume the server is broken because another distribution's tool is unavailable.

## What to remember

**Check which Linux you are using before following package or service instructions.**

## Further reading

[CentOS Linux and CentOS Stream - Red Hat](https://www.redhat.com/en/topics/linux/what-is-centos)

[Back to Day 5](README.md) | [Next: Shell vs. GUI](03-shell-vs-gui.md)
