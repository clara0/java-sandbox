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
        int i = random.nextInt(6);
        System.out.printf("Number: %s%n", i);
        switch (i) {
            case 0:
                System.out.println("Grade: Invalid");
                break;
            case 1:
                System.out.println("Grade: F");
                break;
            case 2:
                System.out.println("Grade: D");
                break;
            case 3:
                System.out.println("Grade: C");
                break;
            case 4:
                System.out.println("Grade: B");
                break;
            case 5:
                System.out.println("Grade: A");
                break;
        }
    }
}
