package ui;

import javax.swing.*;
import java.awt.*;

public class PlaylistMakerFrame extends JFrame {
    private HomePagePanel homePagePanel;
    private static final int WIDTH = 650;
    private static final int HEIGHT = 500;
//    private JLabel numOfSongs;

    public PlaylistMakerFrame() {
        super("Playlist Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);

        SongListUI playlistSongList = new SongListUI();
        playlistSongList.setOpaque(true);
        add(playlistSongList, BorderLayout.WEST);
//        int songCount = playlistSongList.getSongList().getModel().getSize();

        homePagePanel = new HomePagePanel();
        add(homePagePanel, BorderLayout.EAST);
//        numOfSongs = new JLabel("0 SONG(S)");
//        numOfSongs.setText(songCount + " SONG(S)");
//        homePagePanel.add(numOfSongs, BorderLayout.PAGE_START);

        pack();
        setVisible(true);

    }



    public static void main(String[] args) {
        new PlaylistMakerFrame();
    }

}
