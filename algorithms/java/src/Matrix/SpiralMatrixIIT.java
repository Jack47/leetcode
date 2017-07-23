package Matrix;

public class SpiralMatrixIIT {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        if (n == 0) return m;
        int k = 1;
        int colStart = 0, colEnd = n - 1, rowStart = 0, rowEnd = n - 1;

        while (k < n * n) {
            for (int i = colStart; i <= colEnd; i++) {
                m[rowStart][i] = k++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                m[i][colEnd] = k++;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                m[rowEnd][i] = k++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                m[i][colStart] = k++;
            }
            colStart++;
        }
        return m;
    }
}
