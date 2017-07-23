package DynamicProgramming;

public class UniquePathWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 || n == 0 || obstacleGrid[0][0] == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue;
                if (r == 0) {
                    dp[c] = obstacleGrid[r][c-1] == 0 ? dp[c - 1] : 0;
                } else if (c == 0) {
                    dp[c] = obstacleGrid[r-1][c] == 0 ? dp[c] : 0;
                } else {
                    dp[c] = obstacleGrid[r-1][c] == 0 ? dp[c] : 0 + obstacleGrid[r][c-1] == 0 ? dp[c - 1] : 0;
                }
            }
        }
        return dp[n - 1];
    }
}
