package HouseRobber;
/**
 * Rob houses along a street.
 * https://leetcode.com/problems/house-robber/
 * The street is a circle
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int num0_0 = nums[1];
        int num1_0 = nums[0];
        int num1_1 = nums[0] + nums[2];
        int num0_1 = nums[2];
        int prevNum0_0 = num0_0;
        int prevNum1_0 = num1_0;
        int prevNum1_1 = num1_1;
        int prevNum0_1 = num0_1;
        for (int i = 3; i < nums.length; i++) {
            prevNum0_0 = num0_0;
            prevNum1_0 = num1_0;
            prevNum1_1 = num1_1;
            prevNum0_1 = num0_1;
            num0_0 = Math.max(prevNum0_0, prevNum0_1);
            num0_1 = prevNum0_0 + nums[i];
            num1_0 = Math.max(prevNum1_0, prevNum1_1);
            num1_1 = prevNum1_0 + nums[i];
        }
        return Math.max(Math.max(num0_1, num1_0), num0_0);
    }
}
