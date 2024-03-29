package ui;

import model.InvalidNameLengthException;
import model.Playlist;
import model.Song;
import model.SongAlreadyExistsException;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

// Represents a panel with options to save and load a playlist
// code based on ButtonDemo.java on Oracle
public class MoreOptionsUI extends JPanel implements ActionListener {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    protected JButton loadButton;
    protected JButton saveButton;

    private PlaylistMakerFrame playlistMakerFrame;
    private Playlist playlist;

    private static final String JSON_FILE = "./data/MyPlaylist.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: sets up the options panel with save and load buttons
    public MoreOptionsUI(PlaylistMakerFrame playlistMakerFrame) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.DARK_GRAY);

        loadButton = new JButton("Load Playlist");
        loadButton.setActionCommand("load");

        saveButton = new JButton("Save Playlist");
        saveButton.setActionCommand("save");

        loadButton.addActionListener(this);
        saveButton.addActionListener(this);

        add(loadButton);
        add(saveButton);

        this.playlistMakerFrame = playlistMakerFrame;
        jsonWriter = new JsonWriter(JSON_FILE);
        jsonReader = new JsonReader(JSON_FILE);

    }

    // EFFECTS: processes user interaction
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            loadPlaylist();
        } else {
            savePlaylist();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads playlist from file and displays the list of songs on the songListUI
    public void loadPlaylist() {
        SongListUI songListUI = playlistMakerFrame.getSongListUI();
        songListUI.getListModel().removeAllElements();

        try {
            playlist = jsonReader.readPlaylist();
            List<Song> songs = playlist.getSongList();

            for (Song s : songs) {
                String songTitle = s.getTitle();
                songListUI.getListModel().addElement(songTitle);
            }

            JOptionPane.showMessageDialog(playlistMakerFrame, "Playlist loaded from " + JSON_FILE,
                    "Load Playlist Status", JOptionPane.PLAIN_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(playlistMakerFrame, "Failed to load from " + JSON_FILE,
                    "Load Playlist Status", JOptionPane.PLAIN_MESSAGE);
        }

    }

    // EFFECTS: saves playlist to file
    public void savePlaylist() {
        uiToPlaylist();

        try {
            jsonWriter.openWriter();
            jsonWriter.writePlaylist(playlist);
            jsonWriter.closeWriter();

            JOptionPane.showMessageDialog(playlistMakerFrame, "Playlist saved to " + JSON_FILE,
                    "Save Playlist Status", JOptionPane.PLAIN_MESSAGE);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(playlistMakerFrame, "Failed to save to " + JSON_FILE,
                    "Save Playlist Status", JOptionPane.PLAIN_MESSAGE);
        }

    }

    // EFFECTS: pulls songs from songListUI into a new playlist to save to file
    public void uiToPlaylist() {
        try {
            playlist = new Playlist("Your Playlist");
        } catch (InvalidNameLengthException e) {
            System.out.println("Playlist name cannot be zero length.");
        }
        SongListUI songListUI = playlistMakerFrame.getSongListUI();
        JList songs = songListUI.getSongList();
        Object songObject;

        for (int i = 0; i < songs.getModel().getSize(); i++) {
            songObject = songs.getModel().getElementAt(i);
            Song newSong = new Song(songObject.toString());
            try {
                playlist.addSong(newSong);
            } catch (SongAlreadyExistsException e) {
                System.out.println("Attempted to add a song that is already in playlist.");
            }
        }
    }

}
