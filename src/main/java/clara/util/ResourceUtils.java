package clara.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Methods to be used for resources.
 */
public final class ResourceUtils {

    private ResourceUtils() {}

    /**
     * Closes a resource and catches IOException if it occurs.
     * @param closeable to be closed
     */
    public static void closeResource(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}
