public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversedWord =
                    new StringBuilder(words[i]);

            result.append(reversedWord.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String sentence = "hello club";

        String reversedSentence = reverseEachWord(sentence);

        System.out.println(reversedSentence);
    }
}