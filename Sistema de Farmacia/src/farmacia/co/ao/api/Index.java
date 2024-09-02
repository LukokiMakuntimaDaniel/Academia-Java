package farmacia.co.ao.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import farmacia.co.ao.api.Routes.UserRoute;
import farmacia.co.ao.api.Service.Server;

import java.io.IOException;
import java.io.OutputStream;

public class Index implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String response;
        switch (path){
            case "/api/user/":
                Server.server.createContext("/api/user",new UserRoute());
                break;
            case "/api/order/":
                response="benvido a rota do factura";
                break;
            case "/api/customer/":
                response="benvido a rota do cliente";
                break;
            case "/api/sale/":
                response="benvido a rota do venda";
                break;
            case "/api/pharmacist/":
                response="benvido a rota do farmaco";
                break;
            default:
                response ="rota invalida";
        }
    }
}
