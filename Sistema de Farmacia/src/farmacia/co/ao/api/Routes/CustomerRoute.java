package farmacia.co.ao.api.Routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import farmacia.co.ao.Model.Customer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class CustomerRoute implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        switch (path){
            case "/api/customer/getAll":
                this.get(exchange);
                break;
            case "/api/customer/save":
                this.post(exchange);
                break;
            case "/api/customer/delete/":
                this.delete(exchange);
                break;
            case "/api/customer/update":
                this.update(exchange);
                break;
            default:
                exchange.sendResponseHeaders(404,-1);
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
