import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PlaylistManager {
    private ArrayList<String> playlist;

    public PlaylistManager() {
        playlist = new ArrayList<>();
        new Random();
    }

    public void addSong(String song) {
        playlist.add(song);
    }

    public void removeSong(String song) {
        playlist.remove(song);
    }

    public void shufflePlaylist() {
        long seed = System.nanoTime();
        Collections.shuffle(playlist, new Random(seed));
    }

    public void playPlaylist() {
        System.out.println("Playing playlist...");
        for (String song : playlist) {
            System.out.println("Now playing: " + song);
        }
        System.out.println("Playlist finished.");
    }

    public void printPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Playlist Manager");
            System.out.println("1. Add song");
            System.out.println("2. Remove song");
            System.out.println("3. Shuffle playlist");
            System.out.println("4. Play playlist");
            System.out.println("5. Show playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter the name of the song: ");
                    String songName = scanner.nextLine();
                    addSong(songName);
                    System.out.println("Song added successfully.");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter the name of the song to remove: ");
                    String songToRemove = scanner.nextLine();
                    if (playlist.contains(songToRemove)) {
                        removeSong(songToRemove);
                        System.out.println("Song removed successfully.");
                    } else {
                        System.out.println("The song is not found in the playlist.");
                    }
                    break;
                case 3:
                    shufflePlaylist();
                    System.out.println("Playlist shuffled successfully.");
                    break;
                case 4:
                    playPlaylist();
                    break;
                case 5:
                    printPlaylist();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    public static void main(String[] args) {
        PlaylistManager manager = new PlaylistManager();
        manager.menu();
    }
}
