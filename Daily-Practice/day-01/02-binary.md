# Binary

## Overview

Decimal uses ten digits, 0–9. Binary uses two, 0 and 1. The eight positions in a byte have these weights, left to right:

```text
128  64  32  16   8   4   2   1
  0   1   0   0   0   0   0   1   = 64 + 1 = 65
```

Leading zeros do not change the value. We use them to display a complete byte.

## Practical

Decimal and binary conversions in PowerShell:

```powershell
[Convert]::ToString(65, 2).PadLeft(8, '0')
[Convert]::ToInt32('01000001', 2)
0, 1, 2, 7, 8, 15, 16, 255 | ForEach-Object {
    '{0} = {1}' -f $_, [Convert]::ToString($_, 2).PadLeft(8, '0')
}
```

The first two results are `01000001` and `65`. Notice how a new position becomes necessary when 7 becomes 8 and 15 becomes 16.

IP addressing, subnet masks, permissions, and flags depend on binary representation.
