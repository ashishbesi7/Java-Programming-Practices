import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(
            int[] arr1,
            int[] arr2) {

        int[] mergedArray =
                new int[arr1.length + arr2.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int mergedIndex = 0;

        while (firstIndex < arr1.length
                && secondIndex < arr2.length) {

            if (arr1[firstIndex] <= arr2[secondIndex]) {

                mergedArray[mergedIndex] =
                        arr1[firstIndex];

                firstIndex++;

            } else {

                mergedArray[mergedIndex] =
                        arr2[secondIndex];

                secondIndex++;
            }

            mergedIndex++;
        }

        while (firstIndex < arr1.length) {

            mergedArray[mergedIndex] =
                    arr1[firstIndex];

            firstIndex++;
            mergedIndex++;
        }

        while (secondIndex < arr2.length) {

            mergedArray[mergedIndex] =
                    arr2[secondIndex];

            secondIndex++;
            mergedIndex++;
        }

        return mergedArray;
    }

    public static void printArray(int[] array) {

        System.out.print("Merged Array: [");

        for (int index = 0; index < array.length; index++) {

            System.out.print(array[index]);

            if (index < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static int[] readArray(
            Scanner scanner,
            int size) {

        int[] array = new int[size];

        for (int index = 0; index < size; index++) {
            array[index] = scanner.nextInt();
        }

        return array;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int firstSize = scanner.nextInt();

        System.out.println("Enter first sorted array:");
        int[] firstArray =
                readArray(scanner, firstSize);

        System.out.print("Enter size of second array: ");
        int secondSize = scanner.nextInt();

        System.out.println("Enter second sorted array:");
        int[] secondArray =
                readArray(scanner, secondSize);

        int[] result =
                mergeSortedArrays(firstArray, secondArray);

        printArray(result);

        scanner.close();
    }
}