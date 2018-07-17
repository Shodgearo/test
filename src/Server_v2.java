import com.sun.net.httpserver.HttpsServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server_v2 {
    public static void main(String[] args) {
        try {
            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress("localhost", 8189), 0);

            while (true) {
                System.out.println("Hi");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
