import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.

    private String name;
    private String artist;
    private SongList songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }


    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }


    public boolean addToPlaylist(int songNumber, LinkedList<Song> playlist) {
        Song checkedSong = this.songs.findSong(songNumber);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }

        System.out.println("Song " + songNumber + " is not on this album.");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song song = this.songs.findSong(title);
        if(song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("Song " + title + " is not on this album.");
        return false;
    }

    public class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(title)) return checkedSong;
            }
            return null;
        }

        public Song findSong(int number) {
            int index = number - 1;
            if (index >= 0 && index < songs.size()) return songs.get(index);
            else return null;

        }
    }
}
