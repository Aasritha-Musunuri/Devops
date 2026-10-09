# Topic 3: Hexadecimal

## Understand

Hexadecimal, or hex, is base 16. Its digits are `0–9` and `A–F`; A means 10 and F means 15. Each hex digit represents four bits, so two hex digits represent one byte.

Example: hex `41` = 4 × 16 + 1 = decimal 65 = binary `01000001`.

## Practical

Predict the output before running:

```powershell
'{0:X2}' -f 65
[Convert]::ToInt32('FF', 16)
0, 15, 16, 65, 255 | ForEach-Object {
    '{0} decimal = {0:X2} hex = {1} binary' -f $_, [Convert]::ToString($_, 2).PadLeft(8, '0')
}
```

Expected first results: `41` and `255`. `X2` formats the integer using at least two hexadecimal digits.

If you completed topic 1, inspect its file again:

```powershell
Format-Hex -Path .\sample-bytes.bin
```

Explain all four byte values without looking at topic 1's answer.

DevOps connection: hex appears in file inspection, packet bytes, hashes, and memory addresses. A hex representation is not encryption.

## Checkpoint

1. Convert `2A` to decimal by hand and verify with PowerShell.
2. Convert decimal 16 to hex.
3. Why does one byte fit in two hex digits?
4. Is hex `10` equal to decimal 10? Explain.

Challenge: convert `FF` to binary through decimal and explain the relationship between the two hex digits and the eight bits.
