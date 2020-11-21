package clara;



public class StringUtils {

    public String pigLatin(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Invalid input: " + sentence);
        }

        String[] words = sentence.toLowerCase().split(" ");
        String[] translatedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String newWord = word.substring(1) + word.substring(0, 1) + "ay";

            translatedWords[i] = newWord;
        }
        return String.join(" ", translatedWords);
    }
}
