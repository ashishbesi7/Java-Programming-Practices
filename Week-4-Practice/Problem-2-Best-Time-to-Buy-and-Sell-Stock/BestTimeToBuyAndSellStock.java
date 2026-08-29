import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int day = 1; day < prices.length; day++) {

            int currentProfit =
                    prices[day] - minimumPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }

            if (prices[day] < minimumPrice) {
                minimumPrice = prices[day];
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int numberOfDays = scanner.nextInt();

        int[] prices = new int[numberOfDays];

        System.out.println("Enter stock prices:");

        for (int day = 0; day < numberOfDays; day++) {
            prices[day] = scanner.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);

        scanner.close();
    }
}