import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

/**
 * Main class for starting the game
 */
public class Main extends StateBasedGame {

    private static final String TITLE = "Cautious Robot";
    private static final int FPS = 60;
    private static final int LOGIC_UPDATE_INTERVAL = FPS;
    private static final boolean V_SYNC = true;
    private static final int WIDTH = 1366;
    private static final int HEIGHT = 768;

    private static Main _instance = null;

    /**
     * If true, then the user has launched the game in debug mode. Wrap all debug logic in conditional that checks this
     * variable.
     */
    public final boolean DEBUG_MODE;

    public static void main(String[] args) throws SlickException {

        // Check command line arguments and adjust settings accordingly
        boolean windowed = false;
        boolean debug = false;
        for (String a : args) {
            if (a.equalsIgnoreCase("windowed")) windowed = true;
            if (a.equalsIgnoreCase("window")) windowed = true;
            if (a.equalsIgnoreCase("debug")) debug = true;
        }

        // Initialize game and set resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int displayWidth = (int) screenSize.getWidth(); // Actual width of physical display
        int displayHeight = (int) screenSize.getHeight(); // Actual height of physical display
        Game game = new ScalableGame(new Main(debug), WIDTH, HEIGHT);
        AppGameContainer app = new AppGameContainer(game, WIDTH, HEIGHT, false);

        // Set full screen mode
        if (windowed) {
            app.setDisplayMode(WIDTH, HEIGHT, false);
        } else {
            app.setDisplayMode(displayWidth, displayHeight, true);
        }

        // Start game
        app.start();
    }

    /**
     * Create a new state based game
     */
    public Main(boolean debug) {
        super(TITLE);
        DEBUG_MODE = debug;
        _instance = this;
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        container.setMaximumLogicUpdateInterval(LOGIC_UPDATE_INTERVAL);
        container.setAlwaysRender(true);
        container.setTargetFrameRate(FPS);
        container.setShowFPS(DEBUG_MODE);
        container.setVSync(V_SYNC);
    }

    public static Main getInstance() {
        if (_instance == null) throw new RuntimeException("No game instance exists");
        return _instance;
    }
}
