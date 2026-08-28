import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumFrequency =
                new HashMap<>();

        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int number : nums) {

            currentSum += number;

            int requiredSum = currentSum - k;

            if (prefixSumFrequency.containsKey(requiredSum)) {

                count += prefixSumFrequency.get(requiredSum);
            }

            prefixSumFrequency.put(
                currentSum,
                prefixSumFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(
            "Number of Subarrays: " + result
        );
    }
}