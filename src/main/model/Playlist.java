package model;

// Represents a playlist having a name and size
public class Playlist {
    private String name;
    private int size;

    // REQUIRES: playlistName has non-zero length
    // EFFECTS: constructs a playlist with given name and initial size of zero
    public Playlist(String playlistName) {
        //stub
    }

    // REQUIRES: newPlaylistName has non-zero length
    // MODIFIES: this
    // EFFECTS: renames the playlist
    public void renamePlaylist(String newPlaylistName) {

    }

    // MODIFIES: this
    // EFFECTS: adds given song to playlist and size of playlist increases by 1,
    //          if given song is already in playlist, it will not be added again
    public void addSong(Song s) {

    }

    // REQUIRES: playlist is not empty and song s has to already be in playlist
    // MODIFIES: this
    // EFFECTS: removes given song from playlist and size of playlist decreases by 1
    public void removeSong(Song s) {

    }

    // EFFECTS: returns true if a playlist contains the given song, returns false otherwise
    public boolean contains(Song s) {
        return false; //stub
    }

    public String getPlaylistName() {
        return null; //stub
    }

    public int getPlaylistSize() {
        return 0; //stub
    }




}
