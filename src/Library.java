import java.util.*;

/**
 * Represents an Audio library, with individual Song titles, Podcasts and playlists.
 */
public class Library {
    private String libraryName = null;
    private String libraryDescription = null;
    //list for all elements in Library
    private final List<Playable> aElement = new ArrayList<>();
    //hashmap to store playlists info
    private final Map<List<Playable>,String> playList = new HashMap<>();

    //singleton
    private static final Library INSTANCE = new Library();

    public static Library instance() { return INSTANCE; }
    public void setter(String name, String description){
        libraryName = name;
        libraryDescription = description;
    }
    public String getLibraryName(){
        return libraryName;
    }
    public String getLibraryDescription(){
        return libraryDescription;
    }

    /**
     * Adds your design of fields for Library
     *


     /**
     * Adds a Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pSong the Song to add
     */
    public void addSong(Song pSong) {
        aElement.add(pSong);
    }

    /**
     * Adds a PlayList to the library. All Songs from the list are also added as individual Songs to the library.
     *
     * @param pList
     *            the PlayList to add
     * @pre pList!=null;
     */
    public void addPlayList(PlayList pList) {
        assert pList!= null;
        if (playList.isEmpty()){
            playList.put(pList.getEpList(),pList.getName());
            aElement.add(pList);
            Collections.addAll(pList.getEpList());

        }
        else if (!playList.containsKey(pList.getEpList())){
            playList.put(pList.getEpList(),pList.getName());
            aElement.add(pList);
            Collections.addAll(pList.getEpList());
        }
        // Please add you implementation here
    }

    /**
     * Adds a Podcast to the library. All Episodes from the list are also added as individual episodes to the library.
     *
     * @param pPodcast
     *            the Podcast to add
     * @pre pPodcast!=null;
     */
    public void addPodcast(Podcast pPodcast) {
        assert pPodcast!= null;
        aElement.addAll(pPodcast.getEpList());
        // Please add you implementation here
    }
    public void play() {
        for (Playable e: aElement){
           e.play();
        }

    }
    public static void main(String[] args) {
        Library l1 = new Library();
        l1.setter("me", "why");
        Library l2 = Library.instance();
        l2.setter("me2", "why");
        System.out.println(l1.libraryName);
        System.out.println(l1.libraryDescription);
        System.out.println(l2.libraryName);
        System.out.println(l2.libraryDescription);

    }

}
