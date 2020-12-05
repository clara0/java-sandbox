package clara;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public String pigLatin(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Invalid input: " + sentence);
        }

        String[] words = sentence.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String newWord = word.substring(1) + word.substring(0, 1) + "ay";

            words[i] = newWord;
        }
        return String.join(" ", words);
    }

    public String reverseString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid input: " + str);
        }
        char[] chars = str.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = chars.length - 1, j = 0; i >= 0; i--) {
            reversed[j++] = chars[i];
        }
        return new String(reversed);
    }

    public String switchCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid input: " + str);
        }
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }

        }

        return new String(chars);
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid input: " + str);
        }
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length; i++) {
            if (chars[j--] != chars[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean validBrackets(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid input: " + str);
        }
        List<Character> firstBrackets = new ArrayList<Character>() {{
            add('{');
            add('[');
            add('<');
            add('(');
        }};
        List<Character> lastBrackets = new ArrayList<Character>() {{
            add('}');
            add(']');
            add('>');
            add(')');
        }};
        char[] chars = str.toCharArray();
        List<Character> brackets = new ArrayList<>();

        for (char c : chars) {
            if (firstBrackets.contains(c)) {
                brackets.add(c);
            } else if (lastBrackets.contains(c)) {
                try {
                    char matchingBracket = firstBrackets.get(lastBrackets.indexOf(c));
                    char lastBracket = brackets.remove(brackets.size() - 1);
                    if (matchingBracket != lastBracket) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }

        return brackets.size() == 0;
    }

    public boolean validBrackets1(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid input: " + str);
        }
        char[] chars = str.toCharArray();
        List<Character> brackets = new ArrayList<>();

        for (char c : chars) {
            switch (c) {
                case '{':
                case '[':
                case '<':
                case '(':
                    brackets.add(c);
                    break;
                case '}':
                    if (brackets.remove(brackets.size() - 1) != '{') {
                        return false;
                    }
                    break;
                case '>':
                    if (brackets.remove(brackets.size() - 1) != '<') {
                        return false;
                    }
                    break;
                case ']':
                    if (brackets.remove(brackets.size() - 1) != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (brackets.remove(brackets.size() - 1) != '(') {
                        return false;
                    }
            }
        }
        return brackets.size() == 0;
    }
}
