package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a panel with options to save and load a playlist
// code based on ButtonDemo.java on Oracle
public class MoreOptionsUI extends JPanel implements ActionListener {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 70;

    protected JButton loadButton;
    protected JButton saveButton;

    // EFFECTS: sets up the options panel,
    //          displays save and load buttons
    public MoreOptionsUI() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        loadButton = new JButton("LOAD PLAYLIST");
        loadButton.setActionCommand("load");

        saveButton = new JButton("SAVE PLAYLIST");
        saveButton.setActionCommand("save");

        loadButton.addActionListener(this);
        saveButton.addActionListener(this);

        add(loadButton);
        add(saveButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            loadPlaylist();
        } else {
            savePlaylist();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads playlist from file
    public void loadPlaylist() {

    }

    // MODIFIES: this
    // EFFECTS: saves playlist to file
    public void savePlaylist() {

    }
}
