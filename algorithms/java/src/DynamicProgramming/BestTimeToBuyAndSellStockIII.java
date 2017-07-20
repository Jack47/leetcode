package DynamicProgramming;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        int max = 0;
        for (int t = 1; t <= 2; t++) {
            int maxDiff = dp[t - 1][0] - prices[0];
            for (int i = 1; i <= prices.length - 1; i++) {
                // dp[t][i] = max(dp[t][i-1], dp[t-1][j-1]+p[i]-p[j])
                //          = max(dp[t][i-1], p[i] + max(dp[t-1][j-1]-p[j]))
                dp[t][i] = Math.max(dp[t][i - 1], maxDiff + prices[i]);
                max = Math.max(dp[t][i], max);
                maxDiff = Math.max(maxDiff, dp[t - 1][i-1] - prices[i]);
            }
        }
        return max;
    }
}
