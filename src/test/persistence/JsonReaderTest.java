package persistence;

import model.Playlist;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {


    @Test
    public void testConstructor() {
        JsonReader testReader = new JsonReader("./data/testConstructorPlaylist.json");
        assertEquals("./data/testConstructorFile.txt", testReader.getSource());
    }

    @Test
    public void testReaderNoSuchFile() {
        JsonReader testReader = new JsonReader("./data/GhostFile.txt");
        try {
            Playlist p = testReader.readPlaylist();
            fail("IOException should have been thrown!");
        } catch (IOException e) {
            // success
        }
    }

    @Test
    public void testReaderEmptyPlaylist() {
        JsonReader testReader = new JsonReader("./data/testReaderEmptyPlaylist.json");
        try {
            Playlist p = testReader.readPlaylist();
            assertEquals(0, p.getPlaylistSize());
        } catch (IOException e) {
            fail("IOException should not have been thrown!");
        }
    }
}
