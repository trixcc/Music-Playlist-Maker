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

}
