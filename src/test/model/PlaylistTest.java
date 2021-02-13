package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    private Playlist testPlaylist;
    private Song songA;
    private Song songB;
    private Song songC;

    @BeforeEach
    public void setup() {
        testPlaylist = new Playlist("Happy Music");
        songA = new Song("September");
        songB = new Song("Electric Love");
        songC = new Song("I Want You Back");
    }

    @Test
    public void testRenamePlaylist() {
        assertEquals("Happy Music", testPlaylist.getPlaylistName());
        testPlaylist.renamePlaylist("Sad Music");
        assertEquals("Sad Music", testPlaylist.getPlaylistName());

    }

    @Test
    public void testAddSong() {
        testPlaylist.addSong(songA);
        assertEquals(1, testPlaylist.getPlaylistSize());

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

    }

    @Test
    public void testRemoveMultipleSongs() {

    }

    @Test
    public void testContains() {

    }




}