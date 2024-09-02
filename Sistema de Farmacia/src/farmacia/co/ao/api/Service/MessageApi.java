package farmacia.co.ao.api.Service;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class MessageApi {

    public static void sendNotFoundResponse(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(404, -1);
    }

    public static void sendMethodNotAllowedResponse(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(405, -1);
    }

    public static void sendErrorQuery(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(500, -1);
    }
    public static void sendMensageEmpt(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(204, -1);
    }


    public static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }


}
