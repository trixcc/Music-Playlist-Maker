package ui;

import javax.swing.*;
import java.awt.*;

public class PlaylistFrame extends JFrame {
    private HomePagePanel homePagePanel;
    private ButtonOptions buttonOptions;


    public PlaylistFrame() {
        super("Playlist Maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        homePagePanel = new HomePagePanel();
        setContentPane(homePagePanel);

        ButtonOptions buttonOptions = new ButtonOptions();
        buttonOptions.setOpaque(true);

        Container pane = getContentPane();
        pane.add(buttonOptions, BorderLayout.PAGE_END);
        setButtonOptions(buttonOptions);

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
