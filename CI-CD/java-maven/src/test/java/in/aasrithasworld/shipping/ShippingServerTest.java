package in.aasrithasworld.shipping;

import java.net.URI;
import java.net.http.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ShippingServerTest {
    private ShippingServer server;
    private final HttpClient client = HttpClient.newHttpClient();

    @BeforeEach
    void start() throws Exception {
        server = new ShippingServer(0);
        server.start();
    }

    @AfterEach
    void stop() { server.stop(); }

    private HttpResponse<String> get(String path) throws Exception {
        return client.send(HttpRequest.newBuilder(URI.create("http://localhost:" + server.port() + path))
                .GET().build(), HttpResponse.BodyHandlers.ofString());
    }

    @Test
    void servesThePage() throws Exception {
        var response = get("/");
        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("id=\"quote-form\""));
        assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("text/html"));
    }

    @Test
    void reportsHealth() throws Exception {
        assertEquals("{\"status\":\"ok\"}", get("/health").body());
    }

    @Test
    void returnsShippingAndTotal() throws Exception {
        assertEquals("{\"amount\":499,\"shipping\":50,\"total\":549}", get("/api/shipping?amount=499").body());
        assertEquals("{\"amount\":500,\"shipping\":0,\"total\":500}", get("/api/shipping?amount=500").body());
    }

    @Test
    void rejectsInvalidInput() throws Exception {
        for (String query : new String[]{"", "?amount=-1", "?amount=1.5", "?amount=abc", "?amount=2147483648", "?amount=1&amount=2"}) {
            assertEquals(400, get("/api/shipping" + query).statusCode(), query);
        }
    }

    @Test
    void returnsNotFoundForUnknownPaths() throws Exception {
        assertEquals(404, get("/missing").statusCode());
    }

    @Test
    void rejectsPostRequests() throws Exception {
        var request = HttpRequest.newBuilder(URI.create("http://localhost:" + server.port() + "/api/shipping"))
                .POST(HttpRequest.BodyPublishers.noBody()).build();
        assertEquals(405, client.send(request, HttpResponse.BodyHandlers.ofString()).statusCode());
    }
}
