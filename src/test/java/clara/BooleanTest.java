package clara;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests different ways of getting {@code Boolean} values
 */
@SuppressWarnings({"deprecation", "UnnecessaryBoxing", "BooleanConstructorCall" })
public class BooleanTest {

    /**
     * Compares getting {@code Boolean} values by using {@code Boolean.TRUE}/{@code Boolean.FALSE}
     * and creating a new instance of {@code Boolean} class
     */
    @Ignore("too much output")
    @Test
    public void booleanTest() {
        Boolean b = Boolean.TRUE;
        Boolean b1 = new Boolean(true);
        System.out.printf("Boolean.TRUE:%n value: %s%n hash code: %s%n", b, System.identityHashCode(b));
        System.out.printf("New instance of Boolean:%n value: %s%n Hash code: %s%n", b1, System.identityHashCode(b1));
        System.out.printf("They are the same: %s%n", b == b1);
        System.out.printf("They have the same value: %s%n%n", b.equals(b1));

        Boolean b2 = Boolean.FALSE;
        Boolean b3 = new Boolean(false);
        System.out.printf("Boolean.FALSE:%n value: %s%n hash code: %s%n", b2, System.identityHashCode(b2));
        System.out.printf("New instance of Boolean:%n value: %s%n Hash code: %s%n", b3, System.identityHashCode(b3));
        System.out.printf("They are the same: %s%n", b2 == b3);
        System.out.printf("They have the same value: %s%n%n", b2.equals(b3));
    }

    /**
     * Compares using {@code Boolean.valueOf()}, {@code Boolean.parseBoolean()},
     * and creating a new instance of {@code Boolean} class
     */
    @Ignore("too much output")
    @Test
    @SuppressWarnings("all")
    public void strToBooleanTest() {
        Boolean b = Boolean.valueOf("true");
        boolean b1 = Boolean.parseBoolean("true");
        Boolean b2 = new Boolean("true");
        System.out.printf("valueOf:%n value: %s%n hash code: %s%n", b, System.identityHashCode(b));
        System.out.printf("parseBoolean:%n value: %s%n Hash code: %s%n", b1, System.identityHashCode(b1));
        System.out.printf("They are the same: %s%n", b == b1);
        System.out.printf("They have the same value: %s%n%n", b.equals(b1));

        System.out.printf("valueOf:%n value: %s%n hash code: %s%n", b, System.identityHashCode(b));
        System.out.printf("new instance:%n value: %s%n Hash code: %s%n", b2, System.identityHashCode(b2));
        System.out.printf("They are the same: %s%n", b == b2);
        System.out.printf("They have the same value: %s%n%n", b.equals(b2));

        Boolean b3 = Boolean.valueOf("false");
        boolean b4 = Boolean.parseBoolean("false");
        Boolean b5 = new Boolean(false);
        System.out.printf("valueOf:%n value: %s%n hash code: %s%n", b3, System.identityHashCode(b3));
        System.out.printf("parseBoolean:%n value: %s%n Hash code: %s%n", b4, System.identityHashCode(b4));
        System.out.printf("They are the same: %s%n", b3 == b4);
        System.out.printf("They have the same value: %s%n%n", b.equals(b3));

        System.out.printf("valueOf:%n value: %s%n hash code: %s%n", b3, System.identityHashCode(b3));
        System.out.printf("new instance:%n value: %s%n Hash code: %s%n", b5, System.identityHashCode(b5));
        System.out.printf("They are the same: %s%n", b3 == b5);
        System.out.printf("They have the same value: %s%n%n", b3.equals(b5));
    }
}
