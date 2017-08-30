package DynamicProgramming;

public class RangeSumQuery2DT {
    int[][] dp;

    public RangeSumQuery2DT(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2][col2] - (row1 == 0 ? 0 : dp[row1 - 1][col1]) - (col1 == 0 ? 0 :
                dp[row2][col1 - 1]) + (row1 == 0 || col1 == 0 ? 0 : dp[row1 - 1][col1 - 1]);
    }
}
