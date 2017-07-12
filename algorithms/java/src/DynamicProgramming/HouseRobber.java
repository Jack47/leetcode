package DynamicProgramming;

/**
 * Rob houses along a street. Limit: can't robber two adjacent houses.
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int dp = nums[0];
        int ndp = 0;
        for (int i = 1; i < nums.length; i++) {
            int preNdp = ndp;
            ndp = dp + 0;
            dp = preNdp + nums[i];
        }
        return Math.max(dp, ndp); // all num is positive, so the ending must be the maximum
    }
}
