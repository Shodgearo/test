import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {
    private JTextField addressBar;
    private JEditorPane browserPage;

    // Конструктор
    public Test() {
        super("Мой браузер.");
        addressBar = new JTextField("Enter a address...");

        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadDate(actionEvent.getActionCommand());
            }
        });


        browserPage = new JEditorPane();
        browserPage.setEditable(false);

        browserPage.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
                if (hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    loadDate(hyperlinkEvent.getURL().toString());
                }
            }
        });

        add(addressBar, BorderLayout.NORTH);
        add(browserPage, BorderLayout.CENTER);

        setSize(1024, 800);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // Загрузка данных в окно браузера
    private void loadDate(String s) {
        try {
            browserPage.setPage(s);
            addressBar.setText(s);
        } catch (Exception e) {
            browserPage.setText("Страница недоступна... " + s);
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
