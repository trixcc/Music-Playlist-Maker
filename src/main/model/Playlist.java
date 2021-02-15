package model;

import java.util.ArrayList;
import java.util.List;

// Represents a playlist having a name and size
public class Playlist {
    private String name;
    private int size;
    private List<Song> songList;

    // REQUIRES: playlistName has non-zero length
    // EFFECTS: constructs a playlist with given name, initial size of zero, and an empty song list
    public Playlist(String playlistName) {
        name = playlistName;
        size = 0;
        songList = new ArrayList<>();

    }

    // MODIFIES: this
    // EFFECTS: adds Song s to playlist's songList and size of playlist increases by 1,
    //          if Song s is already on the playlist's songList, it will not be added again
    public void addSong(Song s) {
        if (!songList.contains(s)) {
            songList.add(s);
            size++;

        }

    }

    // REQUIRES: playlist is not empty and Song s has to already be in playlist's songList
    // MODIFIES: this
    // EFFECTS: removes Song s from playlist's songList and size of playlist decreases by 1
    public void removeSong(Song s) {
        if (songList.contains(s)) {
            songList.remove(s);
            size--;
        }

    }

    public String getPlaylistName() {
        return name;
    }

    public int getPlaylistSize() {
        return size;
    }

    public List<Song> getSongList() {
        return songList;
    }

}
