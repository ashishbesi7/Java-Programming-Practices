import java.util.Arrays;
import java.util.Scanner;

public class HackathonScoreCurveBooster {

    public static void curveScores(int[] scores, int bonus) {

        for (int index = 0; index < scores.length; index++) {
            scores[index] = scores[index] + bonus;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int numberOfTeams = scanner.nextInt();

        int[] scores = new int[numberOfTeams];

        System.out.println("Enter team scores:");

        for (int index = 0; index < numberOfTeams; index++) {
            scores[index] = scanner.nextInt();
        }

        System.out.print("Enter bonus: ");
        int bonus = scanner.nextInt();

        curveScores(scores, bonus);

        System.out.println(
                "Updated Scores: " + Arrays.toString(scores)
        );

        scanner.close();
    }
}