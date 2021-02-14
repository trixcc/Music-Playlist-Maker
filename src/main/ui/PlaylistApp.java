package ui;

import model.Playlist;
import model.Song;

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
                homePage(command);
            }
        }

    }

    // EFFECTS: displays a list of songs in the playlist,
    //          asks user if they want to add a song
    private void homePage(String playlistName) {
        boolean runOn = true;
        String command = null;
        playlist = new Playlist(playlistName);

        while (runOn) {
            songAddOrRemove(playlistName);
            command = input.next();

            if (command.equals("4")) {
                runOn = false;
            } else if (command.equals("1")) {
                songMenu(playlistName);
            } else if (command.equals("2")) {
                removeOption();
            } else if (command.equals("3")) {
                displayHomePage(playlistName);
            } else {
                System.out.println("Selection not valid.");
            }
        }

    }

    private void displayHomePage(String playlistName) {
        System.out.println("\nHere is your playlist called " + playlistName + "!");
        System.out.println("\nIt currently has " + String.valueOf(playlist.getPlaylistSize()) + " songs.");
        System.out.println(playlist.getSongList());
    }

    // EFFECTS: displays an option to add or remove a song to the playlist,
    //          remove option is displayed only if the playlist is not empty
    private void songAddOrRemove(String playlistName) {
        System.out.println("\nEnter 1 to Add a Song");
        System.out.println("Enter 2 for Remove a Song");
        System.out.println("Enter 3 to View Playlist");
        System.out.println("Enter 4 to Quit Application");

    }

    private void removeOption() {

    }

    // MODIFIES: this
    // EFFECTS: displays options to user for making a song
    private void songMenu(String playlistName) {
        boolean runOn = true;
        String command = null;

        while (runOn) {
            songOptions();
            command = input.next();

            if (command.equals("0")) {
                runOn = false;
            } else {
                processCommand(command);
            }
        }

        displayHomePage(playlistName);
    }

    private void processCommand(String command) {
        if (command.equals("1")) {
            nameOption();
        } else if (command.equals("2")) {
            artistOption();
        } else if (command.equals("3")) {
            albumOption();
        } else if (command.equals("4")) {
            lengthOption();
        } else {
            System.out.println("\n Selection not valid.");

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

    private void nameOption() {
        Song newSong;
        boolean runOn = true;
        String command = "";

        System.out.println("Enter a name: ");

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

    private void artistOption() {

    }

    private void albumOption() {

    }

    private void lengthOption() {

    }

}

