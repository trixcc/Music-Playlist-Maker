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

    public String getPlaylistName() {
        return null; //stub
    }

    public int getPlaylistSize() {
        return 0; //stub
    }

    // MODIFIES: this
    // EFFECTS: adds given song to playlist and size of playlist increases by 1
    public void addSong(Song s) {

    }

    // REQUIRES: playlist is not empty and song s has to already be in playlist
    // MODIFIES: this
    // EFFECTS: removes given song from playlist and size of playlist decreases by 1
    public void removeSong(Song s) {

    }

    // REQUIRES: newPlaylistName has non-zero length
    // MODIFIES: this
    // EFFECTS: renames the playlist
    public void renamePlaylist(String newPlaylistName) {

    }




}
