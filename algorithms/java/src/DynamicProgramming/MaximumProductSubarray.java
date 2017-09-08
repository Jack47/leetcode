package DynamicProgramming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int t = curMin;
                curMin = curMax;
                curMax = t;
            }
            curMin = Math.min(curMin*nums[i], nums[i]);
            curMax = Math.max(curMax*nums[i], nums[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
