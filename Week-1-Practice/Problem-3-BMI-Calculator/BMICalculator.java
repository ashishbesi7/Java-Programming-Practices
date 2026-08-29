import java.util.Scanner;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(
            double[] heights, double[] weights) {

        System.out.println();
        System.out.printf(
                "%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height (m)",
                "Weight (kg)", "BMI", "Status"
        );

        System.out.println(
                "--------------------------------------------------------"
        );

        for (int i = 0; i < heights.length; i++) {

            double bmi =
                    weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf(
                    "%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = 2;

        double[] heights =
                new double[numberOfPeople];

        double[] weights =
                new double[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {

            System.out.print(
                    "Enter height for Person "
                    + (i + 1) + " in meters: "
            );

            heights[i] = scanner.nextDouble();

            System.out.print(
                    "Enter weight for Person "
                    + (i + 1) + " in kg: "
            );

            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);

        scanner.close();
    }
}