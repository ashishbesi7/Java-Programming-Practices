import java.util.Scanner;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        for (int firstIndex = 0;
             firstIndex < nums.length;
             firstIndex++) {

            for (int secondIndex = firstIndex + 1;
                 secondIndex < nums.length;
                 secondIndex++) {

                if (nums[firstIndex] == nums[secondIndex]) {
                    return true;
                }
            }
        }

        return false;
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

        boolean result = containsDuplicate(numbers);

        System.out.println("Contains Duplicate: " + result);

        scanner.close();
    }
}