package ui;

import model.Playlist;

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
    private void runPlaylistApp() {
        boolean runOn = true;
        int command = 0;

        input = new Scanner(System.in);

        while (runOn) {
            mainMenu();
            command = input.nextInt();
            input.nextLine();

            if (command == 2) {
                runOn = false;
                System.out.println("See you later!");
            } else if (command == 1) {
                runOn = false;
                beginPlaylistMaking();
            } else {
                System.out.println("Selection not valid.");
            }
        }
    }


    // EFFECTS: displays a starting menu to the user
    private void mainMenu() {
        System.out.println("\nHello! Would you like to make a new playlist?");
        System.out.println("\tEnter 1 for YES");
        System.out.println("\tEnter 2 for NO");

    }

    // MODIFIES: this
    // EFFECTS: asks user to name their new playlist
    private void beginPlaylistMaking() {
        boolean runOn = true;
        String command = null;

        System.out.println("\nWhat would you like to name your new playlist?");

        while (runOn) {
            command = input.nextLine();

            if (command.length() > 0) {
                runOn = false;
                displaySongs(command);
            }
        }

    }

    // EFFECTS: displays a list of songs in the playlist,
    //          asks user if they want to add a song
    private void displaySongs(String playlistName) {
        boolean runOn = true;
        int command = 0;
        Playlist playlist = new Playlist(playlistName);

        System.out.println("\nHere is your playlist called " + playlistName + "!");
        System.out.println("\nIt currently has " + String.valueOf(playlist.getPlaylistSize()) + " songs.");
        System.out.println(playlist.getSongList());
        System.out.println("\nWould you like to add a song?");
        System.out.println("\tEnter 1 for YES");
        System.out.println("\tEnter 2 for NO");

        while (runOn) {
            command = input.nextInt();
            input.nextLine();

            if (command == 2) {
                runOn = false;
            } else if (command == 1) {
                runOn = false;
                addingSong();
            } else {
                System.out.println("Selection not valid.");
            }
        }

        sideMenu();

    }

    private void addingSong() {

    }

    private void sideMenu() {

    }

}

