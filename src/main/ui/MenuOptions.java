package ui;

import model.InvalidNameLengthException;
import model.Playlist;
import model.Song;
import model.SongAlreadyExistsException;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MenuOptions extends JPanel implements ActionListener {

    private PlaylistMakerFrame playlistMakerFrame;
    private Playlist playlist;

    private static final String JSON_FILE = "./data/MyPlaylist.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public JMenuBar createMenuBar(PlaylistMakerFrame playlistMakerFrame) {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem saveItem;
        JMenuItem loadItem;

        menuBar = new JMenuBar();

        menu = new JMenu("More Options");
        menuBar.add(menu);

        saveItem = new JMenuItem("Save Playlist");
        saveItem.setActionCommand("save");
        menu.add(saveItem);

        loadItem = new JMenuItem("Load Playlist");
        loadItem.setActionCommand("load");
        menu.add(loadItem);

        saveItem.addActionListener(this);
        loadItem.addActionListener(this);

        this.playlistMakerFrame = playlistMakerFrame;
        jsonWriter = new JsonWriter(JSON_FILE);
        jsonReader = new JsonReader(JSON_FILE);

        return menuBar;
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
