# ASCII and Unicode

## How does a computer store text?

Computers store bytes. A character encoding tells software how to turn text into bytes and read those bytes back as text.

ASCII defines 128 character codes, including English letters, numbers, and basic symbols. For example, `A` has the code 65.

Unicode covers characters from many languages, along with symbols and emoji. UTF-8 is an encoding used to store Unicode text as bytes.

## Why does this matter in DevOps?

Text passes between applications, servers, databases, and log systems. If one program reads a file using the wrong encoding, the text may appear broken.

This can affect:

- Application logs containing customer names.
- Configuration files containing non-English text.
- API responses and database exports.
- Scripts copied between Windows and Linux.

## Example: unreadable text in a log

A name looks correct in the application but appears as strange characters in an exported log.

Check how the application wrote the file and how the log viewer reads it. Both need to use the correct encoding. A missing font can also prevent a character from displaying correctly.

In VS Code, the status bar shows the file encoding. If the text appears wrong, use **Reopen with Encoding** to try the encoding that produced the file. Once the text is readable, **Save with Encoding** can convert it to the required encoding.

Simply saving already misread text as UTF-8 does not necessarily repair it.

## Characters and file size

In UTF-8:

```text
A        -> 1 byte
é        -> 2 bytes
😀       -> 4 bytes
```

These examples show why counting visible characters is not the same as counting bytes.

## What to remember

Unicode identifies characters. UTF-8 encodes them as bytes. Consistent encoding prevents many text problems between systems.

## Reference

[Unicode encoding FAQ](https://www.unicode.org/faq/utf_bom.html)
