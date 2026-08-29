import java.util.Scanner;

public class RotateArray {

    public static int[] rotateArray(
            int[] nums,
            int k) {

        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] rotatedArray =
                new int[nums.length];

        for (int index = 0;
             index < nums.length;
             index++) {

            int newPosition =
                    (index + k) % nums.length;

            rotatedArray[newPosition] =
                    nums[index];
        }

        return rotatedArray;
    }

    public static void printArray(int[] array) {

        System.out.print("Rotated Array: [");

        for (int index = 0; index < array.length; index++) {

            System.out.print(array[index]);

            if (index < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
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

        System.out.print("Enter rotation count: ");
        int rotationCount = scanner.nextInt();

        int[] result =
                rotateArray(numbers, rotationCount);

        printArray(result);

        scanner.close();
    }
}