# Topic 2: Binary

## Understand

Decimal uses ten digits, 0–9. Binary uses two, 0 and 1. The eight positions in a byte have these weights, left to right:

```text
128  64  32  16   8   4   2   1
  0   1   0   0   0   0   0   1   = 64 + 1 = 65
```

Leading zeros do not change the value. We use them to display a complete byte.

## Practical

Predict each result, then run in PowerShell:

```powershell
[Convert]::ToString(65, 2).PadLeft(8, '0')
[Convert]::ToInt32('01000001', 2)
0, 1, 2, 7, 8, 15, 16, 255 | ForEach-Object {
    '{0} = {1}' -f $_, [Convert]::ToString($_, 2).PadLeft(8, '0')
}
```

The first two results are `01000001` and `65`. Notice how a new position becomes necessary when 7 becomes 8 and 15 becomes 16.

DevOps connection: IP addressing, subnet masks, permissions, and flags depend on binary representation.

## Checkpoint

1. Convert 10 to eight-bit binary by hand, then check with PowerShell.
2. Convert `00010101` to decimal by adding the position weights.
3. What does `11111111` represent as an unsigned byte?
4. Explain why `00000010` represents 2 rather than 10.

Challenge: predict the binary representation of 127 and 128. Explain which positions change.

Common mistake: reading binary digits as a decimal number. The base determines the position weights.
