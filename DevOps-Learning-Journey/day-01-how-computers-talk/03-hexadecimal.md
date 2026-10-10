# Hexadecimal

## What is hexadecimal?

Hexadecimal, or hex, writes numbers using 16 digits:

```text
0 1 2 3 4 5 6 7 8 9 A B C D E F
```

`A` means 10, `B` means 11, and `F` means 15.

It is a shorter way to display binary data. One hex digit represents four bits; two hex digits represent one byte.

```text
Decimal 255 = binary 11111111 = hex FF
```

## Where does this appear in DevOps?

Hex is often visible in file checksums, container image digests, MAC addresses, and IPv6 addresses. It makes long values easier to display than strings of zeros and ones.

## Example: checking a downloaded file

A software publisher may provide a SHA-256 checksum alongside a download. Calculate the downloaded file's checksum and compare the complete value with the publisher's trusted value.

For a simple local example, open PowerShell in this day's folder:

```powershell
Get-FileHash .\03-hexadecimal.md
```

The command shows the algorithm, hash, and file path. By default, it uses SHA-256, whose hash is displayed as 64 hexadecimal characters.

The hash depends on the file's contents. Changing the contents normally changes the hash. There is no fixed expected value for this example because the notes can change.

When a download's hash differs from the expected one, investigate whether it is a different version, an incomplete download, or a changed file.

## What to remember

Hex is a way to display a value. A hash is calculated from data. Neither should be confused with encryption, and a matching checksum is only as trustworthy as the expected checksum's source.

## Reference

[Get-FileHash - Microsoft Learn](https://learn.microsoft.com/en-us/powershell/module/microsoft.powershell.utility/get-filehash)
