// Сервер

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189);
             Socket socket = server.accept()) {

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Подключение создано..." + socket.getInetAddress());

            while (true) {
                Thread.sleep(1000);

                System.out.println("Horowo sliwno?.");
                out.println("Yes, normalno.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Ошибка при выполнении потока.");
        }
    }
}
