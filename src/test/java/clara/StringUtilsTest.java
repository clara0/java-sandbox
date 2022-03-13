package clara;

import org.junit.Test;
import clara.util.StringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void pigLatin() {
        assertEquals("ihay heretay", StringUtils.pigLatin("hi there"));
        assertEquals("ihay heretay", StringUtils.pigLatin("Hi there"));
        assertEquals("mmmhay", StringUtils.pigLatin("hmmm"));
        assertEquals("", StringUtils.pigLatin(" "));
        assertEquals("ihay here!tay", StringUtils.pigLatin("hi there!"));
        assertEquals("ellohay", StringUtils.pigLatin("hello"));
        assertEquals("ihay here3tay", StringUtils.pigLatin("hi there3"));
        assertEquals("333ay", StringUtils.pigLatin("333"));

        assertThrows(IllegalArgumentException.class, () -> StringUtils.pigLatin(null));
    }

    @Test
    public void reverseString() {
        assertEquals("ih", StringUtils.reverseString("hi"));
        assertEquals(" ih", StringUtils.reverseString("hi "));
        assertEquals("olleh", StringUtils.reverseString("hello"));
        assertEquals("", StringUtils.reverseString(""));
        assertEquals(" ", StringUtils.reverseString(" "));
        assertEquals("dlrow olleh", StringUtils.reverseString("hello world"));

        assertThrows(IllegalArgumentException.class, () -> StringUtils.reverseString(null));

    }

    @Test
    public void switchCase() {
        assertEquals("Hi", StringUtils.switchCase("hI"));
        assertEquals("hI THERE", StringUtils.switchCase("Hi there"));
        assertEquals("oOf", StringUtils.switchCase("OoF"));
        assertEquals("HI", StringUtils.switchCase("hi"));
        assertEquals("", StringUtils.switchCase(""));
        assertEquals(" ", StringUtils.switchCase(" "));

        assertThrows(IllegalArgumentException.class, () -> StringUtils.switchCase(null));
    }

    @Test
    public void isPalindrome() {
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("abba"));
        assertTrue(StringUtils.isPalindrome("aabaa"));
        assertTrue(StringUtils.isPalindrome(""));
        assertTrue(StringUtils.isPalindrome(" "));
        assertTrue(StringUtils.isPalindrome("a"));
        assertTrue(StringUtils.isPalindrome("aa"));
        assertTrue(StringUtils.isPalindrome("1221"));
        assertTrue(StringUtils.isPalindrome("989"));
        assertFalse(StringUtils.isPalindrome("asdfasdf"));
        assertFalse(StringUtils.isPalindrome("asdfsa"));
        assertFalse(StringUtils.isPalindrome("gah"));
        assertFalse(StringUtils.isPalindrome("123"));

        assertThrows(IllegalArgumentException.class, () -> StringUtils.isPalindrome(null));
    }

    @Test
    public void validBrackets() {
        assertTrue(StringUtils.validBrackets("{}"));
        assertTrue(StringUtils.validBrackets(""));
        assertTrue(StringUtils.validBrackets(" "));
        assertTrue(StringUtils.validBrackets("{1[2 + 2]}"));
        assertTrue(StringUtils.validBrackets("{12 + 24}"));
        assertTrue(StringUtils.validBrackets("{12 + gh}"));
        assertTrue(StringUtils.validBrackets("(21<12>21)"));
        assertTrue(StringUtils.validBrackets("(21<as>21)"));
        assertTrue(StringUtils.validBrackets("(21<>1 + 21)"));
        assertFalse(StringUtils.validBrackets("(21>1 + 21"));
        assertFalse(StringUtils.validBrackets("(21>1 + 2)1"));
        assertFalse(StringUtils.validBrackets("(21>1 + 2>1"));
        assertFalse(StringUtils.validBrackets("("));
        assertFalse(StringUtils.validBrackets("(a"));

        assertThrows(IllegalArgumentException.class, () -> StringUtils.validBrackets(null));
    }

    @Test
    public void validBrackets1() {
        assertTrue(StringUtils.validBrackets1("{}"));
        assertTrue(StringUtils.validBrackets1(""));
        assertTrue(StringUtils.validBrackets1(" "));
        assertTrue(StringUtils.validBrackets1("{1[2 + 2]}"));
        assertTrue(StringUtils.validBrackets1("{12 + 24}"));
        assertTrue(StringUtils.validBrackets1("{12 + gh}"));
        assertTrue(StringUtils.validBrackets1("(21<12>21)"));
        assertTrue(StringUtils.validBrackets1("(21<as>21)"));
        assertTrue(StringUtils.validBrackets1("(21<>1 + 21)"));
        assertFalse(StringUtils.validBrackets1("(21>1 + 21"));
        assertFalse(StringUtils.validBrackets1("(21>1 + 2)1"));
        assertFalse(StringUtils.validBrackets1("(21>1 + 2>1"));
        assertFalse(StringUtils.validBrackets1("("));
        assertFalse(StringUtils.validBrackets1("(a"));

        assertThrows(IllegalArgumentException.class, () -> StringUtils.validBrackets1(null));
    }

    }