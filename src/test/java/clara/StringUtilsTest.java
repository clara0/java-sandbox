package clara;

import org.junit.Test;

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
}