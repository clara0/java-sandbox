package clara;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Tests {@code switch}.
 */
public class SwitchTest {

    /**
     * Takes a random {@code int} from 0 to 5 (inclusive) and prints out a
     * corresponding grade using {@code switch}.
     * <p>
     * Key:
     * <ol>
     *     <li>F</li>
     *     <li>D</li>
     *     <li>C</li>
     *     <li>B</li>
     *     <li>A</li>
     * </ol>
     * </p>
     */
    @Test
    public void findGrade() {
        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            int num = random.nextInt(6);
            System.out.printf("Number: %s%n", num);
            char grade = switch (num) {
                case 1 -> 'F';
                case 2 -> 'D';
                case 3 -> 'C';
                case 4 -> 'B';
                case 5 -> 'A';
                default -> 'X';
            };
            System.out.printf("Grade: %c%n%n", grade);
        }
    }

    /**
     * Takes a random {@code int} from 0 to 5 (inclusive) and prints out a
     * corresponding grade using map.
     *
     * @see SwitchTest#findGrade()
     */
    @Test
    public void findGradeMap() {
        Random random = new Random();

        Map<Integer, Character> gradeMap = new HashMap<>();
        gradeMap.put(1, 'F');
        gradeMap.put(2, 'D');
        gradeMap.put(3, 'C');
        gradeMap.put(4, 'B');
        gradeMap.put(5, 'A');

        for (int i = 1; i <= 20; i++) {
            int num = random.nextInt(6);
            System.out.printf("Number: %s%n", num);

            Character grade;
            grade = gradeMap.getOrDefault(num, 'X');
            System.out.printf("Grade: %c%n%n", grade);
        }
    }
}
