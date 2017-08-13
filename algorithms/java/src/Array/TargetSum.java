package Array;

public class TargetSum {
    int[] nums;
    int s;
    int[][] cache;

    int dfs(int i, int target) {
        if (cache[i][target] > 0) return cache[i][target] - 1;

        if (i == nums.length) {
            int ret = target == s ? 1 : 0;
            cache[i][target] = ret + 1;
            return cache[i][target] - 1;
        }
        int add = dfs(i + 1, target + nums[i]);
        int subtract = dfs(i + 1, target - nums[i]);

        cache[i][target] = add + subtract + 1;
        return cache[i][target] - 1;
    }

    public int findTargetSumWaysRecursive(int[] nums, int s) {
        this.nums = nums;
        this.s = s + 1000;
        cache = new int[nums.length + 1][1000 + 1001];
        return dfs(0, 1000);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        if (S > 1000 || S < -1000) return 0;
        int[][] dp = new int[nums.length][2001];
        dp[0][1000 + nums[0]] = 1;
        dp[0][1000 - nums[0]] += 1; // in case nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int target = -1000; target <= 1000; target++) {
                if (dp[i - 1][target + 1000] > 0) {
                    dp[i][target + 1000 + nums[i]] += dp[i - 1][target + 1000];
                    dp[i][target + 1000 - nums[i]] += dp[i - 1][target + 1000];
                }
            }
        }
        return dp[nums.length - 1][S + 1000];
    }
}
