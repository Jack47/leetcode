package Matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchTest {
    @Test
    public void test() {
        Search sol = new Search();
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}
        };
        boolean ret = sol.searchMatrix (matrix, 3);
        assertEquals(true, ret);

        ret = sol.searchMatrix (matrix, 12);
        assertEquals(false, ret);

        ret = sol.searchMatrix (matrix, 33);
        assertEquals(false, ret);

        ret = sol.searchMatrix (matrix, 50);
        assertEquals(true, ret);

        matrix = new int[][]{{}};
        ret = sol.searchMatrix(matrix, 1);
        assertEquals(false, ret);
    }
}
