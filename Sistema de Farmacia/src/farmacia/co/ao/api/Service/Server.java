package farmacia.co.ao.api.Service;

import com.sun.net.httpserver.HttpServer;
import farmacia.co.ao.api.Benvindo;
import farmacia.co.ao.api.Index;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    public Server() throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
        HttpServer server = HttpServer.create(inetSocketAddress, 0);

        server.createContext("/api/", new Index());

        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado na porta 8000");
    }
}
