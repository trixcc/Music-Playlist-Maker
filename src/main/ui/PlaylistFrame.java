package ui;

import model.Playlist;

import javax.swing.*;
import java.awt.*;

public class PlaylistFrame extends JFrame {
    private Playlist playlist;
    private HomePagePanel homePagePanel;


    public PlaylistFrame() {
        super("Playlist Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createHomePage();

        pack();
        setVisible(true);

    }

    public void createHomePage() {
        homePagePanel = new HomePagePanel();
        add(homePagePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new PlaylistFrame();
    }

}
