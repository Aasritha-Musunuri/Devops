# find: search the filesystem

**Module:** Linux

**Topic:** File operations

## What is find?

`find` walks a directory tree and selects entries that match conditions such as a name or file type.

Tell a librarian which shelf to start at and what kind of book you need. “Find a book” without a starting place is incomplete.

## Why does this matter in DevOps?

Find a misplaced configuration, artifact, or log file. A narrow starting folder makes the search quicker and avoids unrelated permission errors.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07/find-demo/logs
cd ~/devops-practice/day07
printf "INFO Ready\n" > find-demo/logs/app.log
find find-demo -type f -name "*.log"
```

`find-demo` is the starting directory. `-type f` selects regular files. `-name "*.log"` matches filenames ending in `.log`. Quotes leave the pattern for `find` to interpret, rather than letting the shell expand it first.

**What you should see:**

```text
find-demo/logs/app.log
```

## Real scenario: `find "*.log"` reports “No such file or directory”.

That argument is treated as a starting pathname. Use `find . -type f -name "*.log"` to search below the current folder, or provide the application’s known log directory.

## Important detail

Linux filenames are normally case-sensitive: `-name "*.log"` does not necessarily match `APP.LOG`. Use `-iname` for case-insensitive name matching. Start with inspection; do not add deletion actions to a search until the matched set has been carefully reviewed.

## What to remember

**find needs a starting place and a condition.**

## Further reading

[Command reference](https://www.gnu.org/software/findutils/manual/html_mono/find.html)

[Previous: nano and vim: edit text in a terminal](10-nano-vim-basics.md) | [Next: locate: search an index of filenames](12-locate.md)
