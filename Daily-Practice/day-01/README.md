# Day 1: How computers talk

The basics of how computers store information and exchange messages.

## Topics

1. [Bits and bytes](01-bits-and-bytes.md)
2. [Binary](02-binary.md)
3. [Hexadecimal](03-hexadecimal.md)
4. [ASCII and Unicode](04-ascii-and-unicode.md)
5. [Client versus server](05-client-and-server.md)
6. [Request and response](06-request-and-response.md)

## Running the examples

The examples use PowerShell. From the repository root:

```powershell
Set-Location .\Daily-Practice\day-01
```

The client/server and HTTP examples use `local-http-server.ps1` in a separate PowerShell window. It listens on `127.0.0.1:8088` and stops after two requests.
