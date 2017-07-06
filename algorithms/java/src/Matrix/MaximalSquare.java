package Matrix;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(dp[0][i], max);
        }
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max * max;
    }
    public int maximalSquareE(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] preDp = new int[matrix[0].length];
        int[] dp = new int[matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            preDp[i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(preDp[i], max);
        }

        for (int i = 1; i < matrix.length; i++) {
            dp[0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[0]);
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[j] = 1 + Math.min(preDp[j - 1], Math.min(dp[j-1], preDp[j]));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
            int[] t = preDp;
            preDp = dp;
            dp = t;
        }
        return max * max;
    }
}
