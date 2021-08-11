package clara;

import org.junit.Test;

import java.util.*;

public class SystemPropertiesTest {
    private final Properties properties = System.getProperties();
    private final Set<String> keys = properties.stringPropertyNames();
    private final List<String> keysList = new ArrayList<>(keys);

    /***
     * Sorts system properties by key in ascending alphabetical order.
     */
    @Test
    public void sortTest() {
        TreeMap<Object, Object> sysProps = new TreeMap<>(properties);
        sysProps.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    /**
     * Sorts system properties by key in descending alphabetical order.
     */
    @Test
    public void sortDescendingTest() {
        keysList.sort(Collections.reverseOrder());
        for (Object k : keysList) {
            System.out.println(k + ": " + properties.get(k));
        }
    }

    /**
     * Sorts the system properties by the length of the key.
     */
    @Test
    public void sortKeyLengthTest() {
        keysList.sort(new CompareStrLengths());
        for (Object k : keysList) {
            System.out.println(k + ": " + properties.get(k));
        }
    }

    static class CompareStrLengths implements Comparator<String> {
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

}
