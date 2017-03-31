package Matrix;
// https://leetcode.com/problems/search-a-2d-matrix/#/description
// Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the
// previous row.
public class Search {
    public int binarySearchRow(int[][] matrix, int row, int target) {
        int low = 0;
        int high = matrix[row].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] > target) {
                high = mid - 1;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return high;
    }
    public int binarySearchCol(int[][] matrix, int col, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][col] > target) {
                high = mid - 1;
            } else if (matrix[mid][col] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return high;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix.length == 1 && matrix[0].length == 0) {
            return false;
        }
        int row = binarySearchCol(matrix, 0, target);
        if ( row < 0 || row >= matrix.length) {
            return false;
        }
        int col = binarySearchRow(matrix, row, target);
        if (col < 0 || col >= matrix[row].length) {
            return false;
        }
        return matrix[row][col] == target;
    }
}
