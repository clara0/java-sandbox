package clara;

import org.junit.Test;

import java.util.Random;

/**
 * Tests {@code switch}.
 */
public class SwitchTest {

    /**
     * Takes a random {@code int} from 0 to 5 (inclusive) and prints out a
     * corresponding grade.
     */
    @Test
    public void findGrade() {
        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            int num = random.nextInt(6);
            System.out.printf("Number: %s%n", num);
            String grade;
            switch (num) {
                case 1:
                    grade = "F";
                    break;
                case 2:
                    grade = "D";
                    break;
                case 3:
                    grade = "C";
                    break;
                case 4:
                    grade = "B";
                    break;
                case 5:
                    grade = "A";
                    break;
                default:
                    grade = "Invalid";
            }
            System.out.printf("Grade: %s%n%n", grade);
        }
    }
}
