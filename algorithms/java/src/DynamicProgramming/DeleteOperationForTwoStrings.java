package DynamicProgramming;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for(int i = 1;i <= word2.length(); i++) {
            dp[i][0] = i;
        }
        for(int i = 1;i <= word1.length(); i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= word2.length(); i++) {
            for(int j = 1; j <= word1.length(); j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)) { // same char, so without any edit distance effort
                    dp[i][j] = dp[i-1][j-1];
                } else { // append from word1 or word2
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
