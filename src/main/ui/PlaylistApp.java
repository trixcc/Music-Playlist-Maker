package ui;

import model.Playlist;
import model.Song;
import java.util.ArrayList;
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

    // EFFECTS: displays the homepage
    private void homePage(String playlistName) {
        boolean runOn = true;
        String command = null;
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
    private void displayPlaylist(String playlistName) {
        System.out.println("\nYOUR PLAYLIST: " + playlistName);
        System.out.println("[ " + String.valueOf(playlist.getPlaylistSize()) + " song(s) ]\n");
// cite stack overflow
        for (Song song : playlist.getSongList()) {
            System.out.println(song.getTitle());
        }
    }

    // EFFECTS: displays the homepage's options to user
    private void homePageOptions(String playlistName) {
        System.out.println("\nEnter 1 to Add a Song");
        System.out.println("Enter 2 to Remove a Song");
        System.out.println("Enter 3 to View Playlist");
        System.out.println("Enter 4 to Quit Application");

    }

    private void titleOption() {
        Song newSong;
        boolean runOn = true;
        String command = "";

        System.out.println("\nEnter title of song:");

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

    private void removeOption(String playlistName) {
        boolean runOn = true;
        String command = null;
        List<Song> songList = playlist.getSongList();
        Song toRemove = new Song("");

        System.out.println("\nWhat is the title of the song that you want to remove?");
        System.out.println("Enter 0 to cancel.");

        while (runOn) {
            command = input.next();


            if (command.equals("0")) {
                System.out.println("\nCancelled.");
            } else {
                for (Song song : songList) {
                    if (command.equals(song.getTitle())) {
                        toRemove = song;
                    }
                }
                playlist.removeSong(toRemove);
            }
            runOn = false;
            displayPlaylist(playlistName);
        }

    }
}

    /*    // MODIFIES: this
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
        System.out.println("\nSong Options:");
        System.out.println("\tEnter 1 to add a title of your song.");
        System.out.println("\tEnter 2 to add the artist of your song.");
        System.out.println("\tEnter 3 to add the album of your song.");
        System.out.println("\tEnter 4 to add the length of your song.");
        System.out.println("\tEnter 0 to view your playlist.");

    }*/

/*    private void artistOption() {

    }

    private void albumOption() {

    }

    private void lengthOption() {

    }*/


