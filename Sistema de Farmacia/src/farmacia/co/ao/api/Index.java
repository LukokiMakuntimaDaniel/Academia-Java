package farmacia.co.ao.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import farmacia.co.ao.api.Routes.*;
import farmacia.co.ao.api.Service.Server;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Index implements HttpHandler {

    private static final Map<String, HttpHandler> routes = new HashMap<>();

    static {
        routes.put("/api/user/", new UserRoute());
        routes.put("/api/order/", new OrderRoute());
        routes.put("/api/customer/", new CustomerRoute());
        routes.put("/api/sale/", new SaleRoute());
        routes.put("/api/pharmacist/", new PharmacistRoute());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        for (Map.Entry<String, HttpHandler> route : routes.entrySet()) {
            if (path.startsWith(route.getKey())){
                Server.server.createContext(route.getKey(), route.getValue());
                route.getValue().handle(exchange);
                return;
            }
        }
        exchange.sendResponseHeaders(404, -1);
    }
}
