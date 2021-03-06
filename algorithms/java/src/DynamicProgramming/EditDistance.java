package DynamicProgramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        // <empty string, word2>
        for (int i = 0; i <= word2.length(); i++) {
            dp[i][0] = i;
        }
        // <word1, empty string>
        for (int j = 0; j <= word1.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) { // same char, so without any edit effort
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // need one edit distance to append current char or replace current char
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[word2.length()][word1.length()];
    }
}
