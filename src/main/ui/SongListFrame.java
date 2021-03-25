package ui;

import model.Playlist;

import javax.swing.*;

public class SongListFrame extends JInternalFrame {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private Playlist playlist;

    public SongListFrame(Playlist playlist) {
        super("Your Playlist", false, false, false, false);
        this.playlist = playlist;
        setSize(WIDTH, HEIGHT);
        setLocation(50,50);
        setVisible(true);
    }
}
