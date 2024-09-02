package farmacia.co.ao.api.Routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class OrderRoute implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();

        switch (path) {
            case "/api/order/getAll":
                if ("GET".equalsIgnoreCase(method)) {
                    handleGet(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/order/save":
                if ("POST".equalsIgnoreCase(method)) {
                    handlePost(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/order/delete/":
                if ("DELETE".equalsIgnoreCase(method)) {
                    handleDelete(exchange);
                } else {
                    sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/order/update":
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
        String response = "Fetching all order data";
        sendResponse(exchange, 200, response);
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String response = "Saving order data";
        sendResponse(exchange, 200, response);
    }

    private void handleDelete(HttpExchange exchange) throws IOException {
        String response = "Deleting order data";
        sendResponse(exchange, 200, response);
    }

    private void handleUpdate(HttpExchange exchange) throws IOException {
        String response = "Updating order data";
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
