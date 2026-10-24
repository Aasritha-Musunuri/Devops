# Hexadecimal

**Module:** Foundations

**Topic:** How computers talk

## 1. What is hexadecimal?

Hexadecimal, or hex, is a base-16 number system. It uses 16 symbols, unlike decimal, which uses 10, and binary, which uses 2.

- **Binary:** base 2, using `0` and `1`.
- **Decimal:** base 10, using `0` to `9`.
- **Hexadecimal:** base 16, using `0` to `9` and `A` to `F`.

In hexadecimal, the letters represent these numbers:

```text
A = 10
B = 11
C = 12
D = 13
E = 14
F = 15
```

Hexadecimal `A` represents the number 10. This is different from the ASCII code for the character `A`, which is decimal 65.

## 2. Why is hexadecimal useful?

Computers represent data in binary, but long sequences of zeros and ones are difficult for people to read. Hex makes those values shorter to display.

The same number can be written in three ways:

```text
Binary:      11111111
Decimal:     255
Hexadecimal: FF
```

Four binary bits correspond exactly to one hex digit. Four bits have 16 possible combinations, matching the 16 hex symbols.

An 8-bit byte can therefore be written using two hex digits, from `00` to `FF`.

## 3. How do we convert binary into hexadecimal?

Take the binary number `10101111`.

First, divide it into groups of four bits:

```text
1010 1111
```

Each group's positions have the values 8, 4, 2, and 1.

```text
1010 = 8 + 2         = 10 = A
1111 = 8 + 4 + 2 + 1 = 15 = F
```

Combine the two hex digits:

```text
Binary 10101111 = hex AF
```

To check its decimal value:

```text
AF = (10 x 16) + 15 = 175
```

Hex values are often written with a `0x` prefix in programming. For example, `0xAF` means that `AF` is hexadecimal. The prefix identifies the number system; it is not part of the value.

## 4. Where is hexadecimal used in DevOps?

Hex appears in tools used to identify and inspect data:

- **Docker image digests:** SHA-256 digests are commonly displayed as hex strings. A digest identifies particular image content.
- **Git commit hashes:** commits are identified by object IDs displayed in hex. These IDs help locate changes and deployment versions.
- **Linux troubleshooting:** memory addresses and raw file bytes are often displayed in hex.
- **Application debugging:** hex dumps help inspect the actual bytes in a file when its contents look unexpected.

Hex is a way to display a value. A hash is calculated from data. Neither should be confused with encryption.

## 5. A simple example: looking at the bytes of ABC

In a Linux terminal, such as Ubuntu in WSL:

```bash
printf 'ABC' | xxd
```

`printf` produces the text `ABC` without a newline. The pipe, `|`, sends it to `xxd`, which displays the bytes in hexadecimal.

If `xxd` is not installed, this command will report that it cannot be found.

The output will look similar to this; spacing may vary:

```text
00000000: 4142 43                                  ABC
```

Read it in three parts:

- `00000000` is the starting byte offset, meaning the position in the data.
- `41 42 43` are the three byte values in hex. The tool groups the first two together as `4142`.
- `ABC` is the readable text corresponding to those bytes.

For these characters, UTF-8 uses the same byte values as ASCII:

```text
A = decimal 65 = hex 41
B = decimal 66 = hex 42
C = decimal 67 = hex 43
```

This connects the topics: a character has a code, its encoding produces bytes, and hex gives us a readable way to inspect those bytes.

## 6. Example: checking a downloaded file

A software publisher may provide a SHA-256 checksum alongside a download. Calculate the downloaded file's checksum and compare the complete value with the publisher's trusted value.

For a simple local example, open PowerShell in this day's folder:

```powershell
Get-FileHash .\03-hexadecimal.md
```

The command shows the algorithm, hash, and file path. By default, it uses SHA-256, whose hash is displayed as 64 hex characters.

The hash depends on the file's contents, so there is no fixed expected result for these notes. Changing the contents normally changes the hash.

If a downloaded file's checksum differs from the expected one, investigate whether it is a different version, an incomplete download, or a changed file. A matching checksum is only as trustworthy as the source of the expected checksum.

## 7. Quick interview questions

**What is hexadecimal?**

A base-16 number system using digits `0` to `9` and letters `A` to `F`. It provides a compact way to write binary values.

**How many bits does one hexadecimal digit represent?**

Four bits, because four bits can represent 16 possible combinations.

**Is hexadecimal a type of computer memory?**

No. Hexadecimal is a way to write numbers, not a memory technology.

## Reference

[Get-FileHash - Microsoft Learn](https://learn.microsoft.com/en-us/powershell/module/microsoft.powershell.utility/get-filehash)
