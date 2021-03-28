package ui;

import javax.swing.*;
import java.awt.*;

// Represents the main window of the Playlist Maker application
public class PlaylistMakerFrame extends JFrame {
    private HomePagePanel homePagePanel;
    private static final int WIDTH = 650;
    private static final int HEIGHT = 350;

    private SongListUI playlistSongList;

    // EFFECTS: sets up the main window of the Playlist Maker application,
    //          displays list of songs and the home page panel
    public PlaylistMakerFrame() {
        super("Playlist Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);

        playlistSongList = new SongListUI();
        playlistSongList.setOpaque(true);
        add(playlistSongList, BorderLayout.WEST);

        homePagePanel = new HomePagePanel(this);
        add(homePagePanel, BorderLayout.EAST);

        pack();
        setVisible(true);

    }

    public SongListUI getSongListUI() {
        return playlistSongList;
    }


    // EFFECTS: starts the application
    public static void main(String[] args) {
        new PlaylistMakerFrame();
    }

}
