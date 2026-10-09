# Local teaching server, not a production HTTP implementation.
param(
    [ValidateRange(1024, 65535)]
    [int]$Port = 8088
)

$ErrorActionPreference = 'Stop'
$listener = [Net.Sockets.TcpListener]::new([Net.IPAddress]::Loopback, $Port)
try {
    $listener.Start()
    Write-Host "Listening on http://127.0.0.1:$Port (two requests, then stop)."
    for ($requestNumber = 1; $requestNumber -le 2; $requestNumber++) {
        $client = $listener.AcceptTcpClient()
        try {
            $client.ReceiveTimeout = 10000
            $client.SendTimeout = 10000
            $stream = $client.GetStream()
            $reader = [IO.StreamReader]::new($stream, [Text.Encoding]::ASCII, $false, 1024, $true)
            $requestLine = $reader.ReadLine()
            if ([string]::IsNullOrWhiteSpace($requestLine)) { continue }
            Write-Host "Request $requestNumber`: $requestLine"
            while ($null -ne ($headerLine = $reader.ReadLine()) -and $headerLine -ne '') {
                # Read and discard headers for this simple GET-only lesson.
            }
            if ($requestLine -match '^GET /hello HTTP/1\.[01]$') {
                $status = '200 OK'
                $body = '{"message":"Hello from your local server"}'
            } else {
                $status = '404 Not Found'
                $body = '{"error":"Route not found. Try GET /hello"}'
            }
            $bodyBytes = [Text.Encoding]::UTF8.GetBytes($body)
            $headers = "HTTP/1.1 $status`r`nContent-Type: application/json; charset=utf-8`r`nContent-Length: $($bodyBytes.Length)`r`nConnection: close`r`n`r`n"
            $headerBytes = [Text.Encoding]::ASCII.GetBytes($headers)
            $stream.Write($headerBytes, 0, $headerBytes.Length)
            $stream.Write($bodyBytes, 0, $bodyBytes.Length)
            $stream.Flush()
            $reader.Dispose()
        } finally {
            $client.Dispose()
        }
    }
} finally {
    $listener.Stop()
}
