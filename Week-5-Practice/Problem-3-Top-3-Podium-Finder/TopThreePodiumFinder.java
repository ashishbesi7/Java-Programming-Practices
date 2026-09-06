import java.util.Arrays;
import java.util.Scanner;

public class TopThreePodiumFinder {

    public static int[] findTopThreeScores(
            int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {

            if (score >= first) {

                third = second;
                second = first;
                first = score;

            } else if (score >= second) {

                third = second;
                second = score;

            } else if (score > third) {

                third = score;
            }
        }

        return new int[] {
                first,
                second,
                third
        };
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int numberOfTeams = scanner.nextInt();

        int[] scores = new int[numberOfTeams];

        System.out.println("Enter scores:");

        for (int index = 0;
             index < numberOfTeams;
             index++) {

            scores[index] = scanner.nextInt();
        }

        int[] topThree =
                findTopThreeScores(scores);

        System.out.println(
                "Top 3 Scores: "
                + Arrays.toString(topThree)
        );

        scanner.close();
    }
}