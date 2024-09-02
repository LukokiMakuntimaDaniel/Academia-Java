package farmacia.co.ao.api.Controller;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import farmacia.co.ao.api.Model.Customer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerController {

    public List<Customer> getallCustomer(HttpExchange exchange) {

        return null;
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
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
