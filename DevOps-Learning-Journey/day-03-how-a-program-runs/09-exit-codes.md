# Exit codes

## What is an exit code?

An exit code is a number a process returns when it finishes. Scripts and pipelines use that number to decide what to do next.

For most command-line tools, `0` means success. A nonzero value means a failure or another condition defined by that tool.

```text
Command finishes -> returns an exit code -> automation checks the result
```

The meaning of a specific number depends on the command. A search tool, for example, may return a nonzero code when it finds no matches, even though it did not crash. Check the tool's documentation and logs before interpreting the result.

## Practical example

In Linux Bash:

```bash
true
echo $?
false
echo $?
```

`true` returns success, so the first result is `0`. `false` deliberately returns failure, so the next result is `1`. These commands do not represent an actual incident.

`$?` is the previous command's exit status. Read it immediately, because another command replaces it.

## PowerShell distinction

In PowerShell, `$?` is a Boolean success indicator. `$LASTEXITCODE` holds the exit code from the last native program, not from every PowerShell cmdlet. The Bash and PowerShell variables are not interchangeable.

## DevOps scenario: a pipeline passes despite a failure

A shell script runs a failed build, then prints a successful message. If it returns only the final command's status, the runner may receive success. Review how the script propagates failures. Seeing the word “error” in logs is not the same as returning failure to automation.

## Quick revision

- **Does every nonzero code mean the same thing?** No.
- **Is a zero code proof that the application is healthy?** No; it only reflects that command's result.

## References

- [Bash exit status](https://www.gnu.org/software/bash/manual/html_node/Exit-Status.html)
- [PowerShell automatic variables](https://learn.microsoft.com/en-us/powershell/module/microsoft.powershell.core/about/about_automatic_variables)

[Back to Day 3](README.md) | [Next: .NET CLR, JIT, and MSIL](10-dotnet-clr-jit-msil.md)
