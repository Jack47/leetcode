package DynamicProgramming;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(r == 0 && c == 0) continue;
                if(r == 0) {
                    dp[c] = dp[c-1];
                } else if(c == 0) {
                    dp[c] = dp[c];
                } else {
                    dp[c] = Math.min(dp[c-1], dp[c]);
                }
                dp[c] += grid[r][c];
            }
        }
        return dp[n-1];
    }
}
