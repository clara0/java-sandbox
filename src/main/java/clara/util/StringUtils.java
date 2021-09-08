package clara.util;

import clara.EmailAddress;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class StringUtils {
    private StringUtils() {}

    @SuppressWarnings("all")
    public static String pigLatin(@NotNull String sentence) {
        String[] words = sentence.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String newWord = word.substring(1) + word.substring(0, 1) + "ay";

            words[i] = newWord;
        }
        return String.join(" ", words);
    }

    public static String reverseString(@NotNull String str) {
        char[] chars = str.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = chars.length - 1, j = 0; i >= 0; i--) {
            reversed[j++] = chars[i];
        }
        return new String(reversed);
    }

    public static String switchCase(@NotNull String str) {
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

    public static boolean isPalindrome(@NotNull String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length; i++) {
            if (chars[j--] != chars[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean validBrackets(@NotNull String str) {
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

    public static boolean validBrackets1(@NotNull String str) {
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

    public static List<String> getUsernames(List<EmailAddress> emails) {
        return emails.stream().map(EmailAddress::getUsername).collect(Collectors.toList());
    }

    public static List<String> sortUsernames(List<EmailAddress> emails) {
        return emails.stream().map(EmailAddress::getUsername).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<String> filterUsernames(List<EmailAddress> emails) {
        return emails.stream().map(EmailAddress::getDomain).filter(domain -> domain.startsWith("g")).collect(Collectors.toList());
    }
}
