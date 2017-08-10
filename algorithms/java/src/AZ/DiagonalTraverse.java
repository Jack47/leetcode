package AZ;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int totalLen = matrix.length * matrix[0].length;
        int[] result = new int[totalLen];
        int count = 0;
        boolean up = true;
        int i = 1, j = -1;
        int row = matrix.length;
        int col = matrix[0].length;

        while (count < totalLen) {
            if (up) {
                while (i >= 1 && j <= col - 2) {
                    i--;
                    j++;
                    result[count++] = matrix[i][j];
                }
                if (j <= col - 2) { // right
                    j++;
                } else { // downward
                    i++;
                }
            } else {
                while (i <= row - 2 && j >= 1) {
                    i++;
                    j--;
                }
                if (i <= row - 2) { // downward
                    i++;
                } else {
                    j++;
                }
            }
            if (i >= row - 1 && j >= col - 1) result[count++] = matrix[i][j];
            up = !up;
        }

        return result;
    }
}
