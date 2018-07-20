// http-сервер, теперь уже точно.

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server_V3 {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8189), 0);
            server.createContext("/", new MyHandler());
            server.setExecutor(null); // default executor
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "<html><body><h1>Hello</h1></body></html>";

            httpExchange.sendResponseHeaders(200, response.length());

            OutputStream out = httpExchange.getResponseBody();
            out.write(response.getBytes());
            out.close();
        }
    }
}
