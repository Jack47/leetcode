package Palindrome;

public class LongestPalindromicSubsequence {
    String s;
    int[][] cache;

    int dfs(int i, int j) {
        if (j < i) return 0;
        if (i == j) return 1;
        if (cache[i][j] > 0) {
            return cache[i][j] - 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            cache[i][j] = 2 + dfs(i + 1, j - 1) + 1;
        } else {
            cache[i][j] = Math.max(dfs(i + 1, j), dfs(i, j - 1)) + 1;
        }
        return cache[i][j] - 1;
    }

    public int longestPalindromeSubseqDFS(String s) {
        this.s = s;
        cache = new int[s.length() + 1][s.length() + 1];
        return dfs(0, s.length() - 1);
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length()-1; i >=0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j <= s.length()-1; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
