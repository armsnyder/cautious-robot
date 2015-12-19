/*
 * Copyright (c) 2015 Adam Snyder. All rights reserved.
 */

package asset;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images {

    // Pre-loaded images:
    public static Image example;

    private static boolean loaded = false;

    public static void load() throws SlickException {
        if (!loaded) {
            // Define images here:
//            example = new Image("");
            loaded = true;
        }
    }
}
