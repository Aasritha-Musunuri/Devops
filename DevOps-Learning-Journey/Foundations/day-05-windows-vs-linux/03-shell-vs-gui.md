# Shell vs. graphical interface

**Module:** Foundations

**Topic:** Windows vs. Linux

## What is a GUI?

GUI means **graphical user interface**. You interact using windows, icons, buttons, and menus. Opening a folder in Windows File Explorer is a familiar example.

## What is a shell?

A shell is a program that accepts commands and carries them out, often by starting other programs. Bash and PowerShell are shells.

Think of opening a folder in two ways: click it in a file manager, or type a command that changes to that folder.

## Is a terminal the same as a shell?

No. A terminal is the window or interface you use to interact with a shell. Windows Terminal can host different shells, such as PowerShell or Bash through WSL.

**Terminal = where you type. Shell = what interprets the commands.**

## Why does this matter in DevOps?

Commands can be saved in scripts and run automatically. This helps repeat checks and deployments without clicking the same buttons every time.

A command's meaning depends on the shell and tools available. A Linux command copied into PowerShell may fail or behave differently.

## Simple example

In Linux Bash:

```bash
pwd
```

In PowerShell:

```powershell
Get-Location
```

Both show the current location using their respective tools.

## Real example: a copied command fails

You paste a Bash command into a PowerShell tab.

**What to check:** Confirm which shell the tab is running and which environment the example requires. Changing administrator permissions will not fix the wrong command syntax.

## What to remember

**Check the shell before copying a command.**

## Further reading

[What is Bash? - GNU](https://www.gnu.org/software/bash/manual/html_node/What-is-Bash_003f.html)

[Back to Day 5](README.md) | [Next: WSL2](04-wsl2-on-windows.md)
