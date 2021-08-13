package clara;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertiesTest {
    private final Properties properties = System.getProperties();
    private final Set<String> keys = properties.stringPropertyNames();
    private final List<String> keysList = new ArrayList<>(keys);

    /**
     * Sorts system properties by key in ascending alphabetical order.
     */
    @Test
    public void sortTest() {
        TreeMap<Object, Object> sysProps = new TreeMap<>(properties);
        sysProps.forEach((k, v) -> System.out.printf("%s: %s", k, v));
    }

    /**
     * Sorts system properties by key in descending alphabetical order.
     */
    @Test
    public void sortDescendingTest() {
        keysList.sort(Collections.reverseOrder());
        for (String k : keysList) {
            System.out.printf("%s: %s", k, properties.getProperty(k));
        }
    }

    /**
     * Sorts the system properties by the length of the key.
     */
    @Test
    public void sortKeyLengthTest() {
        keysList.sort(CompareStrLengths.INSTANCE);
        for (String k : keysList) {
            System.out.printf("%s: %s", k, properties.getProperty(k));
        }
    }

    /**
     * Filters out system properties with keys not containing the string 'sun'; not case sensitive
     */
    @Test
    public void filterContainsSunTest() {
        for (String k : keysList) {
            if (k.toLowerCase().contains("sun")) {
                System.out.printf("%s: %s", k, properties.getProperty(k));
            }
        }
    }

    /**
     * Tests properties from main/resources/user.properties
     */
    @Test
    public void userPropertiesTest() throws IOException {
        Properties properties = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("user.properties");
        properties.load(stream);
        assertEquals("user54", properties.getProperty("username"));
        assertEquals("Jeff", properties.getProperty("firstName"));
        assertEquals("Smith", properties.getProperty("lastName"));
        assertEquals("English", properties.getProperty("language"));
        properties.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

    /**
     * Immutable class comparing length of two strings
     */
    public static final class CompareStrLengths implements Comparator<String> {
        private static final CompareStrLengths INSTANCE = new CompareStrLengths();

        private CompareStrLengths() {}

        public static CompareStrLengths getInstance() {
            return INSTANCE;
        }

        /**
         * {@inheritDoc}
         */
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

}
