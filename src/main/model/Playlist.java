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

    // REQUIRES: newPlaylistName has non-zero length
    // MODIFIES: this
    // EFFECTS: renames the playlist
    public void renamePlaylist(String newPlaylistName) {
        name = newPlaylistName;

    }

    // MODIFIES: this
    // EFFECTS: adds given song to playlist's songList and size of playlist increases by 1,
    //          if song is already on the playlist's songList, nothing is added
    public void addSong(Song s) {
        if (!songList.contains(s)) {
            songList.add(s);
            size++;

        }

    }

    // REQUIRES: playlist is not empty and song s has to already be in playlist
    // MODIFIES: this
    // EFFECTS: removes given song from playlist and size of playlist decreases by 1
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
