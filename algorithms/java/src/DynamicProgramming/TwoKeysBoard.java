package DynamicProgramming;

import java.util.Arrays;

public class TwoKeysBoard {
    public int minStepsDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = i;
            for (int j = i - 1; j >= 1; j--) {
                if (i % j == 0) {
                    if (j == 1) { // prime
                        dp[i] = i;
                    } else {
                        dp[i] = dp[i / j] + 1 + j - 1;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public int minSteps(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                count += i;
                n = n / i;
            }
        }
        return count;
    }
}
