package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOptions extends JPanel implements ActionListener {
    protected JButton b1;
    protected JButton b2;
    protected JButton b3;
    private PlaylistFrame playlistFrame;
    private HomePagePanel homePagePanel;

    public ButtonOptions(HomePagePanel homePagePanel, PlaylistFrame playlistFrame) {
        this.playlistFrame = playlistFrame;
        setPlaylistFrame(playlistFrame);
        this.homePagePanel = homePagePanel;
        setHomePagePanel(homePagePanel);

        b1 = new JButton("ADD SONG");
        b1.setActionCommand("add");

        b2 = new JButton("SAVE PLAYLIST");
        b2.setActionCommand("save");

        b3 = new JButton("LOAD PLAYLIST");
        b3.setActionCommand("load");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        add(b1);
        add(b2);
        add(b3);

    }

    public PlaylistFrame getPlaylistFrame() {
        return playlistFrame;
    }

    public void setPlaylistFrame(PlaylistFrame playlistFrame) {
        if (getPlaylistFrame() != playlistFrame) {
            this.playlistFrame = playlistFrame;
            playlistFrame.setButtonOptions(this);
        }
    }

    public HomePagePanel getHomePagePanel() {
        return homePagePanel;
    }

    public void setHomePagePanel(HomePagePanel homePagePanel) {
        if (getHomePagePanel() != homePagePanel) {
            this.homePagePanel = homePagePanel;
            homePagePanel.setButtonOptions(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel playlist = new JPanel();
        playlist.setPreferredSize(new Dimension(100,100));
        playlist.setLayout(new BorderLayout());
        String command;
        if ("add".equals(e.getActionCommand())) {
            command = JOptionPane.showInputDialog("Enter title of song to add:");
            if (createNewSong(command) != null) {
                playlist.add(createNewSong(command));
                playlist.revalidate();
                playlist.repaint();
            }
        } else if ("save".equals(e.getActionCommand())) {
            command = JOptionPane.showInputDialog("Saving Playlist...");
        } else {
            command = JOptionPane.showInputDialog("Loading Playlist...");
        }

        playlistFrame.add(playlist);

    }

    public JLabel createNewSong(String songTitle) {
        JLabel song = null;
        if (songTitle != null) {
            song = new JLabel(songTitle);
        }
        return song;
    }

}
