package Game;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SetMatrixZeroesTest {
    @Test
    public void test() {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] matrix = new int[][]{{0, 1, 0}};
        setMatrixZeroes.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0, 0}}, matrix);

        matrix = new int[][]{{0, 1, 0}, {2, 0, 3}};
        setMatrixZeroes.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 0, 0}}, matrix);

        matrix = new int[][]{{0, 2, 0}, {-1, 11, 98}};
        setMatrixZeroes.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 11, 0}}, matrix);

        matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 0, 1}};
        setMatrixZeroes.setZeroes(matrix);
        assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 0, 0}}, matrix);
    }
}
