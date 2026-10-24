# Absolute and relative paths

**Module:** Linux

**Topic:** Filesystem and navigation

## What is a path?

A path describes where a file or directory is located.

## What is an absolute path?

In Linux, an absolute path starts from `/`, the top of the filesystem.

```text
/var/log
```

Think of a complete street address. It identifies the location without relying on where you are standing.

## What is a relative path?

A relative path starts from the current working directory.

```text
logs/app.log
```

If the current directory is `/home/aasritha/shop`, that path refers to `/home/aasritha/shop/logs/app.log`.

## What do . and .. mean?

- `.` means the current directory.
- `..` means its parent directory.

`./logs` means the `logs` folder here. `../logs` means a `logs` folder under the parent directory.

## Real example: works in a terminal, fails as a service

The application opens `config/settings.json`. It works when started from the project folder, but the service starts it from a different working directory.

**What to check:** Confirm the working directory and how the application finds configuration. Set the intended working directory or use a suitable configured path. Some applications already resolve paths relative to their installation folder, so check their behavior.

An absolute path is clearer about location, but a hardcoded username can still make it wrong on another machine.

## Windows and Linux

Windows paths often use drive letters and backslashes, such as `C:\Projects\shop`. Linux paths use forward slashes and a single root, such as `/home/aasritha/shop`.

## What to remember

**Absolute: start at the root. Relative: start where you are.**

## Further reading

[Linux path resolution](https://man7.org/linux/man-pages/man7/path_resolution.7.html)

[Back to Day 6](README.md) | [Next: Common directories](06-common-linux-directories.md)
