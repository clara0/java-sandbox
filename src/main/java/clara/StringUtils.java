package clara;



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
        for (int i = 0; i < chars.length; i++) {
            reversed[chars.length - 1 - i] = chars[i];
        }
        return new String(reversed);
    }
}
