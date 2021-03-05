package ui;

import com.sun.xml.internal.bind.v2.TODO;
import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// A Music Playlist Maker application
public class PlaylistApp {
    private Playlist playlist;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_FILE = "./data/MyPlaylist.json";

    // EFFECTS: runs the playlist application
    public PlaylistApp() {
        jsonWriter = new JsonWriter(JSON_FILE);
        jsonReader = new JsonReader(JSON_FILE);
        runPlaylist();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // runPlaylist based on runTeller from Teller application
    private void runPlaylist() {
        boolean runOn = true;
        String command;
        input = new Scanner(System.in);

        while (runOn) {
            startMenu();
            command = input.next();

            if (command.equals("2")) {
                runOn = false;
                System.out.println("\nSee you later!");
            } else if (command.equals("1")) {
                runOn = false;
                beginPlaylistMaking();
            } else {
                System.out.println("\nSelection not valid.");
            }
        }
    }


    // EFFECTS: displays the starting menu to the user
    private void startMenu() {
        System.out.println("\nHello! Would you like to make a new playlist?\n");
        System.out.println("Enter 1 for YES");
        System.out.println("Enter 2 for NO\n");

    }

    // MODIFIES: this
    // EFFECTS: prompts user to name their new playlist
    private void beginPlaylistMaking() {
        boolean runOn = true;
        String command;

        System.out.println("\nWhat would you like to name your new playlist?");

        while (runOn) {
            command = input.nextLine();

            if (command.length() > 0) {
                runOn = false;
                homePage(command);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: displays a homepage of the playlist application and processes user input
    private void homePage(String playlistName) {
        boolean runOn = true;
        String command;
        playlist = new Playlist(playlistName);

        while (runOn) {
            homePageOptions(playlistName);
            command = input.next();

            if (command.equals("6")) {
                runOn = false;
            } else if (command.equals("1")) {
                titleOption();
            } else if (command.equals("2")) {
                removeOption(playlistName);
            } else if (command.equals("3")) {
                displayPlaylist(playlistName);
            } else if (command.equals("4")) {
                savePlaylist();
            } else if (command.equals("5")) {
                loadPlaylist();
            } else {
                System.out.println("Selection not valid.");
            }
        }

        System.out.println("\nSee you later!");

    }

    // EFFECTS: displays the user's playlist
    // for loop code block based on code from stack overflow
    private void displayPlaylist(String playlistName) {
        System.out.println("\nYOUR PLAYLIST: " + playlistName);
        System.out.println("[ " + (playlist.getPlaylistSize()) + " song(s) ]\n");

        for (Song song : playlist.getSongList()) {
            System.out.println(song.getTitle());
        }
    }

    // EFFECTS: displays the homepage's options
    private void homePageOptions(String playlistName) {
        System.out.println("\nEnter 1 to Add a Song");
        System.out.println("Enter 2 to Remove a Song");
        System.out.println("Enter 3 to View Playlist");
        //TODO
        System.out.println("Enter 4 to Save Playlist");
        //TODO
        System.out.println("Enter 5 to Load Playlist");
        System.out.println("Enter 6 to Quit Application\n");

    }

    // MODIFIES: this
    // EFFECTS: prompts user to enter a title and adds that song to their playlist
    private void titleOption() {
        Song newSong;
        boolean runOn = true;
        String command = "";

        System.out.println("\nEnter title of song to add:\n");

        while (runOn) {
            command = input.nextLine();

            if (command.length() > 0) {
                runOn = false;
            }
        }

        newSong = new Song(command);
        playlist.addSong(newSong);
        System.out.println("\n\tSong added.");

    }

    // MODIFIES: this
    // EFFECTS: prompts user to enter a title to remove from playlist or to cancel,
    //          processes the user's input
    private void removeOption(String playlistName) {
        boolean runOn = true;
        String command;
        List<Song> songList = playlist.getSongList();
        Song toRemove = new Song("");

        System.out.println("\nEnter title of song to remove:");
        System.out.println("Enter 0 to cancel.\n");

        while (runOn) {
            command = input.nextLine();

            if (command.equals("0")) {
                runOn = false;
            } else {
                for (Song song : songList) {
                    if (command.equals(song.getTitle())) {
                        toRemove = song;
                        runOn = false;
                    }
                }

                playlist.removeSong(toRemove);

            }
        }

        displayPlaylist(playlistName);

    }

    // EFFECTS: saves playlist to file
    private void savePlaylist() {
        try {
            jsonWriter.openWriter();
            jsonWriter.writePlaylist(playlist);
            jsonWriter.closeWriter();

            System.out.println(playlist.getPlaylistName() + " saved to " + JSON_FILE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save playlist to " + JSON_FILE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads playlist from file
    private void loadPlaylist() {
        try {
            playlist = jsonReader.readPlaylist();

            System.out.println(playlist.getPlaylistName() + " loaded from " + JSON_FILE);

        } catch (IOException e) {
            System.out.println("Unable to load playlist from " + JSON_FILE);
        }

    }


}
