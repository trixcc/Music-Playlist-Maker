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
    public void testNamePlaylist() {
        assertEquals("Happy Music", testPlaylist.getPlaylistName());
        testPlaylist.namePlaylist("Sad Music");
        assertEquals("Sad Music", testPlaylist.getPlaylistName());

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

    }

    @Test
    public void testAddSongAlreadyInPlaylist() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        testPlaylist.addSong(songB);
        assertEquals(2, testPlaylist.getPlaylistSize());
        testPlaylist.addSong(songA);
        assertEquals(2, testPlaylist.getPlaylistSize());

    }

    @Test
    public void testRemoveSong() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());
        testPlaylist.removeSong(songA);
        assertEquals(0, testPlaylist.getPlaylistSize());

    }

    @Test
    public void testRemoveMultipleSongs() {
        testPlaylist.addSong(songA);
        testPlaylist.addSong(songB);
        testPlaylist.addSong(songC);
        assertEquals(3, testPlaylist.getPlaylistSize());
        testPlaylist.removeSong(songC);
        testPlaylist.removeSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());

    }




}