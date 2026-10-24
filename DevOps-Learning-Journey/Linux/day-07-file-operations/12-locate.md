# locate: search an index of filenames

**Module:** Linux

**Topic:** File operations

## What is locate?

`locate` searches a previously built filename database. It can be faster than walking directories, but its results can be out of date.

It is like checking a library catalogue. A book added after the catalogue update may be missing from the list.

## Why does this matter in DevOps?

Find the likely location of an installed configuration or documentation file. When the result matters now, verify that the path still exists.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
command -v locate
locate passwd
```

`command -v` checks whether your shell can find the tool. Implementations such as plocate provide a `locate` command. You do not need to install it to continue these lessons; `find /etc -maxdepth 1 -name "*passwd*"` is a direct alternative.

**What you should see:**

```text
If locate is installed and its index exists, it prints matching pathnames. Otherwise it may be unavailable or report a missing database.
```

## Real scenario: A newly created file appears in `find`, but not in `locate`.

The filename database may not have been refreshed yet. Its updater is commonly called `updatedb`; updating a system index can require administrative access. Use `find` in the relevant folder when you need the current filesystem state.

## Important detail

An old pathname can remain in an index after deletion. Search coverage also depends on excluded directories and the implementation’s access rules. `locate` finds names, not words inside a file.

## What to remember

**find walks the folders now. locate searches an earlier index.**

## Further reading

[Command reference](https://plocate.sesse.net/)

[Previous: find: search the filesystem](11-find.md) | [Chapter overview](README.md)
