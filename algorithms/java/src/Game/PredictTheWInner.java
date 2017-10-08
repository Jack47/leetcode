package Game;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i][j] (i <=j) means the maximum sum
        // the first player can get from [i, ...j]
        int[][] dp = new int[n][n];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            dp[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                // opponent choose i+1, or j
                int r1 = nums[i] + Math.min(i + 2 >= n ? 0 : dp[i + 2][j], dp[i + 1][j - 1]);
                // opponent choose i, or j-1
                int r2 = nums[j] + Math.min(dp[i + 1][j - 1], j - 2 < 0 ? 0 : dp[i][j - 2]);
                dp[i][j] = Math.max(r1, r2);
            }
        }
        // if the scores of both players are equal,
        // then the player 1 is still the winner
        return 2 * dp[0][n - 1] >= sum;
    }
}
