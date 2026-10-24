# touch: create an empty file or update its time

**Module:** Linux

**Topic:** File operations

## What is touch?

`touch` creates an empty file when the named file does not exist. If the file already exists, it normally updates its access and modification timestamps without replacing the contents.

For a new notebook, you create a blank page. For an existing notebook, you update its date stamp rather than erasing what is written.

## Why does this matter in DevOps?

Create a small marker file for a script, or understand why a timestamp changed. Build tools sometimes use timestamps to decide whether work needs to be rebuilt.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07
cd ~/devops-practice/day07
touch touch-demo.txt
ls -l touch-demo.txt
```

You supplied a filename, not text to write. To add content, use an editor or a command such as `printf`. Rerunning `touch` does not empty a nonempty file.

**What you should see:**

```text
The listing shows touch-demo.txt. On the first run, its size is 0 bytes.
```

## Real scenario: A pipeline rebuilt a component even though nobody edited its contents.

Inspect timestamps and the build tool’s dependency rules. A checkout, copy, extraction, or `touch` may have changed timestamps. A changed time alone does not prove that the file’s text changed.

## Important detail

`touch existing.txt` and `> existing.txt` are different. `touch` normally preserves the data; the shell redirection `>` can truncate it. Also, creating a marker file only has meaning if the application or script actually checks for it.

## What to remember

**New file: empty. Existing file: time changes, contents stay.**

## Further reading

[Command reference](https://www.gnu.org/software/coreutils/manual/html_node/touch-invocation.html)

[Previous: mkdir: create folders](04-mkdir.md) | [Next: cat: print a small text file](06-cat.md)
