import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a single Song, with at least a title, and an artist name.
 */
public class Song implements Playable{

    private final String aTitle;
    private final String aArtist;
    /**
     * Creates a Song.
     * Add your constructor here
     */
    //flyweight
    private final static Map<String, Song> SONGS = new HashMap<>();

    public static Song songFactory(String title, String artist){
        Song song = SONGS.get(title);
        if (song == null){
           song = new Song(title, artist);
           SONGS.put(title, song);
        }
        else if (!song.getArtist().equalsIgnoreCase(artist)){
            song = new Song(title, artist);
            SONGS.put(title, song);
        }
        //returns the unique Song object
        return song;
    }

    private Song(String title, String artist){
        aTitle = title;
        aArtist = artist;
    }
    public String getTitle(){
        return aTitle;
    }
    public String getArtist(){
        return aArtist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return aTitle.equalsIgnoreCase(song.aTitle) && aArtist.equalsIgnoreCase(song.aArtist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aTitle, aArtist);
    }

    public void play() {
        // Just a stub.
        // We don't expect you to implement an actual music player!
        System.out.println("Now playing " + aTitle);
    }
    public static void main(String[] args) {
        Song s1 = songFactory("Hope", "Tory Lanez");
        Song s2 = songFactory("Hope", "Tory Lanez");
        System.out.println(s1.getTitle().equals(s2.getTitle()));
        System.out.println(s1.getArtist().equals(s2.getArtist()));
        s1.play();
        System.out.println(s1.aArtist);
        // TASK: Write runner code to show your work
    }

}