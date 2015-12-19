package util;

import java.io.File;
import java.net.URL;
import java.util.Random;

/**
 * A static class containing generic useful methods and objects.
 */
public class Util {

    /**
     * An object that can be useed to generate random values
     */
    public static final Random RANDOM = new Random();

    /**
     * Get a resource (file)
     * @param path name of resource to fetch, relative to resource folder
     * @return resource file
     */
    public static File getResource(String path) {
        ClassLoader classLoader = Util.class.getClassLoader();
        return getResource(path, classLoader);
    }

    /**
     * Get a resource (file) with respect to a custom ClassLoader
     * @param path name of resource to fetch, relative to resource folder
     * @return resource file
     */
    public static File getResource(String path, ClassLoader classLoader) {
        URL url = classLoader.getResource(path);
        assert url != null;
        return new File(url.getFile());
    }
}
