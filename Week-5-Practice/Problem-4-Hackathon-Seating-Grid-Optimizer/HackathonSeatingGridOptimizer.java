import java.util.Scanner;

public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {

        if (row.length == 0) {
            return 0;
        }

        int total = 0;

        for (int score : row) {
            total += score;
        }

        return (double) total / row.length;
    }

    public static String classifyRows(
            int[][] seatingScores,
            int threshold) {

        StringBuilder result = new StringBuilder();

        for (int rowIndex = 0;
             rowIndex < seatingScores.length;
             rowIndex++) {

            double average =
                    rowAverage(seatingScores[rowIndex]);

            if (average < threshold) {

                result.append("Row ")
                      .append(rowIndex)
                      .append(": Quiet Zone");

            } else {

                result.append("Row ")
                      .append(rowIndex)
                      .append(": Buzzing Zone");
            }

            if (rowIndex < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numberOfRows = scanner.nextInt();

        int[][] seatingScores =
                new int[numberOfRows][];

        for (int rowIndex = 0;
             rowIndex < numberOfRows;
             rowIndex++) {

            System.out.print(
                    "Enter number of scores in row "
                    + rowIndex + ": "
            );

            int numberOfScores = scanner.nextInt();

            seatingScores[rowIndex] =
                    new int[numberOfScores];

            System.out.println(
                    "Enter scores for row "
                    + rowIndex + ":"
            );

            for (int columnIndex = 0;
                 columnIndex < numberOfScores;
                 columnIndex++) {

                seatingScores[rowIndex][columnIndex] =
                        scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        String result =
                classifyRows(seatingScores, threshold);

        System.out.println(result);

        scanner.close();
    }
}