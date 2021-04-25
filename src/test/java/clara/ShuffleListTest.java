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
        objects.clear();

        assertEquals(objects, shuffleList.shuffleList(objects));

        objects.add(1);
        assertEquals(objects, shuffleList.shuffleList(objects));
    }

    @Test
    public void shuffleArray() {
        Object[] objectArray = new Object[]{1, 2, 3, 4, 5};
        assertNotEquals(objectArray, shuffleList.shuffleArray(objectArray));

        Object[] objectArray1 = new Object[]{1};
        assertEquals(objectArray1, shuffleList.shuffleArray(objectArray1));

        Object[] objectArray2 = new Object[]{};
        assertEquals(objectArray2, shuffleList.shuffleArray(objectArray2));
    }
}
