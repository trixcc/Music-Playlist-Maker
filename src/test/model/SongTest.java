package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    private Song testSong;

    @BeforeEach
    public void setup() {
        testSong = new Song("Where Is The Love?");
    }

    @Test
    public void testConstructor() {
        assertEquals("Where Is The Love?", testSong.getTitle());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Where Is The Love?", testSong.getTitle());
    }

    @Test
    public void testEquals() {
        Song testSongSame = new Song("Where Is The Love?");
        assertTrue(testSongSame.equals(testSong));

        Song testSongDifferent = new Song("Mamma Mia");
        assertFalse(testSongDifferent.equals(testSong));

        String testSongString = new String("Where Is The Love?");
        assertFalse(testSongString.equals(testSong));

        assertFalse(testSong.equals(null));

        assertTrue(testSong.equals(testSong));
    }

    @Test
    public void testHashCode() {
        assertEquals(319695328, testSong.hashCode());
    }

}
