# tree: see the folder structure

**Module:** Linux

**Topic:** Filesystem and navigation

## What is tree?

`tree` displays folders and files as a branching structure. It helps show which files belong inside which directories.

Think of a family tree: the layout shows relationships rather than a flat list of names.

## Simple example

If `tree` is installed, run this from a small project directory:

```bash
tree -L 2
```

`-L 2` limits the display to two levels. An illustrative result is:

```text
.
|-- app
|   `-- Program.cs
`-- README.md
```

The dot represents the current directory. `Program.cs` is inside `app`, while `README.md` is directly in the current directory.

## What if tree is not installed?

Some servers and minimal containers do not include it. There is no need to install it for this lesson. Use `ls` to list the current folder, then `ls app` if an `app` folder exists.

## Real example: the deployment copied an extra folder

The service expects `app/Program.dll`, but the package contains `app/publish/Program.dll`.

**What to check:** Inspect the folder structure and compare it with the startup path. The file may be present, but one directory deeper than expected.

## What to remember

**tree helps explain where a file sits inside a project.** Avoid listing an entire large server filesystem when a small project listing is enough.

## Further reading

[tree command manual](https://manpages.ubuntu.com/manpages/noble/en/man1/tree.1.html)

[Back to Day 6](README.md) | [Next: Paths](05-absolute-vs-relative-paths.md)
