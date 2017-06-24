package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = dp[j]+1 > dp[i] ? dp[j]+1 : dp[i];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
