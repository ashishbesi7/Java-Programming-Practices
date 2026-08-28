public class TypingSpeedTestAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        int totalCharacters = original.length();

        for (int i = 0; i < totalCharacters; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
            }
        }

        double accuracy =
            (matchedCharacters * 100.0) / totalCharacters;

        System.out.printf(
            "Matched: %d/%d | Accuracy: %.2f%%",
            matchedCharacters,
            totalCharacters,
            accuracy
        );

        if (firstMismatchPosition == -1) {

            System.out.println(" | No Mismatches");

        } else {

            System.out.println(
                " | First Mismatch at position "
                + (firstMismatchPosition + 1)
                + " ('"
                + original.charAt(firstMismatchPosition)
                + "' vs '"
                + typed.charAt(firstMismatchPosition)
                + "')"
            );
        }
    }

    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}