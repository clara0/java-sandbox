package clara;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void pigLatin() {
        StringUtils stringUtils = new StringUtils();
        assertEquals("ihay heretay", stringUtils.pigLatin("hi there"));
        assertEquals("ihay heretay", stringUtils.pigLatin("Hi there"));
        assertEquals("mmmhay", stringUtils.pigLatin("hmmm"));
        assertEquals("", stringUtils.pigLatin(" "));
        assertEquals("ihay here!tay", stringUtils.pigLatin("hi there!"));
        assertEquals("ellohay", stringUtils.pigLatin("hello"));
        assertEquals("ihay here3tay", stringUtils.pigLatin("hi there3"));
        assertEquals("333ay", stringUtils.pigLatin("333"));

        try {
            stringUtils.pigLatin(null);
            fail("Unexpected input" + null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void reverseString() {
        StringUtils stringUtils = new StringUtils();
        assertEquals("ih", stringUtils.reverseString("hi"));
        assertEquals(" ih", stringUtils.reverseString("hi "));
        assertEquals("olleh", stringUtils.reverseString("hello"));
        assertEquals("", stringUtils.reverseString(""));
        assertEquals(" ", stringUtils.reverseString(" "));
        assertEquals("dlrow olleh", stringUtils.reverseString("hello world"));

        try {
            stringUtils.reverseString(null);
            fail("Unexpected input" + null);
        } catch (IllegalArgumentException e) {
            // expected
        }

    }

    @Test
    public void switchCase() {
        StringUtils stringUtils = new StringUtils();
        assertEquals("Hi", stringUtils.switchCase("hI"));
        assertEquals("hI THERE", stringUtils.switchCase("Hi there"));
        assertEquals("oOf", stringUtils.switchCase("OoF"));
        assertEquals("HI", stringUtils.switchCase("hi"));
        assertEquals("", stringUtils.switchCase(""));
        assertEquals(" ", stringUtils.switchCase(" "));

        try {
            stringUtils.switchCase(null);
            fail("Unexpected input" + null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void isPalindrome() {
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertTrue(stringUtils.isPalindrome("abba"));
        assertTrue(stringUtils.isPalindrome("aabaa"));
        assertTrue(stringUtils.isPalindrome(""));
        assertTrue(stringUtils.isPalindrome(" "));
        assertTrue(stringUtils.isPalindrome("a"));
        assertTrue(stringUtils.isPalindrome("aa"));
        assertTrue(stringUtils.isPalindrome("1221"));
        assertTrue(stringUtils.isPalindrome("989"));
        assertFalse(stringUtils.isPalindrome("asdfasdf"));
        assertFalse(stringUtils.isPalindrome("asdfsa"));
        assertFalse(stringUtils.isPalindrome("gah"));
        assertFalse(stringUtils.isPalindrome("123"));

        try {
            stringUtils.switchCase(null);
            fail("Unexpected input" + null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void validBrackets() {
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.validBrackets("{}"));
        assertTrue(stringUtils.validBrackets(""));
        assertTrue(stringUtils.validBrackets(" "));
        assertTrue(stringUtils.validBrackets("{1[2 + 2]}"));
        assertTrue(stringUtils.validBrackets("{12 + 24}"));
        assertTrue(stringUtils.validBrackets("{12 + gh}"));
        assertTrue(stringUtils.validBrackets("(21<12>21)"));
        assertTrue(stringUtils.validBrackets("(21<as>21)"));
        assertTrue(stringUtils.validBrackets("(21<>1 + 21)"));
        assertFalse(stringUtils.validBrackets("(21>1 + 21"));
        assertFalse(stringUtils.validBrackets("(21>1 + 2)1"));
        assertFalse(stringUtils.validBrackets("(21>1 + 2>1"));
        assertFalse(stringUtils.validBrackets("("));
        assertFalse(stringUtils.validBrackets("(a"));

        try {
            stringUtils.switchCase(null);
            fail("Unexpected input" + null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void validBrackets1() {
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.validBrackets1("{}"));
        assertTrue(stringUtils.validBrackets1(""));
        assertTrue(stringUtils.validBrackets1(" "));
        assertTrue(stringUtils.validBrackets1("{1[2 + 2]}"));
        assertTrue(stringUtils.validBrackets1("{12 + 24}"));
        assertTrue(stringUtils.validBrackets1("{12 + gh}"));
        assertTrue(stringUtils.validBrackets1("(21<12>21)"));
        assertTrue(stringUtils.validBrackets1("(21<as>21)"));
        assertTrue(stringUtils.validBrackets1("(21<>1 + 21)"));
        assertFalse(stringUtils.validBrackets1("(21>1 + 21"));
        assertFalse(stringUtils.validBrackets1("(21>1 + 2)1"));
        assertFalse(stringUtils.validBrackets1("(21>1 + 2>1"));
        assertFalse(stringUtils.validBrackets1("("));
        assertFalse(stringUtils.validBrackets1("(a"));

        try {
            stringUtils.switchCase(null);
            fail("Unexpected input" + null);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void listDigits() {
        StringUtils stringUtils = new StringUtils();
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(0);
        assertEquals(digits, stringUtils.listDigits(10));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(0);
        assertEquals(digits, stringUtils.listDigits(100));

        digits.clear();
        digits.add(1);
        digits.add(0);
        digits.add(1);
        digits.add(0);
        assertEquals(digits, stringUtils.listDigits(1010));

        digits.clear();
        digits.add(0);
        assertEquals(digits, stringUtils.listDigits(0));

        digits.clear();
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        digits.add(2);
        assertEquals(digits, stringUtils.listDigits(22222222));

        digits.clear();
        digits.add(1);
        assertEquals(digits, stringUtils.listDigits(1));

        digits.clear();
        digits.add(1);
        assertEquals(digits, stringUtils.listDigits(-1));

        digits.clear();
        digits.add(2);
        digits.add(1);
        assertEquals(digits, stringUtils.listDigits(-21));

    }
}