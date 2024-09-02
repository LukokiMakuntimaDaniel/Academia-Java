package farmacia.co.ao.api.Controller;

import com.sun.net.httpserver.HttpExchange;
import farmacia.co.ao.api.Service.CustomerService;
import farmacia.co.ao.api.Service.MessageApi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class CustomerController {
    private final CustomerService customerService = new CustomerService();

    public void getAllCustomer(HttpExchange exchange) throws IOException {
        String response = this.customerService.getAllCustomer();
        if(response!=null){
            try {
                sendResponse(exchange,200,response);
            } catch (IOException e) {
                MessageApi.sendErrorQuery(exchange);
            }
        }else{
            MessageApi.sendMensageEmpt(exchange);
        }
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
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



}
