import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Client_v2 {
    public static void main(String[] args) {
        String url = "http://127.0.0.1:8189";

        try {
            URLConnection connection = new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());

            System.out.println(scanner.nextLine());

//            StringBuilder str = new StringBuilder();
//
//            while (scanner.hasNext()) {
//                str.append(scanner.next());
//            }
//
//            System.out.println(str);

//            new Frame_Test(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Frame_Test extends JFrame {
    private JEditorPane editor;

    public Frame_Test(String s) {
        editor = new JEditorPane();
        editor.setEditable(false);

        editor.setText(s);

        add(editor, BorderLayout.CENTER);


        setSize(1000, 650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}