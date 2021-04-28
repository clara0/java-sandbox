package clara;

import java.util.*;

public class ShuffleList {

    public List<Object> shuffleList(List<Object> sortedList) {
        Object[] shuffledArray = shuffleArray(sortedList.toArray());
        return Arrays.asList(shuffledArray);
    }

    public Object[] shuffleArray(Object[] sortedArray) {
        Random random = new Random();
        List<Object> sortedList = new ArrayList<>(Arrays.asList(sortedArray).subList(0, sortedArray.length));
        if (sortedList.size() <= 1) {
            return sortedList.toArray();
        }
        List<Object> shuffledList = new ArrayList<>();
        while (sortedList.size() != 0) {
            int randomIndex = random.nextInt(sortedList.size());
            Object item = sortedList.get(randomIndex);
            sortedList.remove(randomIndex);
            shuffledList.add(item);
        }
        return shuffledList.toArray();
    }
}
