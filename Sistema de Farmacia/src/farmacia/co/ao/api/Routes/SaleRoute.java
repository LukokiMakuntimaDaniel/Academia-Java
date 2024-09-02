package farmacia.co.ao.api.Routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class SaleRoute  implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String response;
        switch (path) {
            case "/api/sale/getAll":
                this.get(exchange);
                break;
            case "/api/sale/save":
                this.post(exchange);
                break;
            case "/api/sale/delete/":
                this.delete(exchange);
                break;
            case "/api/sale/update":
                this.update(exchange);
                break;
            default:
                exchange.sendResponseHeaders(404, -1);
                break;
        }
    }

    private void get(HttpExchange exchange) throws IOException {
        String response = "pegando todos os dados";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void post(HttpExchange exchange) throws IOException {
        String response = "inserindo todos os dados";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void delete(HttpExchange exchange) throws IOException {
        String response = "delete todos os dados";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void update(HttpExchange exchange) throws IOException {
        String response = "actualizado todos os dados";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}