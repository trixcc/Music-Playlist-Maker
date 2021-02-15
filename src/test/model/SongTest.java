package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    private Song testSong;

    @Test
    public void testConstructor() {
        testSong = new Song("Where Is The Love?");
        assertEquals("Where Is The Love?", testSong.getTitle());
    }

/*    @BeforeEach
    public void setup() {
        testSong = new Song("Where Is The Love?");
    }

    @Test
    public void testAddArtistName() {
        testSong.addArtistName("Black Eyed Peas");
        assertEquals("Black Eyed Peas", testSong.getArtist());

    }

    @Test
    public void testAddAlbumName() {
        testSong.addAlbumName("Elephunk");
        assertEquals("Elephunk", testSong.getAlbum());

    }

    @Test
    public void testAddSongLength() {
        testSong.addSongLength(4.33);
        assertEquals(4.33, testSong.getLength());

    }*/

}
