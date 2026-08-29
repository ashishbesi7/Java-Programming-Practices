import java.util.Scanner;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {

        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {

            for (int secondIndex = firstIndex + 1;
                 secondIndex < nums.length;
                 secondIndex++) {

                if (nums[firstIndex] + nums[secondIndex] == target) {

                    return new int[] {firstIndex, secondIndex};
                }
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int arraySize = scanner.nextInt();

        int[] numbers = new int[arraySize];

        System.out.println("Enter array elements:");

        for (int index = 0; index < arraySize; index++) {
            numbers[index] = scanner.nextInt();
        }

        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int[] result = findTwoSum(numbers, target);

        System.out.println(
                "Indices: [" + result[0] + ", " + result[1] + "]"
        );

        scanner.close();
    }
}