package model;

// Represents a song having a title, artist name, album name and length (in minutes)
public class Song {
    private String title;
    private String artist;
    private String album;
    private double length;

    // REQUIRES: title has a non-zero length
    // EFFECTS: constructs a song with the given title/name,
    //          the song's artist, album, and length are still unknown
    public Song(String title) {
        this.title = title;
        artist = null;
        album = null;
        length = 0;

    }

    // REQUIRES: newTitle has a non-zero length
    // MODIFIES: this
    // EFFECTS: renames the title of a song
    public void renameSong(String newTitle) {
        title = newTitle;

    }

    // REQUIRES: artistName has a non-zero length
    // MODIFIES: this
    // EFFECTS: adds the artist's name to the song
    public void addArtistName(String artistName) {
        artist = artistName;

    }

    // REQUIRES: albumName has a non-zero length
    // MODIFIES: this
    // EFFECTS: adds the song's album name
    public void addAlbumName(String albumName) {
        album = albumName;

    }

    // REQUIRES: songLength > 0
    // MODIFIES: this
    // EFFECTS: adds the length of the song (in minutes)
    public void addSongLength(double songLength) {
        length = songLength;

    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public double getLength() {
        return length;
    }

}

