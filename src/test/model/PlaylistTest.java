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
        testPlaylist = new Playlist("Happy Music");
        songA = new Song("September");
        songB = new Song("Electric Love");
        songC = new Song("I Want You Back");
        testSongList = testPlaylist.getSongList();
    }

    @Test
    public void testConstructor() {
        assertEquals("Happy Music", testPlaylist.getPlaylistName());
        assertEquals(0, testPlaylist.getPlaylistSize());
        assertEquals(0, testSongList.size());

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
    public void testRemoveSong() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));

        testPlaylist.removeSong(songA);
        assertEquals(0, testPlaylist.getPlaylistSize());
        assertFalse(testSongList.contains(songA));

    }

    @Test
    public void testRemoveMultipleSongs() {
        testPlaylist.addSong(songA);
        testPlaylist.addSong(songB);
        testPlaylist.addSong(songC);
        assertEquals(3, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));
        assertTrue(testSongList.contains(songB));
        assertTrue(testSongList.contains(songC));

        testPlaylist.removeSong(songC);
        testPlaylist.removeSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertFalse(testSongList.contains(songA));
        assertTrue(testSongList.contains(songB));
        assertFalse(testSongList.contains(songC));

    }

    @Test
    public void testRemoveSongNotInSongList() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));
        assertFalse(testSongList.contains(songB));
        testPlaylist.removeSong(songB);
        assertEquals(1, testPlaylist.getPlaylistSize());
        assertTrue(testSongList.contains(songA));
        assertFalse(testSongList.contains(songB));

    }

}