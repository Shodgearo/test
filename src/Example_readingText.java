import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example_readingText {
    public static void main(String[] args) {
        File file = new File("/home/meritokrat/Рабочий стол/1.html");

        try {
            Scanner scan = new Scanner(new FileInputStream(file));

            while (scan.hasNextLine()) {
                System.out.println(scan.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
