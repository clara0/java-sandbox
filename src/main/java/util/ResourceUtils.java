package util;

import java.io.Closeable;
import java.io.IOException;

public class ResourceUtils {

    /**
     * Takes a {@code Closeable} as a parameter and closes it.
     */
    public void closeResource(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}
