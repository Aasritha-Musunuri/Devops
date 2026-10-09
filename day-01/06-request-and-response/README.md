# Topic 6: Request and response

## Understand

An HTTP request includes a method, path, headers, and sometimes a body. A response includes a status code, headers, and sometimes a body.

For the previous exercise, the client sent `GET /hello HTTP/1.1`. The server responded with `200 OK`, a JSON content type, a content length in **bytes**, and a JSON body.

## Practical: inspect success and failure

Use the saved response in window B from topic 5:

```powershell
$response.StatusCode
$response.Headers
$response.Content | ConvertFrom-Json
```

Now request a path that does not exist:

```powershell
try {
    Invoke-WebRequest -Uri 'http://127.0.0.1:8088/missing' -UseBasicParsing -ErrorAction Stop
} catch {
    if ($null -ne $_.Exception.Response) {
        [int]$_.Exception.Response.StatusCode
    } else {
        $_.Exception.Message
    }
}
```

Expected: **404**. Window A prints the request and exits because it has served two requests. If you used a different port, update the URL. If the server already exited, restart it first.

Inspect the response construction in `scripts/local-http-server.ps1`. Find `Content-Type`, `Content-Length`, the status line, and the blank line separating headers from the body. This server is intentionally minimal and suitable only for this local lesson.

## Break and diagnose

Once the server has exited, request `/hello` again. You should get a connection error, not an HTTP 404. Explain why: in the first case a server answered; in the second no server was listening on that port.

DevOps connection: this distinction helps separate application routing problems from connectivity and service availability problems.

## Checkpoint

1. What method and path did the first request use?
2. What does HTTP 200 mean in this exercise? What does 404 mean?
3. Why does `Content-Length` count encoded bytes instead of visible characters?
4. Is a 404 response the same as connection refused?
5. Describe the complete journey: client, address, port, request, server, response.

Finish your notes and share the outputs and answers here. We will review Day 1 before creating Day 2.
