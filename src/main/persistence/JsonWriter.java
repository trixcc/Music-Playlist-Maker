package persistence;

import model.Playlist;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes a JSON representation of a playlist to file
// code based on JsonWriter in JsonSerializationDemo
public class JsonWriter {
    private PrintWriter writer;
    private String destination;
    private static final int TAB = 3;

    // EFFECTS: constructs a writer that will write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: writes a JSON representation of playlist to file
    public void writePlaylist(Playlist playlist) {
        JSONObject jsonObject = playlist.toJson();
        saveToFile(jsonObject.toString(TAB));

    }

    // MODIFIES: this
    // EFFECTS: opens writer,
    //          throws FileNotFoundException if destination file cannot be opened for writing
    public void openWriter() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void closeWriter() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes json to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
