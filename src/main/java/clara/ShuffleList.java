package clara;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleList {

    public List<Object> shuffleList(List<Object> sortedList) {
        Random random = new Random();
        List<Object> shuffledList = new ArrayList<>();
        for (int ct = 0; ct < sortedList.size(); ct++) {
            int randomIndex = random.nextInt(sortedList.size());
            Object item = sortedList.get(randomIndex);
            shuffledList.add(item);
        }
        return shuffledList;
    }
}
