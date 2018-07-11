import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Client_v2 {
    public static void main(String[] args) {
        String url = "https://www.youtube.com";

        try {
            URLConnection connection = new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
