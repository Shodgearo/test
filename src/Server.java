// Сервер

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(80);
             Socket socket = server.accept()) {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            out.println("Подключение создано..." + socket.getInetAddress());
            while (true) {
                
            }
        } catch (IOException e) {
            System.out.println("Ошибка соединения.");
        }

    }
}
