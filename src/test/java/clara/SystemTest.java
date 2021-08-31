package clara;

import org.junit.Test;
import clara.util.ResourceUtils;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class SystemTest {
    private final Properties properties = System.getProperties();
    private final Set<String> keys = properties.stringPropertyNames();
    private final List<String> keysList = new ArrayList<>(keys);

    public static void main(String[] args) {
        String allCaps = System.getProperty("all_caps");
        System.out.printf("all_caps: %s%n", allCaps);
        System.out.printf("args: %s%n", Arrays.asList(args));
        if (Boolean.parseBoolean(allCaps) || Objects.equals(allCaps, "")) {
            System.out.println("ALL CAPS ON");
        } else {
            System.out.println("all caps off");
        }
    }

    /**
     * Sorts system properties by key in ascending alphabetical order.
     */
    @Test
    public void sortTest() {
        TreeMap<Object, Object> sysProps = new TreeMap<>(properties);
        sysProps.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

    /**
     * Sorts system properties by key in descending alphabetical order.
     */
    @Test
    public void sortDescendingTest() {
        keysList.sort(Collections.reverseOrder());
        for (String k : keysList) {
            System.out.printf("%s: %s%n", k, properties.getProperty(k));
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
     * Filters out system properties with keys not containing the string {@code sun}; not case sensitive.
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
     * Tests properties from {@code main/resources/user.properties}.
     */
    @Test
    public void userPropertiesTest() throws IOException {
        Properties properties = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("user.properties");

        try {
            properties.load(stream);
            assertEquals("user54", properties.getProperty("username"));
            assertEquals("Jeff", properties.getProperty("firstName"));
            assertEquals("Smith", properties.getProperty("lastName"));
            assertEquals("English", properties.getProperty("language"));
        } finally {
            ResourceUtils.closeResource(stream);
        }
        properties.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

    /**
     * Creates file {@code book.properties} in tmp dir and writes in properties, and then deletes file.
     */
    @Test
    public void tmpdirPropertiesTest() throws IOException {
        FileWriter writer = null;
        File file = new File(System.getProperty("java.io.tmpdir"), "book.properties");
        System.out.printf("New file created: %s%n", file.getName());
        String newLine = System.getProperty("line.separator");

        try {
            writer = new FileWriter(file);
            writer.write("title=The Namesake" + newLine + "author=Jhumpa Lahiri" + newLine + "pgs=340");
        } finally {
            ResourceUtils.closeResource(writer);
        }

        FileReader fileReader = null;
        Properties properties = new Properties();

        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);

            assertEquals("The Namesake", properties.getProperty("title"));
            assertEquals("Jhumpa Lahiri", properties.getProperty("author"));
            assertEquals("340", properties.getProperty("pgs"));
        } finally {
            ResourceUtils.closeResource(fileReader);
        }

        if (file.delete()) {
            System.out.println("File successfully deleted");
        } else {
            System.out.println("File not deleted");
        }
    }

    /**
     * Creates file {@code eastern_chipmunk.properties}, stores properties in it, then deletes the file.
     */
    @Test
    public void storePropertiesTest() throws IOException {
        OutputStream stream = null;
        FileReader fileReader = null;
        File file = new File(System.getProperty("java.io.tmpdir") + "eastern_chipmunk.properties");

        Properties properties = new Properties();
        properties.setProperty("scientific name", "Tamias striatus");
        properties.setProperty("diet", "omnivore");
        properties.setProperty("habitat", "woodlands");

        try {
            stream = new FileOutputStream(file);
            properties.store(stream, null);
            properties.clear();

            fileReader = new FileReader(file);
            properties.load(fileReader);

            assertEquals("Tamias striatus", properties.getProperty("scientific name"));
            assertEquals("omnivore", properties.getProperty("diet"));
            assertEquals("woodlands", properties.getProperty("habitat"));
        } finally {
            ResourceUtils.closeResource(stream);
            ResourceUtils.closeResource(fileReader);
        }
        file.delete();
    }

    /**
     * Gets environment variables and prints them out.
     */
    @Test
    public void getenvTest() {
        int count = 0;
        for (String k : System.getenv().keySet()) {
            System.out.printf("%s: %s%n", k, System.getenv(k));
            if (++count == 5) {
                break;
            }
        }
        System.out.printf("SHELL: %s%n", System.getenv("SHELL"));
        System.out.printf("TEST: %s%n", System.getenv("TEST"));
        System.out.printf("NONEXISTENT: %s%n", System.getenv("NONEXISTENT"));
    }

    /**
     * An immutable class comparing length of two strings
     */
    public static final class CompareStrLengths implements Comparator<String> {
        private static final CompareStrLengths INSTANCE = new CompareStrLengths();

        private CompareStrLengths() {
        }

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
