package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return Objects.equals(title, song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

