package clara;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GreeterTest {

    @Test
    public void echo() {
        Greeter greeter = new Greeter();
        assertEquals("hello", greeter.echo("hello"));
        assertEquals("123", greeter.echo("123"));
        assertEquals("Hello World!", greeter.echo("Hello World!"));
    }

    @Test
    public void echo2() {
        assertEquals("hello", Greeter.echo2("hello"));
        assertEquals("123", Greeter.echo2("123"));
        assertEquals("Hello World!", Greeter.echo2("Hello World!"));
    }

    @Test
    public void isEven() {
        Greeter greeter = new Greeter();
        int[] oddNumbers = {1, 11111, -1, -1100011};
        int[] evenNumbers = {10, -111112, 0, 2, -2};

        for (int i : oddNumbers) {
            assertFalse(greeter.isEven(i));
        }
        for (int i : evenNumbers) {
            assertTrue(greeter.isEven(i));
        }

    }

    @Test
    public void isPrime() {
        int[] nonprimeNumbers = {12, 27, -12, 1, 0};
        int[] primeNumbers = {3, 2, 7, 11, 29};

        for (int i : nonprimeNumbers) {
            assertFalse(Greeter.isPrime(i));
        }
        for (int i : primeNumbers) {
            assertTrue(Greeter.isPrime(i));
        }
    }

    @Test
    public void sum() {
        Greeter greeter = new Greeter();
        assertEquals(10, greeter.sum(new int[]{1, 2, 3, 4}));
        assertEquals(1, greeter.sum(new int[]{1}));
        assertEquals(2, greeter.sum(new int[]{1, 2, 3, -4}));
        assertEquals(6, greeter.sum(new int[]{1, 2, 3, 0}));

        assertThrows(IllegalArgumentException.class, () -> greeter.sum(new int[]{}));
    }


    @Test
    public void min() {
        Greeter greeter = new Greeter();
        assertEquals(1, greeter.min(new int[]{1, 2, 3, 4}));
        assertEquals(1, greeter.min(new int[]{1, 2, 3, 12345}));
        assertEquals(-4, greeter.min(new int[]{1, 3, 4, -4}));
        assertEquals(0, greeter.min(new int[]{1, 0, 123, 999}));
        assertEquals(-23333, greeter.min(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            greeter.min(new int[]{});
            fail("xxxx");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void max2() {
        Greeter g = new Greeter();
        g.max(new int[]{});
    }

    @Test
    public void max() {
        Greeter greeter = new Greeter();
        assertEquals(4, greeter.max(new int[]{1, 2, 3, 4}));
        assertEquals(12345, greeter.max(new int[]{1, 2, 3, 12345}));
        assertEquals(4, greeter.max(new int[]{1, 3, 4, -4}));
        assertEquals(999, greeter.max(new int[]{1, 0, 123, 999}));
        assertEquals(1239821, greeter.max(new int[]{1, 2131, -23333, 1239821, -23, 0}));
    }

    @Test
    public void recursiveSum() {
        Greeter greeter = new Greeter();
        assertEquals(10, greeter.recursiveSum(new int[]{1, 2, 3, 4}));
        assertEquals(1, greeter.recursiveSum(new int[]{1}));
        assertEquals(2, greeter.recursiveSum(new int[]{1, 2, 3, -4}));
        assertEquals(6, greeter.recursiveSum(new int[]{1, 2, 3, 0}));

        assertThrows(IllegalArgumentException.class, () -> greeter.recursiveSum(new int[]{}));
    }

    @Test
    public void recursiveMin() {
        Greeter greeter = new Greeter();
        assertEquals(1, greeter.recursiveMin(new int[]{1, 2, 3, 4}));
        assertEquals(1, greeter.recursiveMin(new int[]{1, 2, 3, 12345}));
        assertEquals(-4, greeter.recursiveMin(new int[]{1, 3, 4, -4}));
        assertEquals(0, greeter.recursiveMin(new int[]{1, 0, 123, 999}));
        assertEquals(-23333, greeter.recursiveMin(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            greeter.recursiveMin(new int[]{});
            fail("xxxx");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void recursiveMax() {
        Greeter greeter = new Greeter();
        assertEquals(4, greeter.recursiveMax(new int[]{1, 2, 3, 4}));
        assertEquals(12345, greeter.recursiveMax(new int[]{1, 2, 3, 12345}));
        assertEquals(4, greeter.recursiveMax(new int[]{1, 3, 4, -4}));
        assertEquals(999, greeter.recursiveMax(new int[]{1, 0, 123, 999}));
        assertEquals(1239821, greeter.recursiveMax(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            greeter.recursiveMax(new int[]{});
            fail("Please enter an array with at least one element");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void findFactorial() {
        Greeter greeter = new Greeter();
        assertEquals(1, greeter.findFactorial(1));
        assertEquals(2, greeter.findFactorial(2));
        assertEquals(24, greeter.findFactorial(4));
        assertEquals(3628800, greeter.findFactorial(10));
        assertEquals(120, greeter.findFactorial(5));
        assertEquals(1, greeter.findFactorial(0));

        try {
            greeter.findFactorial(-4);
            fail("Please enter a non-negative number");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void recursiveFindFactorial() {
        Greeter greeter = new Greeter();
        assertEquals(1, greeter.recursiveFindFactorial(1));
        assertEquals(2, greeter.recursiveFindFactorial(2));
        assertEquals(24, greeter.recursiveFindFactorial(4));
        assertEquals(3628800, greeter.recursiveFindFactorial(10));
        assertEquals(120, greeter.recursiveFindFactorial(5));
        assertEquals(1, greeter.recursiveFindFactorial(0));

        try {
            greeter.findFactorial(-4);
            fail("Please enter a non-negative number");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void findLongest() {
        Greeter greeter = new Greeter();
        assertEquals("asdfasdf", greeter.findLongest(new String[]{"abc", "", "asdfasdf"}));
        assertEquals("", greeter.findLongest(new String[]{""}));
        assertEquals("hello world", greeter.findLongest(new String[]{"hello world", "hi", "a b c"}));
        assertEquals("asdfasdf", greeter.findLongest(new String[]{"abc", "", "asdfasdf", "123123"}));
        assertEquals("abc", greeter.findLongest(new String[]{"abc", "", " "}));
        assertEquals(" ", greeter.findLongest(new String[]{"", " "}));
    }

    @Test
    public void testFindLongest() {
        Greeter greeter = new Greeter();
        List<String> list = new ArrayList<String>() {{
            add("asdfasdf");
            add("");
            add("   ");
        }};
        assertEquals("asdfasdf", greeter.findLongest(list));
        List<String> list1 = new ArrayList<String>() {{
            add("");
        }};
        assertEquals("", greeter.findLongest(list1));
        List<String> list2 = new ArrayList<String>() {{
            add("hello world");
            add("hi");
            add("a b c");
        }};
        assertEquals("hello world", greeter.findLongest(list2));
        List<String> list3 = new ArrayList<String>() {{
            add("abc");
            add("");
            add("123123");
        }};
        assertEquals("123123", greeter.findLongest(list3));
        List<String> list4 = new ArrayList<String>() {{
            add("");
            add(" ");
        }};
        assertEquals(" ", greeter.findLongest(list4));
    }

    @Test
    public void findFactors() {
        Greeter greeter = new Greeter();
        List<Integer> list = new ArrayList<Integer>() {{
            add(2);
        }};
        assertEquals(list, greeter.findFactors(4));
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        assertEquals(list1, greeter.findFactors(6));
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(2);
            add(3);
            add(5);
            add(6);
            add(10);
            add(15);
        }};
        assertEquals(list2, greeter.findFactors(30));
        List<Integer> list3 = new ArrayList<>();
        assertEquals(list3, greeter.findFactors(17));

        try {
            greeter.findFactors(0);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }
        try {
            greeter.findFactors(-123);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            greeter.findFactors(1);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }

    }
}
