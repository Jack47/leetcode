package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeT {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        for (int i = 0; i <= coins.length - 1; i++) {
            dp[0] = 0;
            if (i == 0) dp[amount] = -1;
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
                for (int j = amount; j >= 0; j--) {
                    int small = Integer.MAX_VALUE;
                    for (int k = j / coins[i]; k >= 0; k--) {
                        int cur;
                        if (i == 0) {
                            cur = j - k * coins[i] == 0 ? 0 : -1;
                        } else {
                            cur = dp[j - k * coins[i]];
                        }
                        if (cur == -1) continue;
                        small = Math.min(small, cur + k);
                    }
                    dp[j] = small != Integer.MAX_VALUE ? small : -1;
                }
            }
        }
        return dp[amount];
    }
}
