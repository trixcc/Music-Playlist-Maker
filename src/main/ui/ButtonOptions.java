package ui;

import model.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOptions extends JPanel implements ActionListener {
    protected JButton b1;
    protected JButton b2;
    protected JButton b3;
    private PlaylistFrame playlistFrame;

    public ButtonOptions() {
        setPlaylistFrame(playlistFrame);

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


    @Override
    public void actionPerformed(ActionEvent e) {
        String command;
        if ("add".equals(e.getActionCommand())) {
            command = JOptionPane.showInputDialog("Enter title of song to add:");
            playlistFrame.add(addSongToPlaylist(command));
            playlistFrame.revalidate();
            playlistFrame.repaint();
        } else if ("save".equals(e.getActionCommand())) {
            command = JOptionPane.showInputDialog("Saving Playlist...");
        } else {
            command = JOptionPane.showInputDialog("Loading Playlist...");
        }

    }

    public JPanel addSongToPlaylist(String songTitle) {
        JPanel playlist = new JPanel();
        playlist.setBackground(Color.WHITE);
        if (songTitle != null) {
            JLabel song = new JLabel(songTitle);
            playlist.add(song);
        }

        return playlist;
    }

}
