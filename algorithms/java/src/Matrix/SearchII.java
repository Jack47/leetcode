package Matrix;

public class SearchII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        if (matrix.length < 1) {
            return false;
        }
        int j = matrix[0].length - 1;
        while (i <= matrix.length -1 && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
