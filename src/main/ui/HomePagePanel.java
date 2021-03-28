package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

// Represents the home page panel of the Playlist Maker application
// where the status of the playlist and more options are displayed
public class HomePagePanel extends JPanel {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 350;

    private MoreOptionsUI moreOptionsUI;

    // EFFECTS: sets up the home page panel with a more options panel
    public HomePagePanel(PlaylistMakerFrame playlistMakerFrame) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.ORANGE);
        setLayout(new BorderLayout());

        moreOptionsUI = new MoreOptionsUI(playlistMakerFrame);
        add(moreOptionsUI, BorderLayout.PAGE_END);

        Border moreOptionsBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder title = BorderFactory.createTitledBorder(moreOptionsBorder, "MORE OPTIONS");
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitleColor(Color.BLACK);
        moreOptionsUI.setBorder(title);
    }

}
