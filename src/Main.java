import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        // Modify the playlist challenge so that the Album class uses an inner class.
        // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
        // The inner SongList class will use an ArrayList and will provide a method to add a song.
        // It will also provide findSong() methods which will be used by the containing Album class
        // to add songs to the playlist.
        // Neither the Song class or the Main class should be changed.

        Album album = new Album("Blackwater Park", "Opeth");
        album.addSong("The Lepper Affinity", 10.23);
        album.addSong("Bleak", 9.16);
        album.addSong("Harvest", 6.01);
        album.addSong("The Drapery Falls", 10.54);
        album.addSong("Dirge for November", 7.54);
        album.addSong("The Funeral Portret", 8.45);
        album.addSong("Patterns in the Ivy", 1.54);
        album.addSong("Blackwater Park", 12.08);
        album.addSong("The Lepper Affinity - Live", 9.26);
        albums.add(album);

        album = new Album("Senjutsu", "Iron Maiden");
        album.addSong("Senjutsu", 8.20);
        album.addSong("Stratego", 4.59);
        album.addSong("The Writing on the Wall", 6.13);
        album.addSong("Lost in a Lost World", 9.31);
        album.addSong("Days of Future Past", 4.03);
        album.addSong("The Time Machine", 7.09);
        album.addSong("Darkest Hour", 7.20);
        album.addSong("Death of the Celts", 10.20);
        album.addSong("The Parchment", 12.38);
        album.addSong("Hell on Earth", 11.19);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist(1, playlist);
        albums.get(0).addToPlaylist("Blackwater Park", playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist("Hell on Earth", playlist);

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Now playing: " + listIterator.next().toString());
        printMenu();

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playlist.size() >0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }
}
