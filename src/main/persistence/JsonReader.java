package persistence;

import model.Playlist;
import model.Song;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads a playlist from JSON data stored in file
// code based on JsonReader from JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs a reader that will read given source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads playlist from file and returns it,
    //          throws IOException if it fails to read data stored in file
    public Playlist readPlaylist() throws IOException {
        String data = readFile(source);
        JSONObject jsonObject = new JSONObject(data);
        return parsePlaylist(jsonObject);
    }

    // EFFECTS: reads given source file and returns it as a String
    // code copied from readFile in JsonSerializationDemo
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses playlist from jsonObject and returns it
    private Playlist parsePlaylist(JSONObject jsonObject) {
        String playlistName = jsonObject.getString("playlist name");
        Playlist playlist = new Playlist(playlistName);
        addSongs(playlist, jsonObject);
        return playlist;

    }

    // MODIFIES: playlist
    // EFFECTS: parses songs from jsonObject and adds them to playlist
    private void addSongs(Playlist playlist, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("songs");
        for (Object nextSong : jsonArray) {
            addSong(playlist, nextSong);
        }
    }

    // MODIFIES: playlist
    // EFFECTS: parses song from jsonObject and adds it to playlist
    private void addSong(Playlist playlist, Object nextSong) {
        String title = nextSong.toString();
        Song song = new Song(title);
        playlist.addSong(song);
    }



}
