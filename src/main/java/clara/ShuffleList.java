package clara;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShuffleList {

    public List<Object> shuffleList(List<Object> sortedList) {
        Random random = new Random();
        if (sortedList.size() <= 1) {
            return sortedList;
        }
        Object[] shuffledArray = new Object[sortedList.size()];
        Set<Object> filledIndexes = new HashSet<>();
        for (Object item: sortedList) {
            int randIndex = random.nextInt(sortedList.size());
            while (filledIndexes.contains(randIndex)) {
                randIndex = random.nextInt(sortedList.size());
            }
            shuffledArray[randIndex] = item;
            filledIndexes.add(randIndex);
        }
        List<Object> shuffledList = Arrays.asList(shuffledArray).subList(0, shuffledArray.length);
        if (shuffledList.equals(sortedList)) {
            shuffleList(sortedList);
        }
        return shuffledList;
    }

    public Object[] shuffleArray(Object[] sortedArray) {
        List<Object> shuffledList = shuffleList(Arrays.asList(sortedArray).subList(0, sortedArray.length));
        return shuffledList.toArray();
    }
}
