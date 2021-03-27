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
    private static final int HEIGHT = 70;

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
        setBackground(Color.BLACK);

        loadButton = new JButton("LOAD PLAYLIST");
        loadButton.setActionCommand("load");

        saveButton = new JButton("SAVE PLAYLIST");
        saveButton.setActionCommand("save");

        loadButton.addActionListener(this);
        saveButton.addActionListener(this);

        add(loadButton);
        add(saveButton);

//        createPlaylist(playlistMakerFrame);
        this.playlistMakerFrame = playlistMakerFrame;
        playlist = new Playlist("test");
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

//    public Playlist createPlaylist(PlaylistMakerFrame playlistMakerFrame) {
//        SongListUI songListUI = playlistMakerFrame.getSongListUI();
//        JList songs = songListUI.getSongList();
//        Object songObject;
//
//        playlist = new Playlist("test");
//
//        for (int i = 0; i < songs.getModel().getSize(); i++) {
//            songObject = songs.getModel().getElementAt(i);
//            Song newSong = new Song(songObject.toString());
//            playlist.addSong(newSong);
//        }
//
//        return playlist;
//
//    }

//    public PlaylistMakerFrame getPlaylistMakerFrame() {
//        return playlistMakerFrame;
//    }
//
//    public void setPlaylistMakerFrame(PlaylistMakerFrame playlistMakerFrame) {
//        if (getPlaylistMakerFrame() != playlistMakerFrame) {
//            this.playlistMakerFrame = playlistMakerFrame;
//            playlistMakerFrame.setMoreOptionsUI(this);
//        }
//    }

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
        SongListUI songListUI = playlistMakerFrame.getSongListUI();
        JList songs = songListUI.getSongList();
        Object songObject;

        //or use listModel?

        for (int i = 0; i < songs.getModel().getSize(); i++) {
            songObject = songs.getModel().getElementAt(i);
            Song newSong = new Song(songObject.toString());
            playlist.addSong(newSong);

//            if (!playlist.getSongList().contains(newSong)) {
//                playlist.addSong(newSong);
//            }
        }
    }
}
