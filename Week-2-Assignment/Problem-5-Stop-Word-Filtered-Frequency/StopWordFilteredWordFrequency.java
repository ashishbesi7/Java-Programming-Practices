import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilteredWordFrequency {

    public static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        HashMap<String, Integer> wordFrequency =
                new HashMap<>();

        for (String word : words) {

            if (isStopWord(word, stopWords)) {
                continue;
            }

            int currentCount =
                    wordFrequency.getOrDefault(word, 0);

            wordFrequency.put(word, currentCount + 1);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(wordFrequency.entrySet());

        entries.sort(
                (entry1, entry2) ->
                        entry2.getValue()
                        - entry1.getValue()
        );

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static boolean isStopWord(
            String word, String[] stopWords) {

        for (String stopWord : stopWords) {

            if (word.equals(stopWord)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}