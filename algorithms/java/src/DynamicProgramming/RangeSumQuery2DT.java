package DynamicProgramming;

public class RangeSumQuery2DT {
    int[][] sums;

    public RangeSumQuery2DT(int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length]; // sums[i][j] means square's area: [0..i][0..j] sums
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                sums[i][j] = (i > 0 ? sums[i - 1][j] : 0) + sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2][col2] - (row1 == 0 ? 0 : sums[row1 - 1][col1]) - (col1 == 0 ? 0 :
                sums[row2][col1 - 1]) + (row1 == 0 || col1 == 0 ? 0 : sums[row1 - 1][col1 - 1]);
    }
}
