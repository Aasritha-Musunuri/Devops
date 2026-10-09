# Day 1: How computers talk

Goal: understand how computers represent information and how a client exchanges messages with a server.

Open PowerShell in the repository root and enter this folder:

```powershell
Set-Location .\day-01
```

Work through these topics in the sheet's order. Start with topic 1 today; continue only when you can explain it and complete its checkpoint.

1. [Bits and bytes](01-bits-and-bytes/README.md)
2. [Binary](02-binary/README.md)
3. [Hexadecimal](03-hex/README.md)
4. [ASCII and Unicode](04-ascii-and-unicode/README.md)
5. [Client versus server](05-client-and-server/README.md)
6. [Request and response](06-request-and-response/README.md)

Allow roughly 10–20 minutes per topic. Take longer if needed; finishing a calendar day is less important than understanding the practical.

Use [notes.md](notes.md) for your predictions, outputs, and answers. Topics 5 and 6 share a local HTTP server. It binds only to `127.0.0.1` and closes after two requests. Two PowerShell windows are needed.

## Completion check

- [ ] I can explain bits, bytes, and storage units.
- [ ] I can convert a small decimal number to binary and back.
- [ ] I can read a byte in hexadecimal.
- [ ] I can explain why character count differs from encoded byte count.
- [ ] I can identify the client, server, address, and port in the local practical.
- [ ] I can explain a successful HTTP response and a 404 response.

Next session: tell me `Day 1, topic 1` and share your checkpoint answers. We will review them together before moving forward.
