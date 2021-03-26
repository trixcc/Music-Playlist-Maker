package ui;

import javax.swing.*;
import java.awt.*;

// Represents the main window of the Playlist Maker application
public class PlaylistMakerFrame extends JFrame {
    private HomePagePanel homePagePanel;
    private static final int WIDTH = 650;
    private static final int HEIGHT = 500;

    private SongListUI playlistSongList;
//    private MoreOptionsUI moreOptionsUI;
//    private JLabel numOfSongs;

    // EFFECTS: sets up the main window of the Playlist Maker application
    public PlaylistMakerFrame() {
        super("Playlist Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);

        playlistSongList = new SongListUI();
        playlistSongList.setOpaque(true);
        add(playlistSongList, BorderLayout.WEST);
//        int songCount = playlistSongList.getSongList().getModel().getSize();

        homePagePanel = new HomePagePanel(this);
        add(homePagePanel, BorderLayout.EAST);
//        numOfSongs = new JLabel("0 SONG(S)");
//        numOfSongs.setText(songCount + " SONG(S)");
//        homePagePanel.add(numOfSongs, BorderLayout.PAGE_START);

//        setMoreOptionsUI(homePagePanel.getMoreOptionsUI());

        pack();
        setVisible(true);

    }

    public SongListUI getSongListUI() {
        return playlistSongList;
    }

//    public MoreOptionsUI getMoreOptionsUI() {
//        return moreOptionsUI;
//    }
//
//    public void setMoreOptionsUI(MoreOptionsUI moreOptionsUI) {
//        if (getMoreOptionsUI() != moreOptionsUI) {
//            this.moreOptionsUI = moreOptionsUI;
//            moreOptionsUI.setPlaylistMakerFrame(this);
//        }
//    }


    // EFFECTS: starts the application
    public static void main(String[] args) {
        new PlaylistMakerFrame();
    }

}
