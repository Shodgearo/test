import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server_v4 {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8189), 0);
        server.createContext("/", new SomeHandler());
        server.setExecutor(null);
        server.start();
    }


    private class Auth extends Authenticator {
        @Override
        public Result authenticate(HttpExchange httpExchange) {
            if ("/forbidden".equals(httpExchange.getRequestURI())) {
                return new Failure(403);
            } else {
                return new Success(new HttpPrincipal("c0nst", "realm"));
            }
        }
    }

    private static class SomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            StringBuilder builder = new StringBuilder();

            builder.append("<h1>URI: ").append(httpExchange.getRequestURI()).append("</h1>");

            Headers headers = httpExchange.getRequestHeaders();
            for (String header : headers.keySet()) {
                builder.append("<p>").append(header).append(" = ").append(headers.getFirst(header)).append("</p>");
            }

            httpExchange.sendResponseHeaders(200, builder.length());

            OutputStream out = httpExchange.getResponseBody();
            out.write(builder.toString().getBytes());
            out.flush();
            out.close();
        }
    }
}
