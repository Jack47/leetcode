package BinaryIndexedTree;

public class RangeSumQuery2D {
    int[][] BiTree;
    int[][] matrix;

    public RangeSumQuery2D(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        this.matrix = matrix;
        BiTree = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                updateBiTree(i + 1, j + 1, matrix[i][j]);
            }
        }
    }
    void update(int i, int j, int val) {
        if (BiTree == null) return;
        updateBiTree(i+1, j+1, val-matrix[i][j]);
        matrix[i][j] = val;
    }
    void updateBiTree(int i, int j, int delta) { // add or update

        while (i < BiTree.length) {
            int col = j;
            while (col < BiTree[0].length) {
                BiTree[i][col] += delta;
                col += col & (-col);
            }
            i += i & (-i);
        }
    }

    int sumRange(int i, int j) {
        int sum = 0;
        if (BiTree == null) return sum;
        while (i > 0) {
            int col = j;
            while (col > 0) {
                sum += BiTree[i][col];
                col -= col & (-col);
            }
            i -= i & (-i);
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (BiTree == null) return 0;
        row1++;
        col1++;
        row2++;
        col2++;
        return sumRange(row2, col2) - sumRange(row1 - 1, col2) - sumRange(row2,
                col1 - 1) + sumRange(row1 - 1, col1 - 1);
    }
}
