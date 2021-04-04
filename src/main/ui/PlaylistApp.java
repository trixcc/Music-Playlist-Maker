package ui;

import model.EmptyPlaylistException;
import model.InvalidNameLengthException;
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

            if (command.equals("3")) {
                runOn = false;
                System.out.println("\nSee you later!");
            } else if (command.equals("1")) {
                runOn = false;
                beginPlaylistMaking();
            } else if (command.equals("2")) {
                runOn = false;
                loadPlaylist();
            } else {
                System.out.println("\nSelection not valid.");
            }
        }
    }


    // EFFECTS: displays the starting menu to the user
    private void startMenu() {
        System.out.println("Hello!\n");
        System.out.println("Enter 1 to MAKE A NEW PLAYLIST");
        System.out.println("Enter 2 to LOAD PLAYLIST FROM FILE");
        System.out.println("Enter 3 to QUIT APPLICATION\n");

    }

    // MODIFIES: this
    // EFFECTS: prompts user to name their new playlist
    private void beginPlaylistMaking() {
        boolean runOn = true;
        String command;

        System.out.println("\nWhat would you like to name your new playlist?");

        while (runOn) {
            command = input.nextLine();

            try {
                playlist = new Playlist(command);
            } catch (InvalidNameLengthException e) {
                System.out.println("[ Playlist name cannot be zero length. ]");
            }

            if (command.length() > 0) {
                runOn = false;
                try {
                    playlist = new Playlist(command);
                } catch (InvalidNameLengthException e) {
                    System.out.println("[ Playlist name cannot be zero length. ]");
                }
                homePage();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: displays the homepage of the playlist application and processes user input
    private void homePage() {
        boolean runOn = true;
        String command;

        while (runOn) {
            homePageOptions();
            command = input.next();

            if (command.equals("5")) {
                runOn = false;
            } else if (command.equals("1")) {
                addOption();
            } else if (command.equals("2")) {
                removeOption();
            } else if (command.equals("3")) {
                displayPlaylist();
            } else if (command.equals("4")) {
                savePlaylist();
            } else {
                System.out.println("Selection not valid.");
            }
        }

        System.out.println("\nSee you later!");

    }

    // EFFECTS: displays the homepage's options
    private void homePageOptions() {
        System.out.println("\nEnter 1 to ADD A SONG");
        System.out.println("Enter 2 to REMOVE A SONG");
        System.out.println("Enter 3 to VIEW PLAYLIST");
        System.out.println("Enter 4 to SAVE PLAYLIST");
        System.out.println("Enter 5 to QUIT APPLICATION\n");

    }

    // MODIFIES: this
    // EFFECTS: prompts user to enter a title of a song to add to playlist or to cancel
    private void addOption() {
        Song newSong;
        boolean runOn = true;
        String command;

        System.out.println("\nEnter title of song to add:");
        System.out.println("Enter 0 to cancel.");

        while (runOn) {
            command = input.nextLine();

            if (command.equals("0")) {
                runOn = false;
            } else {
                if (command.length() > 0) {
                    newSong = new Song(command);
                    playlist.addSong(newSong);
                    System.out.println("\n\tSong added.");

                    runOn = false;

                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: prompts user to enter a title of a song to remove from playlist or to cancel
    private void removeOption() {
        boolean runOn = true;
        String command;
        Song toRemove = null;

        removeOptionInstructions();

        while (runOn) {
            command = input.nextLine();

            if (command.equals("0")) {
                runOn = false;
            } else {
                for (Song song : playlist.getSongList()) {
                    if (command.equals(song.getTitle())) {
                        toRemove = song;
                        System.out.println("\n\tSong removed.");

                        runOn = false;
                    }
                }

                try {
                    playlist.removeSong(toRemove);
                } catch (EmptyPlaylistException e) {
                    System.out.println("[ Cannot remove a song from an empty playlist. ]");
                }

            }
        }
    }

    // EFFECTS: displays instructions for removing a song from playlist
    private void removeOptionInstructions() {
        System.out.println("\nEnter title of song to remove:");
        System.out.println("Enter 0 to cancel.");
    }

    // EFFECTS: displays the user's playlist details
    private void displayPlaylist() {
        System.out.println("\nYOUR PLAYLIST: " + playlist.getPlaylistName());
        System.out.println("[ " + (playlist.getPlaylistSize()) + " song(s) ]\n");

        List<Song> songs = playlist.getSongList();

        for (Song s : songs) {
            System.out.println(s.getTitle());
        }
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

        homePage();

    }

}
