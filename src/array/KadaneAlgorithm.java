package array;

public class KadaneAlgorithm {
    public static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(arr));
    }
}