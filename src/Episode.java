import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single episode, with at least a title, and an episode number.
 */
public class Episode implements Playable {

    private final Podcast aPodcast;
    private final String aTitle;
    private final int aEpisodeNumber;

    private static Map<String, Episode> EPISODES = new HashMap<>();
    public static Episode episodeFactory(Podcast podcast, String title, int epNum){
        Episode ep = EPISODES.get(title);
        if (ep == null){
            ep = new Episode(podcast, title, epNum);
            EPISODES.put(title, ep);
        }
        else if (!(ep.getaPodcast().equals(podcast)&&ep.getaEpisodeNumber()==epNum)){
            ep = new Episode(podcast, title, epNum);
            EPISODES.put(title, ep);
        }
        //returns the unique Episode object
        return ep;
    }

    /**
     * Creates an episode
     *
     * @param pPodcast
     *            Podcast that this episode is a part of
     * @param pTitle
     *            title of the episode
     * @param pEpisodeNumber
     *            the episode number that identifies the episode
     * @pre   pPodcast != null && pTitle!=null
     * @throws IllegalArgumentException
     */
    private Episode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {
        assert (pPodcast != null) && (pTitle != null);
        aPodcast = pPodcast;
        aTitle = pTitle;
        aEpisodeNumber = pEpisodeNumber;
        aPodcast.addEpisode(this);
    }

    public Podcast getaPodcast() {
        return aPodcast;
    }

    public String getaTitle() {
        return aTitle;
    }

    public int getaEpisodeNumber() {
        return aEpisodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + aPodcast.getName() + " [" + aEpisodeNumber + "]: " + aTitle);
    }

}
