package Graph;

public class PartitionEqualSubsetSum {
    int sum;
    int[] nums;
    int[][] cache;

    boolean dfs(int i, int curSum) {

        if (curSum == sum) return true;
        if (i >= nums.length) return false;
        if (cache[i][curSum] != 0) {
            return cache[i][curSum] == 1;
        }
        for (int j = i; j < nums.length; j++) {
            if (curSum + nums[j] <= sum) {
                if (dfs(j + 1, curSum + nums[j])) {
                    cache[i][curSum] = 1;
                    return true;
                }
            }

        }

        cache[i][curSum] = 2;
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > sum) return false;
            if (nums[i] == sum) return true;
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] =  dp[i - 1][j] | (j-nums[i] >= 0 ? dp[i - 1][j - nums[i]] : false);
            }
        }

        return dp[nums.length - 1][sum];
    }

    public boolean canPartitionDfs(int[] nums) {
        int sum = 0;
        this.nums = nums;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        this.sum = sum / 2;
        cache = new int[nums.length][this.sum + 1];
        return dfs(0, 0);
    }
}
