# Why Linux is common on servers

**Module:** Foundations

**Topic:** Windows vs. Linux

## What is Linux?

Strictly speaking, Linux is a kernel: the part of an operating system that manages resources such as CPU time, memory, and devices. People also use “Linux” to mean a complete operating system built around that kernel, such as Ubuntu.

## What is a server?

A server provides a service to other programs or users. A website server answers web requests; a database server stores and retrieves data.

It may run on a physical machine, a virtual machine, or in another hosted setup. A laptop can also run a server program.

## Why do teams use Linux?

- It supports many common web, automation, and container tools.
- Servers can be managed through commands without needing a desktop interface.
- Scripts make repeated work easier to automate.
- Teams can choose a distribution and support arrangement that fits their needs.

A server without a desktop still uses CPU and memory; it simply does not need to run a graphical desktop for administration.

## Does that mean Windows cannot run servers?

No. Windows Server hosts many business applications. The right choice depends on application compatibility, support, security requirements, and the team's skills.

For example, an application that depends on Windows-only components cannot simply be copied to Linux and expected to work.

## Real example: works on Windows, fails on Linux

The code asks for `Settings.json`, but the deployed file is named `settings.json`.

Typical Linux filesystems distinguish uppercase and lowercase names. Common Windows setups often do not, so the mistake may have gone unnoticed locally.

**What to check:** Compare the exact filename and the path in the error. Correct the mismatch rather than changing permissions at random.

## What to remember

**Choose the operating system the application supports. Check the actual environment when troubleshooting.**

## Further reading

[What is Linux? - Red Hat](https://www.redhat.com/en/topics/linux/what-is-linux)

[Back to Day 5](README.md) | [Next: Distributions](02-linux-distributions.md)
