package Game;

/**
 *
 */
public class SetMatrixZeroes {
    protected final static int ZERO_MASK = 0x01;
    protected final static int ROW_AFFECTED_MASK = 0x02;
    protected final static int COLUMN_AFFECTED_MASK = 0x04;

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean column0IsAffected = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (matrix[r][c] == 0) {
                    if (c == 0) {
                        column0IsAffected = true;
                    } else {
                        matrix[0][c] = 0;
                    }
                    matrix[r][0] = 0;
                }
            }
        }

        // affect right-bottom columns [1,1]->[]
        for (int c = 1; c < columns; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Now we can erase the zero-th row.
        // affect right-bottom rows [1,1] ->[]
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < columns; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Judge zero-th column
        if (column0IsAffected) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
