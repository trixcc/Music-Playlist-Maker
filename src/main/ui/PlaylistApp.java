package ui;

import model.Playlist;
import model.Song;
import java.util.List;
import java.util.Scanner;

// A Music Playlist Maker application
public class PlaylistApp {
    private Playlist playlist;
    private Scanner input;

    // EFFECTS: runs the playlist application
    public PlaylistApp() {
        runPlaylistApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // runPlaylistApp based on runTeller from Teller application
    private void runPlaylistApp() {
        boolean runOn = true;
        String command;
        input = new Scanner(System.in);

        while (runOn) {
            startMenu();
            command = input.next();

            if (command.equals("2")) {
                runOn = false;
                System.out.println("See you later!");
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
        System.out.println("\nHello! Would you like to make a new playlist?");
        System.out.println("\tEnter 1 for YES");
        System.out.println("\tEnter 2 for NO");

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

            if (command.equals("4")) {
                runOn = false;
            } else if (command.equals("1")) {
                titleOption();
            } else if (command.equals("2")) {
                removeOption(playlistName);
            } else if (command.equals("3")) {
                displayPlaylist(playlistName);
            } else {
                System.out.println("Selection not valid.");
            }
        }
        System.out.println("See you later!");

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
        System.out.println("Enter 4 to Quit Application");

    }

    // MODIFIES: this
    // EFFECTS: prompts user to enter a title and adds that song to their playlist
    private void titleOption() {
        Song newSong;
        boolean runOn = true;
        String command = "";

        System.out.println("\nEnter title of song to add:");

        while (runOn) {
            command = input.nextLine();

            if (command.length() > 0) {
                runOn = false;
            }

        }

        newSong = new Song(command);
        playlist.addSong(newSong);
        System.out.println("\n Name added.");

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
        System.out.println("Enter 0 to cancel.");

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
}
