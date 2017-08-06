package StringRelated;

public class DeleteOperationsForTwoStrings {
    int dfs(char[] str1, int s1, char[] str2, int s2) {
        if (s1 == str1.length) {
            return str2.length - s2;
        }
        if (s2 == str2.length) {
            return str1.length - s1;
        }
        if (str1[s1] == str2[s2]) {
            return dfs(str1, s1 + 1, str2, s2 + 2);
        } else {
            int left = dfs(str1, s1 + 1, str2, s2);
            int right = dfs(str1, s1, str2, s2 + 1);
            return Math.min(left, right) + 1;
        }
    }

    public int minDistanceDfs(String word1, String word2) {
        return dfs(word1.toCharArray(), 0, word2.toCharArray(), 0);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if(i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
