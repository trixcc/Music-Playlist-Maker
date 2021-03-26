package ui;

import javax.swing.*;
import java.awt.*;

public class HomePagePanel extends JPanel {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 500;

//    JLabel numOfSongs;

    public HomePagePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

//        numOfSongs = new JLabel(" SONG(S)");
//        add(numOfSongs, BorderLayout.PAGE_START);

        add(new MoreOptionsUI(), BorderLayout.PAGE_END);
    }
}
