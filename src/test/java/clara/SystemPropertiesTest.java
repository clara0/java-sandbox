package clara;

import org.junit.Test;

import java.util.*;

public class SystemPropertiesTest {
    Properties props = System.getProperties();
    Set<Object> keys = props.keySet();
    List<Object> keysList = new ArrayList<>(keys);

    /***
     * Sorts system properties by key in ascending alphabetical order.
     */
    @Test
    public void sortTest() {
        TreeMap<Object, Object> sysProps = new TreeMap<>();
        props.forEach(sysProps::put);
        sysProps.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    /**
     * Sorts system properties by key in descending alphabetical order.
     */
    @Test
    public void sortDescendingTest() {
        keysList.sort(Collections.reverseOrder());
        for (Object k : keysList) {
            System.out.println(k + ": " + props.get(k));
        }
    }

    /**
     * Sorts the system properties by the length of the key.
     */
    @Test
    public void sortKeyLengthTest() {
        List<String> strKeyList = new ArrayList<>();
        keysList.forEach(k -> strKeyList.add(k.toString()));
        strKeyList.sort(new comp());

        for (Object k : strKeyList) {
            System.out.println(k + ": " + props.get(k));
        }
    }

    class comp implements Comparator<String> {
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

}
