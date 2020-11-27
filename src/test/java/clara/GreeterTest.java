package clara;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GreeterTest {
    Greeter greeter = new Greeter();

    @Test
    public void echo() {
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
    public void findLongest() {
        assertEquals("asdfasdf", greeter.findLongest(new String[]{"abc", "", "asdfasdf"}));
        assertEquals("", greeter.findLongest(new String[]{""}));
        assertEquals("hello world", greeter.findLongest(new String[]{"hello world", "hi", "a b c"}));
        assertEquals("asdfasdf", greeter.findLongest(new String[]{"abc", "", "asdfasdf", "123123"}));
        assertEquals("abc", greeter.findLongest(new String[]{"abc", "", " "}));
        assertEquals(" ", greeter.findLongest(new String[]{"", " "}));
    }

    @Test
    public void testFindLongest() {
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
    public void findUsages() {
        Map<Character, Integer> charCount = new HashMap<>();
        charCount.put('a', 1);
        charCount.put('b', 1);
        charCount.put('c', 1);
        charCount.put('s', 1);
        assertEquals(charCount, greeter.findUsages("cabs"));
        charCount.clear();

        charCount.put('*', 1);
        charCount.put('o', 1);
        charCount.put('w', 2);
        assertEquals(charCount, greeter.findUsages("*wow"));
        charCount.clear();

        charCount.put('h', 2);
        charCount.put('i', 1);
        charCount.put('e', 2);
        charCount.put('t', 1);
        charCount.put('r', 1);
        charCount.put(' ', 1);
        assertEquals(charCount, greeter.findUsages("Hi there"));
        charCount.clear();

        charCount.put('!', 2);
        charCount.put('%', 1);
        charCount.put('(', 2);
        charCount.put('^', 1);
        charCount.put('\\', 1);
        charCount.put('`', 1);
        assertEquals(charCount, greeter.findUsages("!%(^\\`!("));
        charCount.clear();

        charCount.put('\n', 1);
        charCount.put('\t', 1);
        assertEquals(charCount, greeter.findUsages("\t\n"));
        charCount.clear();

        charCount.put('\n', 1);
        assertEquals(charCount, greeter.findUsages("\n"));
        charCount.clear();

        charCount.put('\t', 1);
        assertEquals(charCount, greeter.findUsages("\t"));
        charCount.clear();

        charCount.put('\t', 2);
        charCount.put('\n', 2);
        assertEquals(charCount, greeter.findUsages("\t\n\t\n"));

        charCount.clear();
        assertEquals(charCount, greeter.findUsages(""));

        try {
            greeter.findUsages(null);
            fail("unexpected input: null");
        } catch (IllegalArgumentException e) {
            //expected
        }

    }

    @Test
    public void findCommon() {
        Set<Character> commonChars = new HashSet<>();
        commonChars.add('a');
        commonChars.add('b');
        assertEquals(commonChars, greeter.findCommon("abc", "ba", true));
        commonChars.clear();

        commonChars.add('A');
        commonChars.add('b');
        assertEquals(commonChars, greeter.findCommon("Abc", "bA", false));
        commonChars.clear();

        assertEquals(commonChars, greeter.findCommon("****", "ba", true));
        commonChars.clear();

        commonChars.add(' ');
        assertEquals(commonChars, greeter.findCommon("** **", "b a", true));
        commonChars.clear();

        commonChars.add('*');
        assertEquals(commonChars, greeter.findCommon("**", "*a", false));
        commonChars.clear();

        commonChars.add('\n');
        commonChars.add('\t');
        assertEquals(commonChars, greeter.findCommon("a\nc\t", "b\t\n", false));
        commonChars.clear();

        commonChars.add('!');
        commonChars.add('h');
        commonChars.add('t');
        commonChars.add('e');
        commonChars.add('r');
        commonChars.add(' ');
        commonChars.add('H');
        assertEquals(commonChars, greeter.findCommon("Hi there!", "Hello there!", false));
        commonChars.clear();

        try {
            greeter.findCommon(null, "abc", true);
            fail("unexpected input: null");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            greeter.findCommon(null, null, true);
            fail("unexpected input: null");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            greeter.findCommon(null, "abc", false);
            fail("unexpected input: null");
        } catch (IllegalArgumentException e) {
            //expected
        }

    }
}
