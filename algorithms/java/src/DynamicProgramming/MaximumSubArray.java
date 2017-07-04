package DynamicProgramming;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int curMax = max;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curMax = Math.max(num, curMax + num); // include pre max or not
            max = Math.max(max, curMax);
        }
        return max;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        if (nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public int maxSubArray(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray(nums, left, mid);
        int rightMax = maxSubArray(nums, mid + 1, right);
        int toLeftMax = nums[mid]; // must have this middle number
        int sum = 0;
        for (int i = mid - 1; i >= left; i--) {
            sum += nums[i];
            toLeftMax = Math.max(sum, toLeftMax);
        }
        int toRightMax = 0; // must have this middle+1 number, so we at least connect left and
        // right side each with one number
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            toRightMax = Math.max(sum, toRightMax);
        }
        return Math.max(Math.max(leftMax, rightMax), toLeftMax + toRightMax);
    }
}
