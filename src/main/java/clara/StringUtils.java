package clara;


public class StringUtils {

    public String pigLatin(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Invalid input: " + sentence);
        }

        String[] words = sentence.toLowerCase().split(" ");
        String prevSegment = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String newWord = word.substring(1) + word.substring(0, 1) + "ay";

            if (i == words.length - 1) {
                prevSegment += newWord;
            } else {
                prevSegment += newWord + " ";
            }
        }
        return prevSegment;
    }
}
