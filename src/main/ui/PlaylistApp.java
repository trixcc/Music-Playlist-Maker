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
        String command = null;
        input = new Scanner(System.in);

        while (runOn) {
            mainMenu();
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
        String command = null;
        Playlist playlist = new Playlist(playlistName);

        System.out.println("\nHere is your playlist called " + playlistName + "!");
        System.out.println("\nIt currently has " + String.valueOf(playlist.getPlaylistSize()) + " songs.");
        System.out.println(playlist.getSongList());

        while (runOn) {
            songAddOrRemove(playlist);
            command = input.next();

            if (command.equals("2")) {
                runOn = false;
            } else if (command.equals("1")) {
                runOn = false;
                songMenu(playlist, playlistName);
            } else if (command.equals("3")) {
                removeOption();
            } else {
                System.out.println("Selection not valid.");
            }
        }

        sideMenu();

    }

    // EFFECTS: displays an option to add or remove a song to the playlist,
    //          remove option is displayed only if the playlist is not empty
    private void songAddOrRemove(Playlist playlist) {
        System.out.println("\nAdd a song?");
        System.out.println("\tEnter 1 for YES");
        System.out.println("\tEnter 2 for NO");

        if (playlist.getPlaylistSize() > 0) {
            System.out.println("\nRemove a song?");
            System.out.println("\tEnter 3 for YES");
            System.out.println("\tEnter 2 for NO");
        }
    }

    private void removeOption() {

    }

    // MODIFIES: this
    // EFFECTS: displays options to user for making a song
    private void songMenu(Playlist playlist, String playlistName) {
        boolean runOn = true;
        String command = null;

        while (runOn) {
            songOptions();
            command = input.next();

            if (command.equals("0")) {
                runOn = false;
                displaySongs(playlistName);
            } else if (command.equals("1")) {
                nameOption(playlist);
            } else if (command.equals("2")) {
                artistOption(playlist);
            } else if (command.equals("3")) {
                albumOption(playlist);
            } else if (command.equals("4")) {
                lengthOption(playlist);
            } else {
                System.out.println("\n Selection not valid.");
            }
        }

    }

    private void songOptions() {
        System.out.println("\nOptions:");
        System.out.println("\tEnter 1 to add the name of your song.");
        System.out.println("\tEnter 2 to add the artist of your song.");
        System.out.println("\tEnter 3 to add the album of your song.");
        System.out.println("\tEnter 4 to add the length of your song.");
        System.out.println("\tEnter 0 to view your playlist.");

    }

    private void nameOption(Playlist playlist) {

    }

    private void artistOption(Playlist playlist) {

    }

    private void albumOption(Playlist playlist) {

    }

    private void lengthOption(Playlist playlist) {
        
    }

    private void sideMenu() {

    }

}

