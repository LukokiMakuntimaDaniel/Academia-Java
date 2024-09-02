package farmacia.co.ao.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Benvindo implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "ola como vai";
        exchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
