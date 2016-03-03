package CoinChange;

import java.util.Arrays;

/**
 *
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        Arrays.sort(coins);
        // result[i][amount] = f(coins[i], amount), add coins[i], the coinChange of amount
        int[][] result = new int[coins.length][amount + 1];
        for (int a = 0; a <= amount; a++) {
            result[0][a] = a % coins[0] == 0 ? a / coins[0] : -1;
        }

        for (int i = 0; i < coins.length - 1; i++) {
            // calculate result[i+1][0~amount];
            for (int a = 0; a <= amount; a++) {
                int count = a / coins[i + 1];
                int small = Integer.MAX_VALUE;
                for (int k = 0; k <= count; k++) {
                    int num = result[i][a - k * coins[i + 1]];
                    if (num == -1) continue;
                    num += k;
                    if (num < small) {
                        small = num;
                    }
                }
                if (small != Integer.MAX_VALUE) {
                    result[i + 1][a] = small;
                }
                else {
                    result[i + 1][a] = -1;
                }
            }
        }
        return result[coins.length - 1][amount];
    }
}
