# What is a kernel?

**Module:** Foundations

**Topic:** OS basics

## Question

What is the kernel of an operating system, and why does it matter in DevOps?

## Short explanation

The kernel is the core of the operating system. It manages resources such as CPU time, memory, devices, and access to files. Applications use it whenever they need these resources.

## Answer

The **kernel** is the part of the operating system that manages hardware resources and provides services to programs. Applications request operations through **system calls**, such as opening a file or sending data through a socket. The kernel also provides mechanisms for process isolation and access control.

Linux is a kernel. A distribution such as Ubuntu combines that kernel with command-line tools, libraries, services, and a package manager.

## Detailed explanation

### Application, shell, and kernel

- **Application:** a program doing a task, such as a web server.
- **Shell:** a command interpreter, such as Bash. It starts programs and connects their input and output.
- **Kernel:** manages the resources those programs use.

Opening a file does not mean the application directly controls an SSD. A simplified flow is:

```text
Application requests a file read
             |
             v
Kernel checks access and handles the filesystem operation
             |
             v
Data comes from memory cache or the storage device
             |
             v
Application receives the bytes
```

### User space and kernel space

Most application code runs in **user space**, with restricted privileges. Kernel code runs with privileges needed to manage the machine. A system call provides a controlled way to request a kernel operation.

This separation helps stop one application from freely accessing another application's memory or controlling hardware. It does not mean that applications cannot fail or that all security problems disappear.

## Practical example

In a Linux terminal:

```bash
uname -s
uname -r
cat /etc/os-release
```

- `uname -s` prints the kernel name, normally `Linux`.
- `uname -r` prints the running kernel release.
- `/etc/os-release` describes the distribution, such as Ubuntu.

The distribution version and kernel release are different values. Under WSL 2, you will see the Linux kernel used by the WSL environment.

## DevOps scenario: containers and the kernel

A Linux container normally shares the kernel of its Linux host. It provides an isolated process environment rather than booting a separate kernel for each container. On Windows, Docker Desktop commonly runs Linux containers through a Linux VM or WSL 2 backend.

If an application requires a kernel feature, changing only the container image may not provide that feature. Check the host kernel and runtime configuration as well as the image.

## Quick revision

- **Is Bash a kernel?** No. Bash is a shell running as a program.
- **Is Ubuntu just the Linux kernel?** No. It is a distribution containing the kernel and other software.
- **Does every Linux container have its own kernel?** Normally, containers share the Linux host's kernel.

## References

- [Linux kernel administrator documentation](https://www.kernel.org/doc/html/latest/admin-guide/index.html)
- [System calls - Linux manual](https://man7.org/linux/man-pages/man2/syscalls.2.html)
- [What is a container? - Docker Docs](https://docs.docker.com/get-started/docker-concepts/the-basics/what-is-a-container/)

[Back to Day 2](README.md) | [Next: Processes vs. threads](02-processes-vs-threads.md)
