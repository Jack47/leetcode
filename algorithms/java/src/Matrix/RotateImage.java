package Matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        // reverse up to down
        for (int row = 0; row < matrix.length/2; row++) {
            for(int col = 0; col < matrix.length; col ++) {
                int t = matrix[row][col];
                matrix[row][col] = matrix[matrix.length-row-1][col];
                matrix[matrix.length-row-1][col] = t;
            }
        }

        // flip symmetrically
        for (int row = 0; row < matrix.length; row++) {
            for(int col = row+1; col < matrix.length; col++) {
                int t = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = t;
            }
        }
    }
}
