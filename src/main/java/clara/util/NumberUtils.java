package clara.util;

import clara.InvalidDateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NumberUtils {

    private NumberUtils() {}

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int n = 2; n < num; n++) {
            if (num % n == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sum(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        int numSum = 0;
        for (int i: nums) {
            numSum += i;
        }
        return numSum;
    }

    public static int min(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        int currentMin = nums[0];
        for (int i: nums) {
            if (i < currentMin) {
                currentMin = i;
            }
        }
        return currentMin;
    }

    public static int max(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        int currentMax = nums[0];
        for (int i: nums) {
            if (i > currentMax) {
                currentMax = i;
            }
        }
        return currentMax;
    }

    public static int recursiveSum(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int lastItem = nums[nums.length - 1];
        int[] newArray = new int[nums.length - 1];
        System.arraycopy(nums, 0, newArray, 0, nums.length - 1);

        return lastItem + recursiveSum(newArray);

    }

    public static int recursiveMin(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int lastItem = nums[nums.length - 1];
        int[] newArray = new int[nums.length - 1];
        System.arraycopy(nums, 0, newArray, 0, nums.length - 1);

        int result = recursiveMin(newArray);

        return Math.min(lastItem, result);

    }

    public static int recursiveMax(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int lastItem = nums[nums.length - 1];
        int[] newArray = new int[nums.length - 1];
        System.arraycopy(nums, 0, newArray, 0, nums.length - 1);

        int result = recursiveMax(newArray);

        return Math.max(lastItem, result);

    }

    public static int findFactorial(int num) {

        int currentProduct = 1;
        if (num < 0) {
            throw new IllegalArgumentException("Please enter a non-negative number");
        }
        for (int i = 1; i <= num; i++) {
            currentProduct = currentProduct * i;
        }

        return currentProduct;
    }

    public static int recursiveFindFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Please enter a non-negative number");
        }
        if (num == 0 || num == 1) {
            return 1;
        }

        int oneLess = num - 1;
        return num * recursiveFindFactorial(oneLess);
    }

    public static List<Integer> findFactors(int num) {
        if (num < 2) {
            throw new IllegalArgumentException("Please enter an integer greater than 1");
        }
        List<Integer> factorlist = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                factorlist.add(i);
            }
        }
        return factorlist;
    }

    public static List<Integer> listDigits(int num) {
        num = Math.abs(num);
        if (num < 10) {
            List<Integer> digit = new ArrayList<>();
            digit.add(num);
            return digit;
        }
        int lastDigit = num % 10;
        int newNum = Math.floorDiv(num, 10);
        List<Integer> digits = listDigits(newNum);
        digits.add(lastDigit);
        return digits;
    }

    public static List<Integer> listDigits1(int num) {
        num = Math.abs(num);
        List<Integer> digits = new ArrayList<>();
        while (num >= 10) {
            int lastDigit = num % 10;
            digits.add(lastDigit);
            num = num / 10;
        }
        digits.add(num);
        return reverseList(digits);
    }

    public static List<Integer> reverseList(List<Integer> list1){
        List<Integer> reversedList = new ArrayList<>();
        for (int i = list1.size() - 1; i >= 0; i--) {
            reversedList.add(list1.get(i));
        }

        return reversedList;
    }

    public static float findPercent(int part, int whole) {
        return (float) part / whole * 100;
    }

    public static List<List<Integer>> findTwinPrimes(int maxNum){
        List<List<Integer>> twinPrimes = new ArrayList<>();
        for (int i = 1; i <= maxNum; i++) {
            if (isPrime(i) && i != maxNum) {
                int nextNum = i + 2;
                if (isPrime(nextNum)) {
                    twinPrimes.add(new ArrayList<>(Arrays.asList(i, nextNum)));
                }
            }
        }
        return twinPrimes;
    }

    /**
     * Finds the number of days in a certain month of a certain year.
     *
     * @param year  any year
     * @param month  any month
     * @return number of days in the month of the year
     * @throws InvalidDateException if {@code year} is negative or {@code month}
     * is smaller than one or larger than 12.
     */

    public static int countDaysInMonth(int year, int month) throws InvalidDateException {
        if (month > 12 || month < 1) {
            throw new InvalidDateException();
        }
        if (year < 0) {
            throw new InvalidDateException("input: " + year + " non-negative int expected");
        }
        int days;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                } else if (year % 4 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                days = 31;
                break;
        }

        return days;
    }

}
