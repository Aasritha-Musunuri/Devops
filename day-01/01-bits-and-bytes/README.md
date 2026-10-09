# Bits and bytes

## Overview

A **bit** is one binary digit: `0` or `1`. A **byte** contains 8 bits. A byte can represent 256 different patterns, from decimal 0 through 255. What a pattern means depends on how software interprets it: a number, part of a character, or part of an image.

Storage sizes are commonly expressed in bytes. Network speeds are commonly expressed in bits per second. Uppercase `B` means bytes; lowercase `b` means bits.

- 1 kB = 1,000 bytes; 1 MB = 1,000,000 bytes.
- 1 KiB = 1,024 bytes; 1 MiB = 1,048,576 bytes.

In PowerShell, the `1KB` numeric suffix means 1,024 bytes. Keep that distinction in mind when comparing tools and provider reports.

## Practical: inspect real bytes

Run these commands in PowerShell from the `day-01` folder.

```powershell
[byte[]]$sampleBytes = 0, 1, 65, 255
$samplePath = Join-Path (Get-Location) 'sample-bytes.bin'
[System.IO.File]::WriteAllBytes($samplePath, $sampleBytes)
Get-Item -LiteralPath $samplePath | Select-Object Name, Length
Format-Hex -Path $samplePath
```

Expected: `Length` is **4**, meaning four bytes. In the hex view, the bytes are `00 01 41 FF`. Decimal 65 is `41` in hexadecimal. The right-hand character view may show `A` for byte 65; it is only an interpretation of that byte.

Now calculate how many bits the file contains:

```powershell
$fileSizeBytes = (Get-Item -LiteralPath $samplePath).Length
$fileSizeBytes * 8
```

Expected: **32 bits**.

## Practical: estimate transfer time

```powershell
$fileSizeMB = 10
$speedMbps = 20
$idealSeconds = ($fileSizeMB * 1000000 * 8) / ($speedMbps * 1000000)
$idealSeconds
```

Expected: **4 seconds** under ideal conditions. Actual transfers include overhead and may be slower.

this conversion helps you interpret artifact size, download time, network throughput, and bandwidth limits.
