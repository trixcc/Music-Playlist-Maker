package persistence;

import model.Playlist;
import org.json.JSONObject;

import java.io.IOException;

// Represents a reader that reads a playlist from JSON data stored in file
// code based on JsonReader from JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs a reader that will read given source file
    public JsonReader(String source){

    }

    // EFFECTS: returns reader's source file
    public String getSource() {
        return null; //stub
    }

    // EFFECTS: reads playlist from file and returns it,
    //          throws IOException if it fails to read data stored in file
    public Playlist readPlaylist() throws IOException {

        return null; //stub
    }

    // EFFECTS: reads given source file and returns it as a String
    private String readFile(String source) throws IOException {

        return null; //stub
    }

    // EFFECTS: parses playlist from jsonObject and returns it
    private Playlist parsePlaylist(JSONObject jsonObject) {
        return null; //stub
    }



}
