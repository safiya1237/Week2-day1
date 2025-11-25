import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlaylist {

    private LinkedList<String> playlist;
    private ListIterator<String> iterator;
    private String currentSong;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
        iterator = playlist.listIterator();
        currentSong = null;
    }

    // Add a song
    public void addSong(String song) {
        playlist.add(song);
        System.out.println(song + " added to the playlist.");
        iterator = playlist.listIterator(); // reset iterator
    }

    // Play next song
    public void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (!iterator.hasNext()) {
            System.out.println("You are at the end of the playlist.");
            return;
        }
        currentSong = iterator.next();
        System.out.println("Playing next song: " + currentSong);
    }

    // Play previous song
    public void playPrevious() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (!iterator.hasPrevious()) {
            System.out.println("You are at the start of the playlist.");
            return;
        }
        currentSong = iterator.previous();
        System.out.println("Playing previous song: " + currentSong);
    }

    // Remove a song safely (ERROR FIXED)
    public void removeSong(String song) {
        ListIterator<String> removeIterator = playlist.listIterator();
        boolean found = false;

        while (removeIterator.hasNext()) {
            if (removeIterator.next().equals(song)) {
                removeIterator.remove(); // safe removal
                found = true;
                System.out.println(song + " removed from the playlist.");
                break;
            }
        }

        if (!found) {
            System.out.println(song + " not found in the playlist.");
        }

        // Reset main iterator after modification
        iterator = playlist.listIterator();
    }

    // Display playlist
    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Full Playlist:");
        int count = 1;
        for (String song : playlist) {
            System.out.println(count + ". " + song);
            count++;
        }
    }

    public static void main(String[] args) {
        MusicPlaylist mp = new MusicPlaylist();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Music Playlist Menu ---");
            System.out.println("1. Add a song");
            System.out.println("2. Play next song");
            System.out.println("3. Play previous song");
            System.out.println("4. Remove a song");
            System.out.println("5. Display full playlist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add: ");
                    String songToAdd = sc.nextLine();
                    mp.addSong(songToAdd);
                    break;

                case 2:
                    mp.playNext();
                    break;

                case 3:
                    mp.playPrevious();
                    break;

                case 4:
                    System.out.print("Enter song name to remove: ");
                    String songToRemove = sc.nextLine();
                    mp.removeSong(songToRemove);
                    break;

                case 5:
                    mp.displayPlaylist();
                    break;

                case 6:
                    System.out.println("Exiting playlist...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 6);

        sc.close();
    }
}