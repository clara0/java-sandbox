package clara;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Greeter {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            System.out.println(i + " Hello");
        }

    }

    public String echo(String msg) {
        return msg;
    }

    public static String echo2(String msg) {
        return msg;
    }

    public String findLongest(String[] strs) {
        String longest = "";

        for (String str: strs) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }

    public String findLongest(List<String> strs) {
        String longest = "";

        for (String str: strs) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }

    public Map<Character, Integer> findUsages(@NotNull String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        char[] chars = str.toLowerCase().toCharArray();
        for (char c: chars) {
            if (charCount.containsKey(c)) {
                charCount.replace(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        return charCount;
    }

    public Set<Character> findCommon(@NotNull String str1, @NotNull String str2, boolean ignoreCase) {
        Set<Character> commonChars = new HashSet<>();
        if (ignoreCase) {
            char[] chars1 = str1.toLowerCase().toCharArray();
            char[] chars2 = str2.toLowerCase().toCharArray();
            for (char c1 : chars1) {
                for (char c2 : chars2) {
                    if (c1 == c2) {
                        commonChars.add(c1);
                    }
                }
            }
        } else {
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            for (char c1 : chars1) {
                for (char c2 : chars2) {
                    if (c1 == c2) {
                        commonChars.add(c1);
                    }
                }
            }
        }
        return commonChars;
    }

}
