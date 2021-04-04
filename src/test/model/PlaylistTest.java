package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    private Playlist testPlaylist;
    private Song songA;
    private Song songB;
    private Song songC;
    private List<Song> testSongList;

    @BeforeEach
    public void setup() {
        try {
            testPlaylist = new Playlist("Happy Music");
        } catch (InvalidNameLengthException e) {
            fail("InvalidNameLengthException should not have been thrown");
        }
        songA = new Song("September");
        songB = new Song("Electric Love");
        songC = new Song("I Want You Back");
        testSongList = testPlaylist.getSongList();
    }

    @Test
    public void testConstructorExceptionExpected() {
        try {
            testPlaylist = new Playlist("");
            fail("InvalidNameLengthException should have been thrown!");
        } catch (InvalidNameLengthException e) {
            // success
        }
    }

    @Test
    public void testConstructorExceptionNotExpected() {
        try {
            testPlaylist = new Playlist("Happy Music");
            assertEquals("Happy Music", testPlaylist.getPlaylistName());
            assertEquals(0, testPlaylist.getPlaylistSize());
            assertEquals(0, testSongList.size());
        } catch (InvalidNameLengthException e) {
            fail("InvalidNameLengthException should not have been thrown");
        }
    }

    @Test
    public void testAddSong() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));

    }

    @Test
    public void testAddMultipleSongs() {
        testPlaylist.addSong(songA);
        testPlaylist.addSong(songB);
        testPlaylist.addSong(songC);
        assertEquals(3, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));
        assertTrue(testSongList.contains(songB));
        assertTrue(testSongList.contains(songC));

    }

    @Test
    public void testRemoveSongExceptionExpected() {
        try {
            testPlaylist.removeSong(songA);
            fail("EmptyPlaylistException should have been thrown!");
        } catch (EmptyPlaylistException e) {
            // success
        }
    }

    @Test
    public void testRemoveSongExceptionNotExpected() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));

        try {
            testPlaylist.removeSong(songA);
            assertEquals(0, testPlaylist.getPlaylistSize());
            assertFalse(testSongList.contains(songA));
        } catch (EmptyPlaylistException e) {
            fail("EmptyPlaylistException should not have been thrown!");
        }

    }

    @Test
    public void testRemoveMultipleSongsExceptionNotExpected() {
        testPlaylist.addSong(songA);
        testPlaylist.addSong(songB);
        testPlaylist.addSong(songC);
        assertEquals(3, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));
        assertTrue(testSongList.contains(songB));
        assertTrue(testSongList.contains(songC));

        try {
            testPlaylist.removeSong(songC);
            testPlaylist.removeSong(songA);
            assertEquals(1, testPlaylist.getPlaylistSize());
            assertFalse(testSongList.contains(songA));
            assertTrue(testSongList.contains(songB));
            assertFalse(testSongList.contains(songC));
        } catch (EmptyPlaylistException e) {
            fail("EmptyPlaylistException should not have been thrown!");
        }

    }

    @Test
    public void testRemoveSongNotInSongListExceptionNotExpected() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));
        assertFalse(testSongList.contains(songB));

        try {
            testPlaylist.removeSong(songB);
            assertEquals(1, testPlaylist.getPlaylistSize());
            assertTrue(testSongList.contains(songA));
            assertFalse(testSongList.contains(songB));
        } catch (EmptyPlaylistException e) {
            fail("EmptyPlaylistException should not have been thrown!");
        }

    }

}