package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeT {
    int[] coins;
    int[][] cache;
    int[] amountCache;
    int amount;

    int dfs(int i, int amount) {
        if (amount == 0) return 0;
        if (i == coins.length) return -1;
        if (cache[i][amount] != 0) return cache[i][amount];
        int num = amount / coins[i];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k <= num; k++) {
            int r = dfs(i + 1, amount - k * coins[i]);
            if (r >= 0 && r + k < min) {
                min = r + k;
            }
        }
        cache[i][amount] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[i][amount];
    }

    public int coinChange(int[] coins, int amount) {
        ////// memorized dfs
//        this.coins = coins;
//        this.amountCache = new int[amount + 1];
//        return coinChangeAddAmount(amount);
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int small = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(coin <= i && dp[i-coin] != -1) {
                    small = Math.min(small, dp[i-coin]+1);
                }
            }
            dp[i] = small != Integer.MAX_VALUE ? small : -1;
        }
        return dp[amount];
    }

    public int coinChangeAddAmount(int target) {

        if (target == 0) return 0;
        if (target < 0) return -1;
        if (amountCache[target] != 0) return amountCache[target];
        int small = Integer.MAX_VALUE;
        for (int coin : coins) {
            int r = coinChangeAddAmount(target - coin);
            if (r != -1) {
                small = Math.min(small, r + 1);
            }
        }
        amountCache[target] = small != Integer.MAX_VALUE ? small : -1;
        return amountCache[target];
    }

    public int coinChangeAddCoins(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new int[coins.length][amount + 1];
        return dfs(0, amount);
    }

    public int coinChangeTwoDimensionDP(int[] coins, int amount) {
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
