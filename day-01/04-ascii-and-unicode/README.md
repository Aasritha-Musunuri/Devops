# Topic 4: ASCII and Unicode

## Understand

ASCII defines 128 character codes; `A` is decimal 65. Unicode assigns code points to characters from many languages. UTF-8 is an encoding that turns Unicode text into bytes. ASCII characters use one byte each in UTF-8; other characters can use multiple bytes.

Character counts and byte counts can differ. In .NET, a string's `Length` counts UTF-16 code units, which is also not always the number of visible characters.

## Practical

```powershell
[int][char]'A'
[char]65
$accent = [string][char]0x00E9
$emoji = [char]::ConvertFromUtf32(0x1F600)
'A', $accent, $emoji | ForEach-Object {
    $encoded = [Text.Encoding]::UTF8.GetBytes($_)
    [pscustomobject]@{
        Text = $_
        UTF16Units = $_.Length
        UTF8Bytes = $encoded.Length
        HexBytes = (($encoded | ForEach-Object { '{0:X2}' -f $_ }) -join ' ')
    }
}
```

Expected: `A` uses 1 UTF-8 byte (`41`), the accented letter uses 2 (`C3 A9`), and the emoji uses 4 (`F0 9F 98 80`). Their .NET lengths are 1, 1, and 2 respectively. A missing font may display a box for the emoji; inspect the byte count to confirm the encoding.

Create a file with explicit UTF-8 encoding and no byte-order mark:

```powershell
$textPath = Join-Path (Get-Location) 'utf8-sample.txt'
$utf8 = [Text.UTF8Encoding]::new($false)
[IO.File]::WriteAllText($textPath, ('A' + $accent + $emoji), $utf8)
(Get-Item -LiteralPath $textPath).Length
Format-Hex -Path $textPath
```

Expected file size: **7 bytes**, with no newline. PowerShell versions have different default text-file encodings, so this exercise selects the encoding explicitly.

DevOps connection: encoding mismatches can corrupt logs, configuration, API payloads, and filenames.

## Checkpoint

1. Why is the file seven bytes even though it displays three symbols?
2. Explain the difference between Unicode and UTF-8.
3. Why should you specify encoding when exchanging files between systems?
4. Does a hex dump show characters or their encoded bytes?
