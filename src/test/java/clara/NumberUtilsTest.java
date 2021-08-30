package clara;

import org.junit.Test;
import clara.util.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void isEven() {
        int[] oddNumbers = {1, 11111, -1, -1100011};
        int[] evenNumbers = {10, -111112, 0, 2, -2};

        for (int i : oddNumbers) {
            assertFalse(NumberUtils.isEven(i));
        }
        for (int i : evenNumbers) {
            assertTrue(NumberUtils.isEven(i));
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
        assertEquals(10, NumberUtils.sum(new int[]{1, 2, 3, 4}));
        assertEquals(1, NumberUtils.sum(new int[]{1}));
        assertEquals(2, NumberUtils.sum(new int[]{1, 2, 3, -4}));
        assertEquals(6, NumberUtils.sum(new int[]{1, 2, 3, 0}));

        assertThrows(IllegalArgumentException.class, () -> NumberUtils.sum(new int[]{}));
    }


    @Test
    public void min() {
        assertEquals(1, NumberUtils.min(new int[]{1, 2, 3, 4}));
        assertEquals(1, NumberUtils.min(new int[]{1, 2, 3, 12345}));
        assertEquals(-4, NumberUtils.min(new int[]{1, 3, 4, -4}));
        assertEquals(0, NumberUtils.min(new int[]{1, 0, 123, 999}));
        assertEquals(-23333, NumberUtils.min(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            NumberUtils.min(new int[]{});
            fail("xxxx");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void max2() {
        NumberUtils.max(new int[]{});
    }

    @Test
    public void max() {
        assertEquals(4, NumberUtils.max(new int[]{1, 2, 3, 4}));
        assertEquals(12345, NumberUtils.max(new int[]{1, 2, 3, 12345}));
        assertEquals(4, NumberUtils.max(new int[]{1, 3, 4, -4}));
        assertEquals(999, NumberUtils.max(new int[]{1, 0, 123, 999}));
        assertEquals(1239821, NumberUtils.max(new int[]{1, 2131, -23333, 1239821, -23, 0}));
    }

    @Test
    public void recursiveSum() {
        assertEquals(10, NumberUtils.recursiveSum(new int[]{1, 2, 3, 4}));
        assertEquals(1, NumberUtils.recursiveSum(new int[]{1}));
        assertEquals(2, NumberUtils.recursiveSum(new int[]{1, 2, 3, -4}));
        assertEquals(6, NumberUtils.recursiveSum(new int[]{1, 2, 3, 0}));

        assertThrows(IllegalArgumentException.class, () -> NumberUtils.recursiveSum(new int[]{}));
    }

    @Test
    public void recursiveMin() {
        assertEquals(1, NumberUtils.recursiveMin(new int[]{1, 2, 3, 4}));
        assertEquals(1, NumberUtils.recursiveMin(new int[]{1, 2, 3, 12345}));
        assertEquals(-4, NumberUtils.recursiveMin(new int[]{1, 3, 4, -4}));
        assertEquals(0, NumberUtils.recursiveMin(new int[]{1, 0, 123, 999}));
        assertEquals(-23333, NumberUtils.recursiveMin(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            NumberUtils.recursiveMin(new int[]{});
            fail("xxxx");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void recursiveMax() {
        assertEquals(4, NumberUtils.recursiveMax(new int[]{1, 2, 3, 4}));
        assertEquals(12345, NumberUtils.recursiveMax(new int[]{1, 2, 3, 12345}));
        assertEquals(4, NumberUtils.recursiveMax(new int[]{1, 3, 4, -4}));
        assertEquals(999, NumberUtils.recursiveMax(new int[]{1, 0, 123, 999}));
        assertEquals(1239821, NumberUtils.recursiveMax(new int[]{1, 2131, -23333, 1239821, -23, 0}));

        try {
            NumberUtils.recursiveMax(new int[]{});
            fail("Please enter an array with at least one element");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void findFactorial() {
        assertEquals(1, NumberUtils.findFactorial(1));
        assertEquals(2, NumberUtils.findFactorial(2));
        assertEquals(24, NumberUtils.findFactorial(4));
        assertEquals(3628800, NumberUtils.findFactorial(10));
        assertEquals(120, NumberUtils.findFactorial(5));
        assertEquals(1, NumberUtils.findFactorial(0));

        try {
            NumberUtils.findFactorial(-4);
            fail("Please enter a non-negative number");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void recursiveFindFactorial() {
        assertEquals(1, NumberUtils.recursiveFindFactorial(1));
        assertEquals(2, NumberUtils.recursiveFindFactorial(2));
        assertEquals(24, NumberUtils.recursiveFindFactorial(4));
        assertEquals(3628800, NumberUtils.recursiveFindFactorial(10));
        assertEquals(120, NumberUtils.recursiveFindFactorial(5));
        assertEquals(1, NumberUtils.recursiveFindFactorial(0));

        try {
            NumberUtils.findFactorial(-4);
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
        assertEquals(list, NumberUtils.findFactors(4));
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        assertEquals(list1, NumberUtils.findFactors(6));
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(2);
            add(3);
            add(5);
            add(6);
            add(10);
            add(15);
        }};
        assertEquals(list2, NumberUtils.findFactors(30));
        List<Integer> list3 = new ArrayList<>();
        assertEquals(list3, NumberUtils.findFactors(17));

        try {
            NumberUtils.findFactors(0);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }
        try {
            NumberUtils.findFactors(-123);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            NumberUtils.findFactors(1);
            fail("Please enter a positive, non-one number");
        } catch (IllegalArgumentException e) {
            //expected
        }

    }

    @Test
    public void listDigits() {
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits(10));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits(100));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(1);
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits(1010));

        digits.clear();
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits(0));

        digits.clear();
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        assertEquals(digits, NumberUtils.listDigits(22222222));

        digits.clear();
        digits.add(1);
        assertEquals(digits, NumberUtils.listDigits(1));

        digits.clear();
        digits.add(1);
        assertEquals(digits, NumberUtils.listDigits(-1));

        digits.clear();
        digits.add(2);
        digits.add(1);
        assertEquals(digits, NumberUtils.listDigits(-21));

    }

    @Test
    public void listDigits1() {
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits1(10));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits1(100));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(1);
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits1(1010));

        digits.clear();
        digits.add(0);
        assertEquals(digits, NumberUtils.listDigits1(0));

        digits.clear();
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        assertEquals(digits, NumberUtils.listDigits1(22222222));

        digits.clear();
        digits.add(1);
        assertEquals(digits, NumberUtils.listDigits1(1));

        digits.clear();
        digits.add(1);
        assertEquals(digits, NumberUtils.listDigits1(-1));

        digits.clear();
        digits.add(2);
        digits.add(1);
        assertEquals(digits, NumberUtils.listDigits1(-21));

    }

    @Test
    public void reverseList() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        list1.add(1);
        list1.add(0);
        result.add(0);
        result.add(1);
        assertEquals(result, NumberUtils.reverseList(list1));

        list1.clear();
        result.clear();
        list1.add(1);
        list1.add(2);
        result.add(2);
        result.add(1);
        assertEquals(result, NumberUtils.reverseList(list1));

        list1.clear();
        result.clear();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        result.add(5);
        result.add(4);
        result.add(3);
        result.add(2);
        result.add(1);
        assertEquals(result, NumberUtils.reverseList(list1));

        list1.clear();
        result.clear();
        assertEquals(result, NumberUtils.reverseList(list1));

        list1.clear();
        result.clear();
        list1.add(1);
        result.add(1);
        assertEquals(result, NumberUtils.reverseList(list1));

        list1.clear();
        result.clear();
        list1.add(-1);
        list1.add(2);
        result.add(2);
        result.add(-1);
        assertEquals(result, NumberUtils.reverseList(list1));
    }

    @Test
    public void findTwinPrimes() {
        List<Integer> twinPrime = new ArrayList<>(Arrays.asList(3, 5));
        List<Integer> twinPrime1 = new ArrayList<>(Arrays.asList(5, 7));
        List<List<Integer>> twinPrimes = new ArrayList<>(Arrays.asList(twinPrime, twinPrime1));
        assertEquals(twinPrimes, NumberUtils.findTwinPrimes(10));

        List<Integer> twinPrime2 = new ArrayList<>(Arrays.asList(11, 13));
        List<Integer> twinPrime3 = new ArrayList<>(Arrays.asList(17, 19));
        twinPrimes.add(twinPrime2);
        twinPrimes.add(twinPrime3);
        assertEquals(twinPrimes, NumberUtils.findTwinPrimes(20));
    }
}