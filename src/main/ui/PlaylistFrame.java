package ui;

import javax.swing.*;
import java.awt.*;

public class PlaylistFrame extends JFrame {
    private HomePagePanel homePagePanel;
    private ButtonOptions buttonOptions;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;


    public PlaylistFrame() {
        super("Playlist Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);

        homePagePanel = new HomePagePanel();
        add(homePagePanel, BorderLayout.EAST);

        JComponent playlistSongList = new SongListUI();
        playlistSongList.setOpaque(true);
        add(playlistSongList, BorderLayout.WEST);
//
//        ButtonOptions buttonOptions = new ButtonOptions(homePagePanel, this);
//        buttonOptions.setOpaque(true);
//
//        Container pane = getContentPane();
//        pane.add(buttonOptions, BorderLayout.PAGE_END);
//        setButtonOptions(buttonOptions);

        pack();
        setVisible(true);

    }

    public ButtonOptions getButtonOptions() {
        return buttonOptions;
    }

    public void setButtonOptions(ButtonOptions buttonOptions) {
        if (getButtonOptions() != buttonOptions) {
            this.buttonOptions = buttonOptions;
            buttonOptions.setPlaylistFrame(this);
        }
    }




    public static void main(String[] args) {
        new PlaylistFrame();
    }

}
