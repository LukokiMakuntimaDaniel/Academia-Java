package farmacia.co.ao.api.Routes;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import farmacia.co.ao.api.Controller.CustomerController;
import farmacia.co.ao.api.Service.MessageApi;

import java.io.IOException;


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
                    MessageApi.sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/customer/save":
                if ("POST".equalsIgnoreCase(method)) {
                    handlePost(exchange);
                } else {
                    MessageApi.sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/customer/delete/":
                if ("DELETE".equalsIgnoreCase(method)) {
                    handleDelete(exchange);
                } else {
                    MessageApi.sendMethodNotAllowedResponse(exchange);
                }
                break;
            case "/api/customer/update":
                if ("PUT".equalsIgnoreCase(method)) {
                    handleUpdate(exchange);
                } else {
                    MessageApi.sendMethodNotAllowedResponse(exchange);
                }
                break;
            default:
                MessageApi.sendNotFoundResponse(exchange);
                break;
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        CustomerController customerController = new CustomerController();
        customerController.getAllCustomer(exchange);
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String response = "Saving customer data";
    }

    private void handleDelete(HttpExchange exchange) throws IOException {
        String response = "Deleting customer data";
    }

    private void handleUpdate(HttpExchange exchange) throws IOException {
        String response = "Updating customer data";
    }


}
