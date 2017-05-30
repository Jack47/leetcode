package Matrix;

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int col = n;
        int row = m;
        for (int i = 0; i < ops.length; i++) {
            col = ops[i][1] < col ? ops[i][1] : col;
            row = ops[i][0] < row ? ops[i][0] : row;
        }
        return col * row + 1;
    }
}
