package in.aasrithasworld.shipping;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ShippingServer {
    private final HttpServer server;
    private final ShippingCalculator calculator = new ShippingCalculator();

    public ShippingServer(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", this::handle);
    }

    public void start() { server.start(); }
    public void stop() { server.stop(0); }
    public int port() { return server.getAddress().getPort(); }

    private void handle(HttpExchange exchange) throws IOException {
        try (exchange) {
            if (!exchange.getRequestMethod().equals("GET")) {
                exchange.getResponseHeaders().set("Allow", "GET");
                send(exchange, 405, "application/json", "{\"error\":\"Use GET.\"}");
                return;
            }
            switch (exchange.getRequestURI().getPath()) {
                case "/" -> {
                    try (var page = getClass().getResourceAsStream("/web/index.html")) {
                        if (page == null) throw new IOException("Webpage is missing from the JAR.");
                        send(exchange, 200, "text/html", new String(page.readAllBytes(), StandardCharsets.UTF_8));
                    }
                }
                case "/health" -> send(exchange, 200, "application/json", "{\"status\":\"ok\"}");
                case "/api/shipping" -> quote(exchange);
                default -> send(exchange, 404, "application/json", "{\"error\":\"Not found.\"}");
            }
        }
    }

    private void quote(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getRawQuery();
        if (query == null || !query.matches("amount=[0-9]{1,10}")) {
            send(exchange, 400, "application/json", "{\"error\":\"Enter a whole number from 0 to 2147483647.\"}");
            return;
        }
        try {
            int amount = Integer.parseInt(query.substring(7));
            int shipping = calculator.shippingCharge(amount);
            long total = (long) amount + shipping;
            send(exchange, 200, "application/json",
                    "{\"amount\":" + amount + ",\"shipping\":" + shipping + ",\"total\":" + total + "}");
        } catch (IllegalArgumentException exception) {
            send(exchange, 400, "application/json", "{\"error\":\"Amount is too large. Use 2147483647 or less.\"}");
        }
    }

    private void send(HttpExchange exchange, int status, String type, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", type + "; charset=utf-8");
        exchange.getResponseHeaders().set("Cache-Control", "no-store");
        exchange.getResponseHeaders().set("X-Content-Type-Options", "nosniff");
        exchange.sendResponseHeaders(status, bytes.length);
        exchange.getResponseBody().write(bytes);
    }
}
