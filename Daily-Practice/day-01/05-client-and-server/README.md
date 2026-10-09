# Client versus server

## Overview

A **client** initiates a request. A **server** listens for requests and responds. These describe roles; both programs can run on the same computer.

PowerShell's `Invoke-WebRequest` is the client. The local HTTP script is the server. The address `127.0.0.1` is loopback, meaning this computer. Port `8088` identifies the listening endpoint.

## Practical: run a local server

Open two PowerShell windows in the repository root. In both, enter:

```powershell
Set-Location .\Daily-Practice\day-01
```

In window A:

```powershell
& .\scripts\local-http-server.ps1
```

Expected: `Listening on http://127.0.0.1:8088 (two requests, then stop).` The window stays busy because the server is waiting for a request. If script execution is blocked, inspect `Get-ExecutionPolicy -List`; do not change machine policy. You can paste the script contents into the window instead.

In window B:

```powershell
$response = Invoke-WebRequest -Uri 'http://127.0.0.1:8088/hello' -UseBasicParsing
$response.StatusCode
$response.Content
```

Expected: status **200** and JSON containing `"message":"Hello from your local server"`. Window A prints the HTTP request line.

The next HTTP example uses the same server window. The server closes after the second request. To stop early, press Ctrl+C. Do not send real secrets to this teaching server; it uses HTTP without TLS.

## Troubleshooting

if port 8088 is already in use, inspect `Get-NetTCPConnection -LocalPort 8088 -ErrorAction SilentlyContinue`. Choose a different unused port with `-Port 8090` when starting the server, then use that same port in the client URL. Do not stop an unfamiliar process.
