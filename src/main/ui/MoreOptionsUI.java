package ui;

import model.Playlist;
import model.Song;
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

    private static final String JSON_FILE = "./data/MyPlaylist.json";

    private Playlist playlist;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: sets up the options panel,
    //          displays save and load buttons
    public MoreOptionsUI(PlaylistMakerFrame playlistMakerFrame) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            loadPlaylist();
        } else {
            savePlaylist();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads playlist from file
    public void loadPlaylist() {
        SongListUI songListUI = playlistMakerFrame.getSongListUI();

        try {
            playlist = jsonReader.readPlaylist();
            List<Song> songs = playlist.getSongList();

            for (Song s : songs) {
                String songTitle = s.getTitle();
                songListUI.getListModel().addElement(songTitle);
            }

            System.out.println(playlist.getPlaylistName() + " loaded from " + JSON_FILE);

        } catch (IOException e) {
            System.out.println("Unable to load playlist from " + JSON_FILE);
        }

    }

    // MODIFIES: this
    // EFFECTS: saves playlist to file
    public void savePlaylist() {
        createPlaylist();

        try {
            jsonWriter.openWriter();
            jsonWriter.writePlaylist(playlist);
            jsonWriter.closeWriter();
            System.out.println(playlist.getPlaylistName() + " saved to " + JSON_FILE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save playlist to " + JSON_FILE);
        }

    }

    public void createPlaylist() {
        playlist = new Playlist("test");
        SongListUI songListUI = playlistMakerFrame.getSongListUI();
        JList songs = songListUI.getSongList();
        Object songObject;

        for (int i = 0; i < songs.getModel().getSize(); i++) {
            songObject = songs.getModel().getElementAt(i);
            Song newSong = new Song(songObject.toString());
            playlist.addSong(newSong);
        }

    }
}
