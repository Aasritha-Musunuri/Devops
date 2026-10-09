# Client and server

## What is a client?

A client is a program that asks another program for something. A web browser is a familiar example.

## What is a server?

A server is a program that receives requests and provides a service. The word can also refer to the machine hosting that program.

Client and server describe roles. They do not have to run on different computers.

## Example: opening a website

```text
Browser asks for a page -> web server handles the request
Browser displays the page <- web server sends a response
```

The browser is the client. The web server provides the requested content.

## Where does this appear in DevOps?

The same pattern appears in deployments and application systems:

- A deployment tool sends requests to a cloud API.
- Docker downloads an image from a registry.
- An application connects to a database server.
- A monitoring system requests information from an application.

A program can be a server in one interaction and a client in another. A web application receives browser requests but acts as a client when it queries a database.

## Example: a website will not open

Start with a few useful questions:

- Does the hostname resolve to the expected IP address?
- Can the client reach the server's listening port?
- Is the application running?
- Is a firewall or proxy blocking the connection?

These checks help locate the problem instead of immediately restarting the server.

## A simple way to see it

Open a website in a browser. Open developer tools with `F12`, select **Network**, and reload the page. The browser's requests and the server's responses appear there.

## What to remember

The client initiates the interaction. The server handles the request. Identify both roles before troubleshooting a connection.

## Reference

[HTTP overview - MDN](https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Overview)
