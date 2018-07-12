// Клиент

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("10.0.0.12", 8189)) {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in); // Для ввода с клавиатуры пользователем
            String s = "";

            while (!s.equals("exit")) {
                System.out.println(in.nextLine());

                s = scanner.nextLine();

                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
