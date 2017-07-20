package DynamicProgramming;

public class BestTimeToBuyAndSellStockIV {
    int quickSolve(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices.length == 0) return 0;
        if(k >= prices.length/2) {
            return quickSolve(prices);
        }
        int[][] dp = new int[k + 1][prices.length + 1];
        int max = 0;
        for (int t = 1; t <= k; t++) {
            int maxDiff = dp[t - 1][0] - prices[0];
            for (int i = 1; i <= prices.length - 1; i++) { // dp[t][i] = max(dp[t][i-1],
            // dp[t-1][j]+p[i]-p[j])
                //          = max(dp[t][i-1], p[i]+max(dp[t-1][j]-p[j]))
                dp[t][i] = Math.max(dp[t][i - 1], maxDiff + prices[i]);
                max = Math.max(dp[t][i], max);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }
        return max;
    }
}
