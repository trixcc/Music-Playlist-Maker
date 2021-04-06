package persistence;

import model.Playlist;
import model.Song;

import model.SongAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.io.IOException;

// code based on JsonReaderTest in JsonSerializationDemo
public class JsonReaderTest {


    @Test
    public void testReaderNoSuchFile() {
        JsonReader testReader = new JsonReader("./data/GhostFile.txt");
        try {
            Playlist playlist = testReader.readPlaylist();
            fail("IOException should have been thrown!");
        } catch (IOException e) {
            // success
        }
    }

    @Test
    public void testReaderEmptyPlaylist() {
        JsonReader testReader = new JsonReader("./data/testReaderEmptyPlaylist.json");
        try {
            Playlist playlist = testReader.readPlaylist();
            assertEquals("My Playlist", playlist.getPlaylistName());
            assertEquals(0, playlist.getPlaylistSize());
        } catch (IOException e) {
            fail("IOException should not have been thrown!");
        }
    }

    @Test
    public void testReaderGeneralPlaylist() {
        JsonReader testReader = new JsonReader("./data/testReaderGeneralPlaylist.json");
        try {
            Playlist playlist = testReader.readPlaylist();
            assertEquals("My Playlist", playlist.getPlaylistName());
            assertEquals(3, playlist.getPlaylistSize());
            List<Song> songs = playlist.getSongList();
            assertEquals("Yellow", songs.get(0).getTitle());
            assertEquals("LOVE AGAIN", songs.get(1).getTitle());
            assertEquals("foo", songs.get(2).getTitle());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    public void testReaderNoNamePlaylist() {
        JsonReader testReader = new JsonReader("./data/testReaderNoNamePlaylist.json");
        try {
            Playlist playlist = testReader.readPlaylist();
        } catch (IOException e) {
            fail("IOException should not have been thrown!");
        }
    }

    @Test
    public void testReaderDoubleSongPlaylist() {
        JsonReader testReader = new JsonReader("./data/testReaderDoubleSongPlaylist.json");
        try {
            Playlist playlist = testReader.readPlaylist();
        } catch (IOException e) {
            fail("IOException should not have been thrown!");
        }
    }

}
