package ui;

import javax.swing.*;
import java.awt.*;

// Represents the home page of the Playlist Maker application,
// where the status of the playlist and more options are displayed
public class HomePagePanel extends JPanel {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 500;

    private MoreOptionsUI moreOptionsUI;

//    JLabel numOfSongs;

    // EFFECTS: sets up the home page panel
    public HomePagePanel(PlaylistMakerFrame playlistMakerFrame) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

//        numOfSongs = new JLabel(" SONG(S)");
//        add(numOfSongs, BorderLayout.PAGE_START);

        moreOptionsUI = new MoreOptionsUI(playlistMakerFrame);
        add(moreOptionsUI, BorderLayout.PAGE_END);
    }

//    public MoreOptionsUI getMoreOptionsUI() {
//        return moreOptionsUI;
//    }
}
