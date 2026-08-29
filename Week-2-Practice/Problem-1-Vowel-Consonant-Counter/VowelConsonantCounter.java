import java.util.Scanner;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {

            char currentCharacter =
                    Character.toLowerCase(text.charAt(i));

            if (currentCharacter == 'a'
                    || currentCharacter == 'e'
                    || currentCharacter == 'i'
                    || currentCharacter == 'o'
                    || currentCharacter == 'u') {

                vowelCount++;

            } else if (currentCharacter != ' ') {

                consonantCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a title: ");

        String text = scanner.nextLine();

        countVowelsAndConsonants(text);

        scanner.close();
    }
}