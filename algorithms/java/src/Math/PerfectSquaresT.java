package Math;

public class PerfectSquaresT {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // [1..n]
        dp[0] = 0; //dp[i] means least number of perfect squares which sums to i
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
