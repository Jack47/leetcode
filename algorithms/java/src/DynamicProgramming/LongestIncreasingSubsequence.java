package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLISoN2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            int pos = Arrays.binarySearch(dp, 0, maxLen, nums[i]);
            if (pos < 0) {
                pos = -1 - pos;
            }
            dp[pos] = nums[i]; // len: pos+1, new lowest element appeared
            if (pos + 1 > maxLen) { //
                maxLen = pos + 1;
            }
        }
        return maxLen;
    }
}
