package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePagePanel extends JPanel implements ActionListener {
    private static final int MAIN_PANEL_WIDTH = 500;
    private static final int MAIN_PANEL_HEIGHT = 500;
    private static final int OPTIONS_WIDTH = 120;
    private static final int OPTIONS_HEIGHT = 300;
    private int songCount;
    private JLabel numOfSongs;


    public HomePagePanel() {
        setPreferredSize(new Dimension(MAIN_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel options = new JPanel();
        options.setPreferredSize(new Dimension(OPTIONS_WIDTH, OPTIONS_HEIGHT));
        options.setBackground(Color.LIGHT_GRAY);
        options.add(createButtons());

        this.add(options, BorderLayout.EAST);

        numOfSongs = new JLabel("0 song(s)");
        this.add(numOfSongs, BorderLayout.NORTH);




    }

    public JButton createButtons() {
        return createAddSongButton();
    }

    public JButton createAddSongButton() {
        JButton addSong = new JButton("ADD SONG");
        addSong.addActionListener(this);
        return addSong;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        songCount++;
        numOfSongs.setText(songCount + " song(s)");
    }
}
