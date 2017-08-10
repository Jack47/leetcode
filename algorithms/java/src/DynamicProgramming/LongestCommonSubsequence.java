package DynamicProgramming;

public class LongestCommonSubsequence {
    int[][] cache;
    String str1, str2;

    int dfs(int end1, int end2) {
        if (end1 < 0 || end2 < 0) return 0;
        if (cache[end1][end2] > 0) return cache[end1][end2] - 1;
        if (str1.charAt(end1) == str2.charAt(end2)) {
            cache[end1][end2] = 1 + dfs(end1 - 1, end2 - 2) + 1;
        } else {
            cache[end1][end2] = Math.max(dfs(end1 - 1, end2), dfs(end1, end2 - 1)) + 1;
        }
        return cache[end1][end2] - 1;
    }

    public int longestCommonSubsequenceDP(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return 0;
        int[][] dp = new int[A.length()+1][B.length()+1];
        for (int i = 0; i <= A.length() - 1; i++) {
            for (int j = 0; j <= B.length() - 1; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = (i >= 1 && j >= 1) ? dp[i - 1][j - 1] + 1 : 1;
                } else {
                    dp[i][j] = Math.max(i >= 1 ? dp[i - 1][j] : 0, j >= 1 ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[A.length() - 1][B.length() - 1];
    }

    public int longestCommonSubsequence(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return 0;
        cache = new int[A.length()][B.length()];
        str1 = A;
        str2 = B;
        return dfs(A.length() - 1, B.length() - 1);
    }
}
