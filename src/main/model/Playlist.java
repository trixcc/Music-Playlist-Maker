package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Represents a playlist having a name, size, and empty list of songs
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
    // EFFECTS: adds Song s to playlist's songList and size of playlist increases by 1
    public void addSong(Song s) {
        songList.add(s);
        size++;

    }

    // REQUIRES: playlist is not empty
    // MODIFIES: this
    // EFFECTS: If Song s is in playlist's songList, removes it and size of playlist decreases by 1.
    //          Otherwise, do nothing.
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

    // EFFECTS: returns playlist as a JSON Object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("playlist name", name);
        json.put("songs", songsToJson());
        return json;
    }

    // EFFECTS: returns songs in playlist as a JSON Array
    public JSONArray songsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Song s : songList) {
            jsonArray.put(s.getTitle());
        }

        return jsonArray;
    }

}
