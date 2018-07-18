import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_v2_1 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189);
             Socket socket = server.accept()) {
            OutputStream out = socket.getOutputStream();
            File file = new File("/home/meritokrat/Рабочий стол/2.html");

            Scanner scan = new Scanner(new FileInputStream(file));
            StringBuilder stringBuilder = new StringBuilder();
            while (scan.hasNext()) {
                stringBuilder.append(scan.next());
            }

            String s = stringBuilder.toString();
//            String s = "<html><body><h1>Hello</h1></body></html>";
//            System.out.println(s);
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            out.write(result.getBytes());
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
