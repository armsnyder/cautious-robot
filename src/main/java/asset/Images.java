/*
 * Copyright (c) 2015 Adam Snyder. All rights reserved.
 */

package asset;


import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Images {

    // Pre-loaded images:
    public static SpriteSheet exampleSpriteSheet;

    private static boolean loaded = false;

    public static void load() throws SlickException {
        if (!loaded) {
            exampleSpriteSheet = new SpriteSheet("emptySpritesheet.png", 64, 64);
            loaded = true;
        }
    }
}
