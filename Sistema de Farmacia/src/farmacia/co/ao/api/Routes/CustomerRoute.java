package farmacia.co.ao.api.Routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class CustomerRoute implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();
        switch (path) {
            case "/api/customer/getAll":
                if ("GET".equalsIgnoreCase(method)) {
                    handleGet(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/customer/save":
                if ("POST".equalsIgnoreCase(method)) {
                    handlePost(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/customer/delete/":
                if ("DELETE".equalsIgnoreCase(method)) {
                    handleDelete(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/customer/update":
                if ("PUT".equalsIgnoreCase(method)) {
                    handleUpdate(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            default:
                sendNotFoundResponse(exchange);
                break;
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        String response = "Fetching all customer data";
        response = exchange.getRequestURI().getQuery();
        Map<String, String> params = queryToMap(response);
        response = params.get("ola");

        sendResponse(exchange, 200, response);
    }

    private Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        if (query != null) {
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    result.put(entry[0], entry[1]);
                } else {
                    result.put(entry[0], "");
                }
            }
        }
        return result;
    }



    private void handlePost(HttpExchange exchange) throws IOException {
        String response = "Saving customer data";
        sendResponse(exchange, 200, response);
    }

    private void handleDelete(HttpExchange exchange) throws IOException {
        String response = "Deleting customer data";
        sendResponse(exchange, 200, response);
    }

    private void handleUpdate(HttpExchange exchange) throws IOException {
        String response = "Updating customer data";
        sendResponse(exchange, 200, response);
    }

    private void sendNotFoundResponse(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(404, -1);
    }

    private void sendMethodNotAllowedResponse(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(405, -1);
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
