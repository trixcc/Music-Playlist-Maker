package model;

// Represents a song having a title
public class Song {
    private String title;

    // REQUIRES: title has a non-zero length
    // EFFECTS: constructs a song with the given title/name
    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

