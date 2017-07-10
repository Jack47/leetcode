package DynamicProgramming;
/**
 * Rob houses along a street.
 * https://leetcode.com/problems/house-robber/
 * The street is a circle
 */
public class HouseRobberII {
    public int rob(int[] nums, int start, int end) {
        int robMax = nums[start];
        int noRobMax = 0;
        for(int i = start +1; i < end; i++) {
            int t = noRobMax;
            noRobMax = Math.max(robMax, noRobMax);
            robMax = nums[i] + t;
        }
        return Math.max(robMax, noRobMax);
    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }
}
