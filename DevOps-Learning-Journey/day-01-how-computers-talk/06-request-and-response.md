# Request and response

## What is a request?

A request is a message from a client asking a server to do something. In HTTP, it includes a method, a resource path, headers, and sometimes a body.

For example, a student API request can contain:

- **Method:** `GET` describes the action to perform.
- **Resource path:** `/api/students/101` identifies the resource to access within the API's URL.
- **Headers:** `Authorization: Bearer ...` supplies authentication information. Other headers can describe the content or client preferences.
- **Body:** data such as JSON is sent when needed, for example when submitting student details.

## HTTP methods to know

- **GET:** retrieve data, such as viewing student marks.
- **POST:** submit data for processing, commonly to create a resource such as a student.
- **PUT:** replace a resource's representation, such as replacing student details. It can also create a resource at the target URL if the API supports it.
- **PATCH:** partially update a resource, such as changing one field.
- **DELETE:** request removal of a resource, such as a student.

Clicking a button does not automatically mean POST. The frontend code determines which HTTP method is sent.

## What is a response?

A response is the server's answer. It includes a status code, headers, and sometimes a body containing content or an error message.

## What are headers and the body?

Headers describe the message. For example, `Content-Type: application/json` says that the body contains JSON data.

The body carries the content itself, such as a web page, a JSON result, or data submitted in a request.

An illustrative API response might look like this:

```text
Status: 200 OK
Header: Content-Type: application/json
Body:   {"status":"healthy"}
```

These labels explain the parts; they are not the literal HTTP wire format.

## Example: an application health check

A monitoring system can request an application's health endpoint:

```text
Request:  GET /health
Response: 200 OK
```

`GET` asks for information. `/health` is the path. The application must implement this endpoint; it is not available automatically on every website.

A 200 response means the request succeeded. How much this says about the application's health depends on what the endpoint actually checks.

## Where does this appear in DevOps?

Requests and responses help diagnose failed deployments, API errors, and load balancer health checks.

Useful status codes include:

- **200:** the request succeeded.
- **201:** a resource was created.
- **400:** the server cannot process the request because of a perceived client error, such as malformed request data.
- **401:** valid authentication credentials are missing.
- **403:** the server refuses access.
- **404:** the requested resource was not found.
- **405:** the HTTP method is not allowed for the requested resource.
- **500:** an unexpected server error occurred.
- **502:** a gateway or proxy received an invalid upstream response.
- **503:** the service is temporarily unavailable.
- **504:** a gateway or proxy did not receive an upstream response in time.

A status code is a clue. Application and proxy logs help establish the cause.

## DevOps troubleshooting

Suppose a deployed API is not working:

- **404:** check the API URL, application routing, and Ingress configuration if the deployment uses Ingress.
- **401/403:** check authentication, authorization, and permissions.
- **500:** check application logs, exceptions, and dependencies.
- **502:** check reverse proxy logs, backend availability, and connectivity from the proxy to the backend.
- **504:** check upstream response times, networking, and timeout settings.

Use these checks to investigate the cause rather than assuming the status code proves which component failed.

## A simple way to inspect a response

In a browser, open developer tools with `F12`, select **Network**, and reload a website. Select a request and look for its method, URL, status, headers, and response body.

For an optional command-line example, run this in Windows PowerShell:

```powershell
curl.exe -I https://example.com
```

`-I` sends a HEAD request and displays response headers without downloading the response body. The first line shows the HTTP version and status. Headers may differ between requests.

## A 404 is different from a connection failure

A 404 means an HTTP server answered but did not find the resource. A connection failure can happen before any HTTP response exists, for example when no service is listening on the target port.

## What to remember

Read the status code, check the relevant logs, and distinguish an application response from a network connection problem.

## References

[HTTP messages - MDN](https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Messages)

[HTTP status codes - MDN](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status)

[curl command reference](https://curl.se/docs/manpage.html)
