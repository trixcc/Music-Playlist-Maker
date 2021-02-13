package model;

// Represents a song having a title, artist name, album name and length (in minutes)
public class Song {
    private String title;
    private String artist;
    private String album;
    private float length;

    // REQUIRES: title has a non-zero length
    // EFFECTS: constructs a song with the given title/name
    public Song(String title) {

    }

    // REQUIRES: newTitle has a non-zero length
    // MODIFIES: this
    // EFFECTS: renames the title of a song
    public void renameSong(String newTitle) {

    }

    // REQUIRES: artistName has a non-zero length
    // MODIFIES: this
    // EFFECTS: adds the artist's name to the song
    public void addArtistName(String artistName) {

    }

    // REQUIRES: albumName has a non-zero length
    // MODIFIES: this
    // EFFECTS: adds the song's album name
    public void addAlbumName(String albumName) {

    }

    // REQUIRES: songLength > 0
    // MODIFIES: this
    // EFFECTS: adds the length of the song (in minutes)
    public void addSongLength(double songLength) {

    }

    public String getTitle() {

        return null;
    }

    public String getArtist() {

        return null;
    }

    public String getAlbum() {

        return null;
    }

    public float getLength() {

        return 0;
    }

}

