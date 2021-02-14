package model;

import java.util.Collections;
import java.util.List;

// Represents a playlist having a name and size
public class Playlist {
    private String name;
    private int size;
    private List<Song> songList;

    // REQUIRES: playlistName has non-zero length
    // EFFECTS: constructs a playlist with given name and initial size of zero
    public Playlist(String playlistName) {
        name = playlistName;
        size = 0;
        songList = null;

    }

    // REQUIRES: newPlaylistName has non-zero length
    // MODIFIES: this
    // EFFECTS: renames the playlist
    public void namePlaylist(String newPlaylistName) {
        this.name = newPlaylistName;

    }

    // MODIFIES: this
    // EFFECTS: adds given song to playlist's songList and size of playlist increases by 1,
    //          if song is already on the playlist's songList, nothing is added
    public void addSong(Song s) {
        if (!songList.contains(s)) {
            songList.add(s);
            this.size++;

        }

    }

    // REQUIRES: playlist is not empty and song s has to already be in playlist
    // MODIFIES: this
    // EFFECTS: removes given song from playlist and size of playlist decreases by 1
    public void removeSong(Song s) {

    }

    public String getPlaylistName() {
        return null; //stub
    }

    public int getPlaylistSize() {
        return 0; //stub
    }

    public List<Song> getSongList() {
        return null; //stub
    }




}
