import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //creating two library objects
        //There should only be one library object
        //1st library
        Library library1 = Library.instance();
        library1.setter("My First Library", "Contains my favourite songs and playlist for summer");
        System.out.println(library1.getLibraryName());
        System.out.println(library1.getLibraryDescription());
        System.out.println(" ");
        //2nd library
        Library library2 = Library.instance();
        library2.setter("My Second Library", "Contains my favourite songs and playlist for winter");

        //There's still only one library object
        System.out.println("Current Library Object: " + library1);
        System.out.println("Current Library Object: " + library2);
        System.out.println(library1.getLibraryName());
        System.out.println(library1.getLibraryDescription());
        System.out.println(library2.getLibraryName());
        System.out.println(library2.getLibraryDescription());
        System.out.println(" ");

        //creating song objects
        //There shouldn't be duplicate song objects
        Song song1 = Song.songFactory("Hope", "Tory Lanez");
        //duplicate song but lowercase artist name
        Song song2 = Song.songFactory("Hope", "tory lanez");

        //song1 and 2 are the same object
        System.out.println(song1);
        System.out.println(song2);

        Song song3 = Song.songFactory("The Color Violet", "Tory Lanez");

        //creating two identical playlists
        PlayList playlist = new PlayList("My Playlist");
        PlayList anotherPlaylist = new PlayList("My Another Playlist");

        System.out.println(" ");

        //creating two identical podcasts
        //there shouldn't be two identical podcast objects
        Podcast podcast1 = Podcast.podcastFactory("How to code in Java", "Yanin Niramai");
        Podcast podcast2 = Podcast.podcastFactory("How to code in Java", "Yanin Niramai");
        //podcast1 and 2 are the same object
        System.out.println(podcast1);
        System.out.println(podcast2);
        System.out.println(" ");

        //creating two identical episodes
        //there shouldn't be two identical episode objects
        //add to podcast1
        Episode ep1 = Episode.episodeFactory(podcast1, "Java Variables", 1);
        //add to podcast2
        Episode ep2 = Episode.episodeFactory(podcast2, "Java Variables", 1);
        //episode 1 and 2 are the same object in the same podcast
        System.out.println(ep1);
        System.out.println(ep2);
        System.out.println(" ");
        Episode ep3 = Episode.episodeFactory(podcast2, "Java For Loop", 2);

        podcast1.getEpisode(0).play();
        podcast1.getEpisode(1).play();
        System.out.println(" ");

        //add 2 songs to both playlists
        playlist.addPlayable(song1);
        playlist.addPlayable(song3);
        anotherPlaylist.addPlayable(song1);
        anotherPlaylist.addPlayable(song3);
        //add the first ep into both playlists
        playlist.addPlayable(ep1);
        anotherPlaylist.addPlayable(ep1);

        //add two identical playlists to library
        library1.addPlayList(playlist);
        library1.addPlayList(anotherPlaylist);
        //only one playlist gets added
        library1.play();
        System.out.println(" ");
        //add song
        library1.addSong(song1);
        library1.play();
        System.out.println(" ");
        //add podcast
        library1.addPodcast(podcast1);
        library1.play();




        // TASK: Write runner code to show your work
    }
}
