package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

// Represents the home page of the Playlist Maker application,
// where the status of the playlist and more options are displayed
public class HomePagePanel extends JPanel {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 400;

    private MoreOptionsUI moreOptionsUI;

//    JLabel numOfSongs;

    // EFFECTS: sets up the home page panel
    public HomePagePanel(PlaylistMakerFrame playlistMakerFrame) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.ORANGE);
        setLayout(new BorderLayout());

//        numOfSongs = new JLabel(" SONG(S)");
//        add(numOfSongs, BorderLayout.PAGE_START);

        Border moreOptionsBorder = BorderFactory.createLineBorder(Color.DARK_GRAY);
        TitledBorder title = BorderFactory.createTitledBorder(moreOptionsBorder, "MORE OPTIONS");
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitleColor(Color.DARK_GRAY);

        moreOptionsUI = new MoreOptionsUI(playlistMakerFrame);
        add(moreOptionsUI, BorderLayout.PAGE_END);
        moreOptionsUI.setBorder(title);
    }

}
