import java.util.*;

/**
 * Represents a single Podcast, with at least a name and a host. Each Podcast aggregates episodes.
 */
public class Podcast{

    private final String aName;
    private final String aHost;

    private final List<Episode> aEpisodes = new ArrayList<>();

    /**
     * Creates a Podcast
     * Add your constructor below
     *
     */
    private static Map<String, Podcast> PODCASTS = new HashMap<>();
    public static Podcast podcastFactory(String name, String host){
        Podcast podcast = PODCASTS.get(name);
        if (podcast == null){
            podcast = new Podcast(name, host);
            PODCASTS.put(name, podcast);
        }
        else if (!podcast.getaHost().equalsIgnoreCase(host)){
            podcast = new Podcast(name, host);
            PODCASTS.put(name, podcast);
        }
        //returns the unique Podcast object
        return podcast;
    }
    private Podcast(String name, String host){
        aName = name;
        aHost = host;
    }



    /**
     * Add one episode to the podcast
     * @param pEpisode to be put into the podcast
     * @pre
     */
    protected void addEpisode(Episode pEpisode) {
        if(!aEpisodes.contains(pEpisode)) {
            aEpisodes.add(pEpisode);
        }
    }

    /**
     * retrieve one episode from the podcast
     * @param pIndex
     *
     */

    public Episode getEpisode(int pIndex) {
        return aEpisodes.get(pIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Podcast podcast = (Podcast) o;
        return aName.equalsIgnoreCase(podcast.aName) && aHost.equalsIgnoreCase(podcast.aHost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName, aHost);
    }

    public String getName() {

        return aName;
    }

    public String getaHost() {
        return aHost;
    }
    public List<Playable> getEpList(){
        List<Playable> epList= new ArrayList<>(aEpisodes);
        return epList;
    }

    public static void main(String[] args) {
        Podcast p1 = podcastFactory("Hope", "Tory Lanez");
        Podcast p2 = podcastFactory("Hope", "Tory Lanez");
        System.out.println(p1.getName().equals(p2.getName()));
        System.out.println(p1.getaHost().equals(p2.getaHost()));
        // TASK: Write runner code to show your work
    }

}