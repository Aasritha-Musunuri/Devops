# Common Linux directories

**Module:** Linux

**Topic:** Filesystem and navigation

## What is the filesystem tree?

Linux organizes paths under one starting point, `/`, called the root directory. Other directories branch out beneath it.

Think of a building with labeled rooms: knowing the usual purpose of each room helps you look in the right place.

## /etc: system configuration

Many system and service settings live here. For example, `/etc/os-release` identifies the operating system on many distributions.

Not all application configuration lives here; applications can use other locations.

## /var: changing data

Files that change during normal operation commonly live here. `/var/log` is a familiar location for logs.

Some services send logs to the system journal or container output instead of ordinary files, so an empty log directory does not prove there are no logs.

## /home: users' files

A normal user's home directory is commonly `/home/username`. It holds that user's files and settings.

The administrator account named `root` commonly has `/root` as its home. `/root` and the filesystem root `/` are different locations.

## /tmp: temporary files

Programs use this location for temporary work. Files can be cleaned automatically, depending on system policy. Do not rely on it to keep important application data.

## /opt: additional application software

Some applications are installed under `/opt`. It is a convention, not a requirement that every application must follow.

## Real example: an important report disappeared

The application saved its only report copy under `/tmp`, and a cleanup removed it.

**What to check:** Confirm the output path and cleanup policy. Store important results in a suitable persistent location with appropriate access and backup arrangements.

## What to remember

**/etc: settings. /var: changing data. /home: user files. /tmp: temporary work. /opt: additional software.**

## Further reading

[Linux filesystem hierarchy](https://man7.org/linux/man-pages/man7/hier.7.html)

[Back to Day 6](README.md) | [Next: Hidden files](07-hidden-files.md)
