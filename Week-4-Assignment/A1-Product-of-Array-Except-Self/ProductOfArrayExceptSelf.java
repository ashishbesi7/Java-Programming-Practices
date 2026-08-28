public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int leftProduct = 1;

        // Forward pass: store product of elements on the left
        for (int i = 0; i < nums.length; i++) {

            answer[i] = leftProduct;

            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;

        // Backward pass: multiply product of elements on the right
        for (int i = nums.length - 1; i >= 0; i--) {

            answer[i] = answer[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void printArray(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        printArray(result);
    }
}