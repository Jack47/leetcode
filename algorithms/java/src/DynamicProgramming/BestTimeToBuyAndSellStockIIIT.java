package DynamicProgramming;

public class BestTimeToBuyAndSellStockIIIT {
    public int maxProfitPhase0(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[2][n];
        for (int k = 0; k <= 1; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    dp[k][i] = Math.max(dp[k][i - 1], dp[k - 1][j - 1] + prices[i] - prices[j]);
                }
            }
        }
        return dp[2][n];
    }

    public int maxProfitPhaseI(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[3][n + 1];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[k][i] = Math.max(dp[k][i - 1], dp[k - 1][j - 1] + prices[i] - prices[j]);
                }
            }
        }
        return dp[2][n];
    }

    public int maxProfitPhaseII(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[3][n + 1];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i <= n; i++) {
                int maxDiff = Integer.MIN_VALUE;
                for (int j = 1; j <= i; j++) {
                    maxDiff = Math.max(dp[k - 1][j - 1] - prices[j - 1], maxDiff);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i - 1] + maxDiff);
            }
        }
        return dp[2][n];
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[3][n + 1];
        for (int k = 1; k <= 2; k++) {
            int maxDiff = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                maxDiff = Math.max(maxDiff, dp[k - 1][i - 1] - prices[i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i - 1] + maxDiff);
            }
        }
        return dp[2][n];
    }
}
