# Hexadecimal

## Overview

Hexadecimal, or hex, is base 16. Its digits are `0–9` and `A–F`; A means 10 and F means 15. Each hex digit represents four bits, so two hex digits represent one byte.

Example: hex `41` = 4 × 16 + 1 = decimal 65 = binary `01000001`.

## Practical

Decimal, hexadecimal, and binary conversions:

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

The bytes `00 01 41 FF` represent decimal values 0, 1, 65, and 255.

hex appears in file inspection, packet bytes, hashes, and memory addresses. A hex representation is not encryption.
