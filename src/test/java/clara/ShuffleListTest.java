package clara;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShuffleListTest {
    ShuffleList shuffleList = new ShuffleList();

    @Test
    public void shuffleList() {
        List<Object> objects = new ArrayList<>();
        objects.add("Atlanta");
        objects.add("Boston");
        objects.add("Chicago");
        objects.add("New York City");
        objects.add("Orlando");
        assertNotEquals(objects, shuffleList.shuffleList(objects));

        objects.clear();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        assertNotEquals(objects, shuffleList.shuffleList(objects));
    }
}
