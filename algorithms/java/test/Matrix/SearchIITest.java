package Matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchIITest {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 5, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        SearchII s = new SearchII();
        boolean result = s.searchMatrix(matrix, 5);
        assertEquals(true, result);

        result = s.searchMatrix(matrix, 20);
        assertEquals(false, result);

        result = s.searchMatrix(matrix, 8);
        assertEquals(true, result);

        matrix = new int[][]{{}};
        result = s.searchMatrix(matrix, 0);
        assertEquals(false, result);

        matrix = new int[][]{{}};
        result = s.searchMatrix(matrix, 0);
        assertEquals(false, result);
    }
}
