package Matrix;

public class Multiply {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];

        for (int row = 0; row < A.length; row++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[row][k] == 0) {
                    continue;
                }
                for (int col = 0; col < B[0].length; col++) {
                    result[row][col] += A[row][k] * B[k][col];
                }
            }
        }
        return result;
    }
}
