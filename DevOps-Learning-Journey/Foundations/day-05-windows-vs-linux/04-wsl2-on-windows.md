# WSL2: Linux on Windows

**Module:** Foundations

**Topic:** Windows vs. Linux

## What is WSL?

WSL means **Windows Subsystem for Linux**. It lets you use a Linux environment on a Windows computer without replacing Windows or rebooting into another operating system.

WSL2 uses a real Linux kernel in a lightweight managed virtual machine. Ubuntu is one distribution you can run with it.

**Windows is the computer's main operating system. WSL provides a place to use Linux alongside it.**

## Why use it for these lessons?

It gives you a Linux terminal for practicing commands while keeping your Windows editor and other applications available.

It is a learning and development environment, not proof that an application will behave identically on every production server.

## First, check what is already installed

In PowerShell:

```powershell
wsl --list --verbose
```

This lists installed distributions and whether each uses WSL version 1 or 2. A `VERSION` value of `2` means that distribution uses WSL2.

If it fails, read the error first. A service or permission problem does not necessarily mean there are no distributions installed.

## If WSL is not installed

On a supported Windows machine, Microsoft's usual installation command is:

```powershell
wsl --install -d Ubuntu
```

Installation normally requires an administrator PowerShell window and may require a restart. It changes Windows features and installs software; it is not merely an inspection command. On a managed work laptop, follow your organization's installation process.

After installation, open Ubuntu and complete its first-run username and password setup. The Linux account is separate from the Windows account. Password typing may show no characters; that is normal.

## Before Day 6

In the Ubuntu terminal, run:

```bash
pwd
```

A new user's starting directory is often `/home/yourname`; the exact result depends on how the terminal was opened.

## What to remember

**Run Day 6's Bash commands in Linux, not an ordinary PowerShell tab.**

## Further reading

- [Install WSL - Microsoft](https://learn.microsoft.com/en-us/windows/wsl/install)
- [WSL commands - Microsoft](https://learn.microsoft.com/en-us/windows/wsl/basic-commands)

[Back to Day 5](README.md) | [Next: Day 6](../../Linux/day-06-filesystem-and-navigation/README.md)
