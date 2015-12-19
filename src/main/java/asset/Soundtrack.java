package asset;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;

/**
 * Music objects that can be played, looped, and skipped through
 */
public class Soundtrack extends Music {

    private final float[] segments;

    // Pre-loaded songs:
    public static Soundtrack example;

    /**
     * Loads all the game's music. Must be called before any music can be played.
     */
    public static void load() throws SlickException {
        // Define songs here:
//        example = new Soundtrack("", new float[]{});
    }

    // Private constructor:
    private Soundtrack(String URI, float[] markers) throws SlickException {
        super(URI);
        this.segments = markers;
        addListener(new MusicListener() {
            @Override
            public void musicEnded(Music music) {
                playFrom(segments.length-1);
            }
            @Override
            public void musicSwapped(Music music, Music newMusic) {}
        });
    }

    /**
     * Play a given section of the song. If the song is already playing, it will jump to and play the given section.
     * @param segment index of segment to begin playing
     * @return 0 if successful, -1 if error.
     */
    public int playFrom(int segment) {
        if (segment >= segments.length || segment < 0) return -1;
        setPosition(segments[segment]);
        if (!playing()) {
            play();
        }
        return 0;
    }

    /**
     * Get the index of the musical segment currently playing. May be useful for deciding where to jump to next.
     * @return index of playing segment.
     */
    public int getPlayingSegment() {
        if (playing()) {
            // Probably overkill to do binary search optimization here, but hey it's good practice.
            float position = getPosition();
            int startIndex = 0;
            int endIndex = segments.length - 1;
            int middleIndex;
            while (startIndex < endIndex) {
                middleIndex = (endIndex+startIndex)/2;
                if (position < segments[middleIndex+1]) {
                    endIndex = middleIndex;
                } else {
                    startIndex = middleIndex + 1;
                }
            }
            return startIndex;
        } else {
            return -1;
        }
    }
}
