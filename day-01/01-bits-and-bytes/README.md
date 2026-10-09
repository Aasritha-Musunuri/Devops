# Topic 1: Bits and bytes

## Understand

A **bit** is one binary digit: `0` or `1`. A **byte** contains 8 bits. A byte can represent 256 different patterns, from decimal 0 through 255. What a pattern means depends on how software interprets it: a number, part of a character, or part of an image.

Storage sizes are commonly expressed in bytes. Network speeds are commonly expressed in bits per second. Uppercase `B` means bytes; lowercase `b` means bits.

- 1 kB = 1,000 bytes; 1 MB = 1,000,000 bytes.
- 1 KiB = 1,024 bytes; 1 MiB = 1,048,576 bytes.

In PowerShell, the `1KB` numeric suffix means 1,024 bytes. Keep that distinction in mind when comparing tools and provider reports.

## Practical: inspect real bytes

Run in PowerShell from the `day-01` folder. First predict the file size.

```powershell
[byte[]]$sampleBytes = 0, 1, 65, 255
$samplePath = Join-Path (Get-Location) 'sample-bytes.bin'
[System.IO.File]::WriteAllBytes($samplePath, $sampleBytes)
Get-Item -LiteralPath $samplePath | Select-Object Name, Length
Format-Hex -Path $samplePath
```

Expected: `Length` is **4**, meaning four bytes. In the hex view, the bytes are `00 01 41 FF`. You will learn why 65 appears as `41` in topic 3. The right-hand character view may show `A` for byte 65; it is only an interpretation of that byte.

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

DevOps connection: this conversion helps you interpret artifact size, download time, network throughput, and bandwidth limits.

## Checkpoint

Write your answers in `../notes.md`:

1. How many bits are in 6 bytes?
2. Why can an unsigned byte represent 255 but not 256?
3. At an ideal 8 Mbps, how long does a 2 MB file take to transfer?
4. Are 1 MB and 1 MiB equal? Explain.

Challenge: change the byte array to six values, each between 0 and 255. Predict its size, rerun the commands, and compare.

Common mistake: treating 20 Mbps as 20 megabytes per second. Divide bits per second by 8 to obtain bytes per second.

Keep the sample file as evidence. Move to [binary](../02-binary/README.md) after reviewing this checkpoint.
