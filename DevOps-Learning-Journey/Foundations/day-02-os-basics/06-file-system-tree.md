# File system tree

**Module:** Foundations

**Topic:** OS basics

## Question

How is the Linux filesystem organized? Where would you look for configuration, logs, and process information?

## Short explanation

Linux presents files and directories in a tree starting at `/`. Different disks and virtual filesystems can appear at paths within this same tree.

## Answer

The Linux filesystem begins at the **root directory**, `/`. Common locations include `/etc` for system configuration, `/var/log` for logs, `/home` for user files, and `/proc` for virtual information about processes and the kernel.

The root directory `/` is different from the root user's home directory, commonly `/root`.

## Detailed explanation

### Common locations

```text
/
|-- etc/        System configuration
|-- var/        Variable data
|   |-- log/    Logs
|   `-- lib/    Persistent service state
|-- home/       Ordinary users' home directories
|-- root/       Root user's home directory
|-- tmp/        Temporary files
|-- usr/        Many installed commands, libraries, and shared files
|-- opt/        Additional application packages
|-- dev/        Device interfaces
|-- proc/       Virtual process and kernel information
`-- sys/        Virtual device and kernel interfaces
```

These are conventions, not a guarantee that every distribution or container has the same contents. Some applications log to the system journal or standard output rather than a file in `/var/log`.

On many modern distributions, `/bin`, `/sbin`, and `/lib` are symbolic links to corresponding locations under `/usr`.

### Absolute and relative paths

- **Absolute path:** starts at `/`, such as `/var/log/app.log`.
- **Relative path:** starts from the current working directory, such as `./notes.md`.
- `.` means the current directory; `..` means its parent.
- `~` is expanded by the shell to the current user's home directory.

### Mount points

A filesystem on another disk can be attached at a directory called a **mount point**, such as `/data`. Everything appears within the same tree, but different paths can use different storage.

For example, `/data` can be full while the filesystem containing `/` still has space. Check the filesystem for the path that is failing.

## Practical example

In Linux:

```bash
pwd
ls /
ls /etc
ls /var/log
cat /proc/meminfo | head
df -h /var/log
```

- `pwd` shows your current directory.
- `ls` lists directory contents.
- `/proc/meminfo` exposes current kernel memory information rather than an ordinary saved text file.
- `df -h /var/log` reports the filesystem containing that directory.

In PowerShell on Windows:

```powershell
Get-Location
Get-ChildItem C:\
```

Windows commonly exposes drive roots such as `C:\`. Paths inside Linux or a Linux container follow Linux conventions, even if Windows hosts the environment.

## DevOps scenario: configuration file not found

A deployment expects `./config/app.json`, but the application reports that the file is missing.

1. Find the application's actual working directory. Your interactive terminal may use a different one.
2. Confirm that the file exists at the resolved path.
3. Check filename capitalization: Linux filesystems are commonly case-sensitive.
4. Check the runtime user's permissions.
5. If containerized, check image contents and volume mounts. A mount can hide files that were included in the image.

Fix the deployment path, working-directory setting, or application configuration based on what you find.

## Quick revision

- **Are `/` and `/root` the same?** No.
- **Is `/proc` ordinary disk storage?** No. It is a virtual filesystem.
- **Must every directory use the same disk?** No. Mount points can connect other filesystems.

## References

- [Linux filesystem hierarchy](https://man7.org/linux/man-pages/man7/hier.7.html)
- [The proc filesystem](https://man7.org/linux/man-pages/man5/proc.5.html)
- [df filesystem usage - GNU Coreutils](https://www.gnu.org/software/coreutils/manual/html_node/df-invocation.html)

[Back to Day 2](README.md) | [Previous: CPU scheduling](05-cpu-scheduling.md)
