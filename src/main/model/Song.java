package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a song having a title
public class Song implements Writable {
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
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        return json;
    }
}


