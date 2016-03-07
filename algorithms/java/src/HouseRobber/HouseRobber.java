package HouseRobber;

/**
 * Rob houses along a street. Limit: can't robber two adjacent houses.
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prevNum0 = 0;
        int prevNum1 = nums[0];
        int num0 = 0;
        int num1 = 0;
        for (int i = 1; i < nums.length; i++) {
            num0 = prevNum0 > prevNum1 ? prevNum0 : prevNum1;
            num1 = prevNum0 + nums[i];
            prevNum0 = num0;
            prevNum1 = num1;
        }
        return prevNum0 > prevNum1 ? prevNum0 : prevNum1;
    }
}
