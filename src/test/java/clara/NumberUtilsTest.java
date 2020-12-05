package clara;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumberUtilsTest {
    NumberUtils numberUtils = new NumberUtils();

    @Test
    public void isEven() {
        int[] oddNumbers = {1, 11111, -1, -1100011};
        int[] evenNumbers = {10, -111112, 0, 2, -2};

        for (int i : oddNumbers) {
            assertFalse(numberUtils.isEven(i));
        }
        for (int i : evenNumbers) {
            assertTrue(numberUtils.isEven(i));
        }

    }

    @Test
    public void isPrime() {
        int[] nonprimeNumbers = {12, 27, -12, 1, 0};
        int[] primeNumbers = {3, 2, 7, 11, 29};

        for (int i : nonprimeNumbers) {
            assertFalse(NumberUtils.isPrime(i));
        }
        for (int i : primeNumbers) {
            assertTrue(NumberUtils.isPrime(i));
        }
    }

    @Test
    public void sum() {
        assertEquals(10, numberUtils.sum(new int[]{1, 2, 3, 4}));
        assertEquals(1, numberUtils.sum(new int[]{1}));
        assertEquals(2, numberUtils.sum(new int[]{1, 2, 3, -4}));
        assertEquals(6, numberUtils.sum(new int[]{1, 2, 3, 0}));

        assertThrows(IllegalArgumentException.class, () -> numberUtils.sum(new int[]{}));
    }


    @Test
    public void min() {
        assertEquals(1, numberUtils.min(new int[]{1, 2, 3, 4}));
        assertEquals(1, numberUtils.min(new int[]{1, 2, 3, 12345}));
        assertEquals(-4, numberUtils.min(new int[]{1, 3, 4, -4}));
        assertEquals(0, numberUtils.min(new int[]{1, 0, 123, 999}));
        assertEquals(-23333, numberUtils.min(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            numberUtils.min(new int[]{});
            fail("xxxx");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void max2() {
        numberUtils.max(new int[]{});
    }

    @Test
    public void max() {
        assertEquals(4, numberUtils.max(new int[]{1, 2, 3, 4}));
        assertEquals(12345, numberUtils.max(new int[]{1, 2, 3, 12345}));
        assertEquals(4, numberUtils.max(new int[]{1, 3, 4, -4}));
        assertEquals(999, numberUtils.max(new int[]{1, 0, 123, 999}));
        assertEquals(1239821, numberUtils.max(new int[]{1, 2131, -23333, 1239821, -23, 0}));
    }

    @Test
    public void recursiveSum() {
        assertEquals(10, numberUtils.recursiveSum(new int[]{1, 2, 3, 4}));
        assertEquals(1, numberUtils.recursiveSum(new int[]{1}));
        assertEquals(2, numberUtils.recursiveSum(new int[]{1, 2, 3, -4}));
        assertEquals(6, numberUtils.recursiveSum(new int[]{1, 2, 3, 0}));

        assertThrows(IllegalArgumentException.class, () -> numberUtils.recursiveSum(new int[]{}));
    }

    @Test
    public void recursiveMin() {
        assertEquals(1, numberUtils.recursiveMin(new int[]{1, 2, 3, 4}));
        assertEquals(1, numberUtils.recursiveMin(new int[]{1, 2, 3, 12345}));
        assertEquals(-4, numberUtils.recursiveMin(new int[]{1, 3, 4, -4}));
        assertEquals(0, numberUtils.recursiveMin(new int[]{1, 0, 123, 999}));
        assertEquals(-23333, numberUtils.recursiveMin(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            numberUtils.recursiveMin(new int[]{});
            fail("xxxx");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void recursiveMax() {
        assertEquals(4, numberUtils.recursiveMax(new int[]{1, 2, 3, 4}));
        assertEquals(12345, numberUtils.recursiveMax(new int[]{1, 2, 3, 12345}));
        assertEquals(4, numberUtils.recursiveMax(new int[]{1, 3, 4, -4}));
        assertEquals(999, numberUtils.recursiveMax(new int[]{1, 0, 123, 999}));
        assertEquals(1239821, numberUtils.recursiveMax(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            numberUtils.recursiveMax(new int[]{});
            fail("Please enter an array with at least one element");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void findFactorial() {
        assertEquals(1, numberUtils.findFactorial(1));
        assertEquals(2, numberUtils.findFactorial(2));
        assertEquals(24, numberUtils.findFactorial(4));
        assertEquals(3628800, numberUtils.findFactorial(10));
        assertEquals(120, numberUtils.findFactorial(5));
        assertEquals(1, numberUtils.findFactorial(0));

        try {
            numberUtils.findFactorial(-4);
            fail("Please enter a non-negative number");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void recursiveFindFactorial() {
        assertEquals(1, numberUtils.recursiveFindFactorial(1));
        assertEquals(2, numberUtils.recursiveFindFactorial(2));
        assertEquals(24, numberUtils.recursiveFindFactorial(4));
        assertEquals(3628800, numberUtils.recursiveFindFactorial(10));
        assertEquals(120, numberUtils.recursiveFindFactorial(5));
        assertEquals(1, numberUtils.recursiveFindFactorial(0));

        try {
            numberUtils.findFactorial(-4);
            fail("Please enter a non-negative number");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void findFactors() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(2);
        }};
        assertEquals(list, numberUtils.findFactors(4));
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        assertEquals(list1, numberUtils.findFactors(6));
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(2);
            add(3);
            add(5);
            add(6);
            add(10);
            add(15);
        }};
        assertEquals(list2, numberUtils.findFactors(30));
        List<Integer> list3 = new ArrayList<>();
        assertEquals(list3, numberUtils.findFactors(17));

        try {
            numberUtils.findFactors(0);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }
        try {
            numberUtils.findFactors(-123);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            numberUtils.findFactors(1);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }

    }

    @Test
    public void listDigits() {
        NumberUtils numberUtils = new NumberUtils();
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(10));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(100));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(1);
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(1010));

        digits.clear();
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(0));

        digits.clear();
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        assertEquals(digits, numberUtils.listDigits(22222222));

        digits.clear();
        digits.add(1);
        assertEquals(digits, numberUtils.listDigits(1));

        digits.clear();
        digits.add(1);
        assertEquals(digits, numberUtils.listDigits(-1));

        digits.clear();
        digits.add(2);
        digits.add(1);
        assertEquals(digits, numberUtils.listDigits(-21));

    }

    @Test
    public void listDigits1() {
        NumberUtils numberUtils = new NumberUtils();
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(10));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(100));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(1);
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(1010));

        digits.clear();
        digits.add(0);
        assertEquals(digits, numberUtils.listDigits(0));

        digits.clear();
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        assertEquals(digits, numberUtils.listDigits(22222222));

        digits.clear();
        digits.add(1);
        assertEquals(digits, numberUtils.listDigits(1));

        digits.clear();
        digits.add(1);
        assertEquals(digits, numberUtils.listDigits(-1));

        digits.clear();
        digits.add(2);
        digits.add(1);
        assertEquals(digits, numberUtils.listDigits(-21));

    }

}