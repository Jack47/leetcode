package DynamicProgramming;

public class LongestCommonSubstring {
    public int longestCommonSubstring(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        for (int i = 0; i <= str1.length() - 1; i++) {
            for (int j = 0; j <= str2.length() - 1; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(dp[i + 1][j + 1], max);
                }
            }
        }
        return max;
    }
}
