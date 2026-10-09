# Day 1: How computers talk

The basics of how computers store information and exchange messages.

## Topics

1. [Bits and bytes](01-bits-and-bytes/README.md)
2. [Binary](02-binary/README.md)
3. [Hexadecimal](03-hex/README.md)
4. [ASCII and Unicode](04-ascii-and-unicode/README.md)
5. [Client versus server](05-client-and-server/README.md)
6. [Request and response](06-request-and-response/README.md)

## Running the examples

The examples use PowerShell. From the repository root:

```powershell
Set-Location .\day-01
```

The client/server and HTTP examples use `scripts/local-http-server.ps1` in a separate PowerShell window. It listens on `127.0.0.1:8088` and stops after two requests.
