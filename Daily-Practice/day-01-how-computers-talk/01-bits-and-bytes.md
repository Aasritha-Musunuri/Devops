# Bits and bytes

## What is a bit?

A bit is the smallest unit of digital data. It has one of two values: `0` or `1`.

## Why only 0 and 1?

Computers are built using electronic circuits. Digital circuits can reliably distinguish between two signal levels:

```text
LOW electrical signal  -> 0
HIGH electrical signal -> 1
```

These are ranges of signal levels, rather than one exact voltage. The voltage depends on the circuit.

At this level, a computer does not recognize a letter such as `A` directly. Software represents the letter using a pattern of bits. For example, the ASCII code for `A` is decimal 65, written in binary as `01000001`.

## What is a byte?

A byte contains 8 bits. File sizes, storage capacity, and memory sizes are commonly measured in bytes and their multiples.

```text
8 bits = 1 byte
```

Uppercase `B` means bytes. Lowercase `b` means bits.

- `MB`: megabytes, commonly used for file sizes.
- `Mbps`: megabits per second, commonly used for network speed.

## Where does this appear in DevOps?

On a Linux server, this command lists files with readable sizes:

```bash
ls -lh
```

The size column might contain values such as:

```text
10K
25M
1.2G
```

These represent file sizes in roughly kilobytes, megabytes, and gigabytes. On GNU/Linux, `ls -lh` uses powers of 1024 for these units.

The command runs in a Linux terminal, such as Ubuntu in WSL. In Windows PowerShell, a simple way to inspect file sizes is:

```powershell
Get-ChildItem -File
```

The `Length` column shows the size in bytes.

Data sizes come up throughout DevOps:

- **Docker images:** image size affects downloads and deployment time.
- **Log files:** growing logs can fill a server's disk.
- **Databases:** stored data and backups consume storage.
- **Build artifacts:** application packages need storage and take time to transfer.
- **Container filesystems:** files written by an application consume space.
- **Network traffic:** transferred data is counted in bytes; bandwidth is often reported in bits per second.

## Example: a server disk is full

An application stops writing logs because the disk is full. On Linux, start by checking filesystem usage:

```bash
df -h
```

Then check the space used by log directories:

```bash
du -sh /var/log/*
```

`df` shows used and available filesystem space. `du` estimates disk space used by files and directories. Some directories require additional permissions to inspect.

If one application's logs are taking up most of the space, investigate why they are growing and whether log rotation is configured. Avoid deleting logs before checking whether they are needed for troubleshooting or retention.

File size and disk usage are related, but they are not always identical. Filesystem overhead and sparse files can make them differ.

## Example: downloading a Docker image

An image is 100 MB and the network speed is 80 Mbps.

```text
80 Mbps / 8 = 10 MB per second
100 MB / 10 MB per second = 10 seconds
```

The ideal download time is 10 seconds. Actual time depends on network overhead, available bandwidth, and registry performance.

## Units to remember

- 1 kB = 1,000 bytes; 1 MB = 1,000,000 bytes.
- 1 KiB = 1,024 bytes; 1 MiB = 1,048,576 bytes.

File size is usually measured in bytes. Network speed is usually measured in bits per second. Check the units before comparing numbers.

## Reference

[File size units - GNU Coreutils](https://www.gnu.org/software/coreutils/manual/html_node/Block-size.html)
