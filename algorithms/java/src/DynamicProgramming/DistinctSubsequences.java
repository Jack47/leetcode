package DynamicProgramming;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1]; // because we need dp[i-1][j-1] and
        // dp[i][j-1]
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1; // any sequence can contain empty string
        }
        // dp[i][0] = 0;

        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                dp[i][j] = dp[i][j-1]; // don't care s[j]
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1]; // ending with s[j] and t[i]: dp[i-1][j-1]
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}
