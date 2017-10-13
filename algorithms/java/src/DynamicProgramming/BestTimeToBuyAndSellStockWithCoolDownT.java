package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithCoolDownT {
    public int maxProfitPhase0(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n]; // [0..n-2]
        for (int i = 0; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] + prices[i] - prices[j]);
            }
        }
        return dp[n];
    }

    public int maxProfitPhase1(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 2]; // [2..n+1]
        for (int i = 2; i < n + 2; i++) {
            dp[i] = dp[i - 1];
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] + prices[i - 2] - prices[j - 2]);
            }
        }
        return dp[n + 1];
    }

    public int maxProfitPhase3(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 2]; // [2..n+1]
        for (int i = 2; i < n + 2; i++) {
            dp[i] = dp[i - 1];
            int maxDiff = Integer.MIN_VALUE;
            for (int j = 2; j <= i; j++) {
                // dp[i] = Math.max(dp[i], dp[j-2] + prices[i]-prices[j])
                maxDiff = Math.max(maxDiff, dp[j - 2] - prices[j - 2]);
            }
            dp[i] = Math.max(dp[i - 1], maxDiff + prices[i - 2]);
        }
        return dp[n + 1];
    }

    public int maxProfitPhase4(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 2]; // [2..n+1]
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 2; i < n + 2; i++) {
            dp[i] = dp[i - 1];
            maxDiff = Math.max(maxDiff, dp[i - 2] - prices[i - 2]);
            dp[i] = Math.max(dp[i - 1], maxDiff + prices[i - 2]);
        }
        return dp[n + 1];
    }

    public int maxProfitPhase(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 2]; // [2..n+1]
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 2; i < n + 2; i++) {
            dp[i] = dp[i - 1];
            maxDiff = Math.max(maxDiff, dp[i - 2] - prices[i - 2]);
            dp[i] = Math.max(dp[i - 1], maxDiff + prices[i - 2]);
        }
        return dp[n + 1];
    }
}
