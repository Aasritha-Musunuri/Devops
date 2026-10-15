# RAM vs. disk

## Question

What is the difference between RAM and disk storage? What would you check when a server runs out of either?

## Short explanation

RAM holds data that running programs are actively using. Disk storage holds files that need to remain after programs exit or the machine powers off.

## Answer

**RAM** is fast working memory and is normally volatile: its contents disappear when power is lost. **Disk storage**, such as an SSD or HDD, retains written data without power and usually has higher capacity but slower access than RAM.

A machine can have plenty of free disk space and still run out of RAM. Check memory and filesystem capacity separately.

## Detailed explanation

### Example: starting an application

1. The application's executable and configuration are stored on disk.
2. The OS loads or maps needed code and data into memory.
3. The application uses RAM for runtime objects, buffers, and caches.
4. Data that must persist is written to storage, directly or through a database.

Restarting an application discards its ordinary in-memory state. Properly persisted data can remain available.

### What is swap?

Swap provides backing storage for some memory pages, commonly through a disk file or partition. It can help under memory pressure, but frequent movement between RAM and disk can make a system slow.

Swap does not make storage perform like RAM. Whether swap is available and how it behaves depends on the environment.

### Why can Linux show little free RAM?

Linux uses otherwise idle memory to cache data. Some cache can be reclaimed when applications need memory. The `available` value from `free` is therefore more useful than looking only at `free` memory.

## Practical example

In Linux:

```bash
free -h
df -h
df -i
```

- `free -h`: RAM and swap usage in readable units.
- `df -h`: filesystem space usage.
- `df -i`: inode usage. A filesystem can run out of file metadata entries even when bytes remain available.

In Windows, open **Task Manager > Performance > Memory** for RAM. Use PowerShell to inspect filesystem drives:

```powershell
Get-PSDrive -PSProvider FileSystem | Select-Object Name, Used, Free
```

The numeric `Used` and `Free` values are in bytes.

## DevOps scenario: the app cannot write logs

The application reports `No space left on device`.

1. Identify the filesystem containing the failing log path using `df -h /var/log`.
2. Check its inode capacity using `df -i /var/log`.
3. Inspect directory usage with `du -sh /var/log/*`. Permissions may limit what is visible.
4. Investigate log growth, retention, and rotation before choosing a cleanup action.

If the application is being terminated because of memory pressure, inspect memory metrics and OS or container events instead. A container can hit its memory limit while the host still has available RAM.

## Quick revision

- **Will adding disk space fix a memory leak?** No.
- **Does low free RAM prove a problem?** No. Check available memory, workload behavior, and pressure over time.
- **Is a full disk the same as high disk I/O?** No. Capacity and read/write performance are different concerns.

## References

- [free command and available memory](https://man7.org/linux/man-pages/man1/free.1.html)
- [df filesystem usage - GNU Coreutils](https://www.gnu.org/software/coreutils/manual/html_node/df-invocation.html)
- [Container resource constraints - Docker Docs](https://docs.docker.com/engine/containers/resource_constraints/)

[Back to Day 2](README.md) | [Next: Database, disk, and cloud storage](04-database-vs-disk-vs-cloud-storage.md)
