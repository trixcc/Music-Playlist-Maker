package persistence;

import model.Playlist;
import model.Song;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

// code based on JsonWriterTest in JsonSerializationDemo
public class JsonWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            Playlist playlist = new Playlist("My Playlist");
            JsonWriter testWriter = new JsonWriter("./data/Invalid\0file.json");
            testWriter.openWriter();
            fail("IOException should have been thrown!");
        } catch (IOException e) {
            // success
        }
    }

    @Test
    public void testWriterEmptyPlaylist() {
        try {
            Playlist playlist = new Playlist("My Playlist");
            JsonWriter testWriter = new JsonWriter("./data/testWriterEmptyPlaylist.json");
            testWriter.openWriter();
            testWriter.writePlaylist(playlist);
            testWriter.closeWriter();

            JsonReader testReader = new JsonReader("./data/testWriterEmptyPlaylist.json");
            playlist = testReader.readPlaylist();
            assertEquals("My Playlist", playlist.getPlaylistName());
            assertEquals(0, playlist.getPlaylistSize());

        } catch (IOException e) {
            fail("IOException should not have been thrown!");
        }
    }

    @Test
    public void testWriterGeneralPlaylist() {
        try {
            Playlist playlist = new Playlist("My Playlist");
            playlist.addSong(new Song("Yellow"));
            playlist.addSong(new Song("LOVE AGAIN"));
            playlist.addSong(new Song("foo"));
            JsonWriter testWriter = new JsonWriter("./data/testWriterGeneralPlaylist.json");
            testWriter.openWriter();
            testWriter.writePlaylist(playlist);
            testWriter.closeWriter();

            JsonReader testReader = new JsonReader("./data/testWriterGeneralPlaylist.json");
            playlist = testReader.readPlaylist();
            assertEquals("My Playlist", playlist.getPlaylistName());
            assertEquals(3, playlist.getPlaylistSize());
            List<Song> songs = playlist.getSongList();
            assertEquals("Yellow", songs.get(0).getTitle());
            assertEquals("LOVE AGAIN", songs.get(1).getTitle());
            assertEquals("foo", songs.get(2).getTitle());

        } catch (IOException e) {
            fail("IOException should not have been thrown!");
        }
    }
}
