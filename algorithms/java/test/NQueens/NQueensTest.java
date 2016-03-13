package NQueens;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NQueensTest {
    @Test
    public void testEnableCell() {
        int[][] chessBoard = new int[][]{{NQueens.DISABLE_ONCE}};
        NQueens.enableCell(chessBoard, 0, 0);
        assertEquals(0, chessBoard[0][0]);

        chessBoard = new int[][]{{3}};
        NQueens.enableCell(chessBoard, 0, 0);
        assertEquals(NQueens.DISABLE_ONCE, chessBoard[0][0]);

        chessBoard = new int[][]{{NQueens.DISABLE_ONCE, 0}, {0, NQueens.DISABLE_ONCE}};
        NQueens.enableCell(chessBoard, 0, 0);
        NQueens.enableCell(chessBoard, 1, 1);
        assertEquals(0, chessBoard[0][0]);
        assertEquals(0, chessBoard[1][1]);
        assertEquals(0, chessBoard[1][0]);
        assertEquals(0, chessBoard[0][1]);

        chessBoard = new int[][]{{3, 2, 0}, {0, 2, 3}, {2, 0, 3}};
        NQueens.enableCell(chessBoard, 0, 0);
        assertEquals(NQueens.DISABLE_ONCE, chessBoard[0][0]);
        NQueens.enableCell(chessBoard, 0, 1);
        assertEquals(0, chessBoard[0][1]);

        NQueens.enableCell(chessBoard, 1, 1);
        assertEquals(0, chessBoard[1][1]);

        NQueens.enableCell(chessBoard, 1, 2);
        assertEquals(NQueens.DISABLE_ONCE, chessBoard[1][2]);

        NQueens.enableCell(chessBoard, 2, 0);
        assertEquals(0, chessBoard[2][0]);
    }

    @Test
    public void testDisableCell() {
        int[][] chessBoard = new int[][]{{NQueens.DISABLE_ONCE}};
        NQueens.disableCell(chessBoard, 0, 0);
        assertEquals(3, chessBoard[0][0]);

        chessBoard = new int[][]{{3}};
        NQueens.disableCell(chessBoard, 0, 0);
        assertEquals(4, chessBoard[0][0]);

        chessBoard = new int[][]{{NQueens.DISABLE_ONCE, 0}, {0, NQueens.DISABLE_ONCE}};
        NQueens.disableCell(chessBoard, 0, 0);
        NQueens.disableCell(chessBoard, 1, 1);
        assertEquals(3, chessBoard[0][0]);
        assertEquals(3, chessBoard[1][1]);
        assertEquals(0, chessBoard[1][0]);
        assertEquals(0, chessBoard[0][1]);
        NQueens.disableCell(chessBoard, 0, 1);
        assertEquals(2, chessBoard[0][1]);

        chessBoard = new int[][]{{3, 2, 0}, {0, 2, 3}, {2, 0, 3}};
        NQueens.disableCell(chessBoard, 0, 0);
        assertEquals(4, chessBoard[0][0]);

        NQueens.disableCell(chessBoard, 0, 1);
        assertEquals(3, chessBoard[0][1]);

        NQueens.disableCell(chessBoard, 0, 2);
        assertEquals(2, chessBoard[0][2]);

        NQueens.disableCell(chessBoard, 1, 0);
        assertEquals(2, chessBoard[1][0]);

        NQueens.disableCell(chessBoard, 1, 1);
        assertEquals(3, chessBoard[1][1]);

        NQueens.disableCell(chessBoard, 1, 2);
        assertEquals(4, chessBoard[1][2]);
    }

    @Test
    public void testBuildResult() {
        int[][] chessBoard = new int[][]{{1}};
        List<String> result = NQueens.buildResult(chessBoard);
        assertEquals(new ArrayList<String>() {{
            add("Q");
        }}, result);

        chessBoard = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        result = NQueens.buildResult(chessBoard);
        assertEquals(new ArrayList<String>() {{
            add("Q..");
            add(".Q.");
            add("..Q");
        }}, result);
    }

    @Test
    public void testDisableColumn() {
        int[][] chessBoard = new int[][]{{0}};
        int column = 0;
        NQueens.disableColumn(chessBoard, column);
        assertEquals(2, chessBoard[0][0]);

        chessBoard = new int[][]{{NQueens.QUEUE_PLACED}};
        column = 0;
        NQueens.disableColumn(chessBoard, column);
        assertEquals(1, chessBoard[0][0]);

        chessBoard = new int[][]{{0, NQueens.QUEUE_PLACED}, {NQueens.DISABLE_ONCE, 3}};
        NQueens.disableColumn(chessBoard, 0);
        assertEquals(2, chessBoard[0][0]);
        assertEquals(3, chessBoard[1][0]);
        assertEquals(1, chessBoard[0][1]);
        assertEquals(3, chessBoard[1][1]);

        NQueens.disableColumn(chessBoard, 1);
        assertEquals(1, chessBoard[0][1]);
        assertEquals(4, chessBoard[1][1]);
    }

    @Test
    public void testEnableColumn() {
        int[][] chessBoard = new int[][]{{NQueens.QUEUE_PLACED}};
        NQueens.enableColumn(chessBoard, 0);
        assertEquals(1, chessBoard[0][0]);

        chessBoard = new int[][]{{4, NQueens.QUEUE_PLACED}, {NQueens.DISABLE_ONCE, 3}};
        NQueens.enableColumn(chessBoard, 0);
        assertEquals(3, chessBoard[0][0]);
        assertEquals(0, chessBoard[1][0]);

        NQueens.enableColumn(chessBoard, 1);
        assertEquals(1, chessBoard[0][1]);
        assertEquals(2, chessBoard[1][1]);
    }

    @Test
    public void testEnableNorthEast2SouthWest() {
        int[][] chessBoard = new int[][]{{2}};
        NQueens.enableNorthEast2SouthWest(chessBoard, 0, 0);
        assertEquals(2, chessBoard[0][0]);

        chessBoard = new int[][]{{3, 2}, {4, 5}};
        NQueens.enableNorthEast2SouthWest(chessBoard, 0, 1);
        assertEquals(3, chessBoard[0][0]);
        assertEquals(2, chessBoard[0][1]);
        assertEquals(3, chessBoard[1][0]);
        assertEquals(5, chessBoard[1][1]);

        chessBoard = new int[][]{{1, 3, 2}, {3, 2, 1,}, {3, 1, 2}};
        NQueens.enableNorthEast2SouthWest(chessBoard, 1, 1);
        assertEquals(1, chessBoard[0][0]);
        assertEquals(2, chessBoard[1][1]);
        assertEquals(2, chessBoard[2][2]);
        assertEquals(0, chessBoard[0][2]);
        assertEquals(2, chessBoard[2][0]);

        chessBoard = new int[][]{{1, 3, 2}, {3, 2, 1,}, {2, 1, 2}};
        NQueens.enableNorthEast2SouthWest(chessBoard, 1, 0);
        assertEquals(1, chessBoard[0][0]);
        assertEquals(3, chessBoard[1][0]);
        assertEquals(2, chessBoard[1][1]);
        assertEquals(2, chessBoard[2][2]);
        assertEquals(2, chessBoard[0][1]);
    }

    @Test
    public void testSolve() {
        NQueens nQueens = new NQueens();
        List<List<String>> resultList = nQueens.solveNQueens(3);
        assertEquals(0, resultList.size());

        int solutions = nQueens.totalNQueens(3);
        assertEquals(0, solutions);

        resultList = nQueens.solveNQueens(4);
        assertEquals(2, resultList.size());
        assertEquals(new ArrayList<String>() {{
            add(".Q..");
            add("...Q");
            add("Q...");
            add("..Q.");
        }}, resultList.get(0));
        solutions = nQueens.totalNQueens(4);
        assertEquals(2, solutions);
        assertEquals(new ArrayList<String>() {{
            add("..Q.");
            add("Q...");
            add("...Q");
            add(".Q..");
        }}, resultList.get(1));
    }
}
