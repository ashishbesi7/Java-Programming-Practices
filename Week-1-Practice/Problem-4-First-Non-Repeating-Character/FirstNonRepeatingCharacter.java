import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(
            String text) {

        HashMap<Character, Integer> frequency =
                new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            char currentCharacter =
                    text.charAt(i);

            frequency.put(
                    currentCharacter,
                    frequency.getOrDefault(
                            currentCharacter, 0
                    ) + 1
            );
        }

        for (int i = 0; i < text.length(); i++) {

            char currentCharacter =
                    text.charAt(i);

            if (frequency.get(currentCharacter) == 1) {
                return currentCharacter;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        String text = scanner.nextLine();

        char result =
                findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                    "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                    "First Non-Repeating Character: '"
                    + result + "'"
            );
        }

        scanner.close();
    }
}