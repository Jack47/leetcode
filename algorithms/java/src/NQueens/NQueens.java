package NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    protected final static int QUEUE_PLACED = 0x01;
    protected final static int DISABLE_ONCE = 0x02;
    protected final static int EMPTY = 0x00;
    protected int solutions;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        List<String> result = new ArrayList<String>();
        int[][] chessBoard = new int[n][n];
        solve(0, chessBoard, resultList);
        return resultList;
    }

    public int totalNQueens(int n) {
        solutions = 0;
        int[][] chessBoard = new int[n][n];
        solve(0, chessBoard);
        return solutions;
    }

    protected boolean solve(int row, int[][] chessBoard) {
        assert chessBoard.length == chessBoard[0].length : "chessBoard must be square";
        if (row == chessBoard.length) {
            List<String> result = buildResult(chessBoard);
            solutions++;
            return true;
        }
        int columns = chessBoard[0].length;
        boolean canPlace = false;
        for (int col = 0; col < columns; col++) {
            if (chessBoard[row][col] == EMPTY) {
                placeQueue(chessBoard, row, col);
                boolean solved = solve(row + 1, chessBoard);
                if (solved) canPlace = true;
                unplaceQueue(chessBoard, row, col);
            }
        }
        return canPlace;
    }

    protected static boolean solve(int row, int[][] chessBoard, List<List<String>> resultList) {
        assert chessBoard.length == chessBoard[0].length : "chessBoard must be square";
        if (row == chessBoard.length) {
            List<String> result = buildResult(chessBoard);
            resultList.add(result);
            return true;
        }
        int columns = chessBoard[0].length;
        boolean canPlace = false;
        for (int col = 0; col < columns; col++) {
            if (chessBoard[row][col] == EMPTY) {
                placeQueue(chessBoard, row, col);
                boolean solved = solve(row + 1, chessBoard, resultList);
                if (solved) canPlace = true;
                unplaceQueue(chessBoard, row, col);
            }
        }
        return canPlace;
    }

    protected static void unplaceQueue(int[][] chessBoard, int row, int col) {
        assert chessBoard[row][col] == QUEUE_PLACED : "chessBoard[" + row + "][" + col + "] must " +
                "be placed the Queue";
        chessBoard[row][col] = EMPTY;
        enableRow(chessBoard, row);
        enableColumn(chessBoard, col);
        enableNorthWest2SouthEast(chessBoard, row, col);
        enableNorthEast2SouthWest(chessBoard, row, col);
    }

    protected static void placeQueue(int[][] chessBoard, int row, int col) {
        assert chessBoard[row][col] == EMPTY : "chessBoard[" + row + "][" + col + "] must be " +
                "empty to place the Queue";
        chessBoard[row][col] = QUEUE_PLACED;
        disableRow(chessBoard, row);
        disableColumn(chessBoard, col);
        disableNorthWest2SouthEast(chessBoard, row, col);
        disableNorthEast2SouthWest(chessBoard, row, col);
    }

    protected static void enableNorthEast2SouthWest(int[][] chessBoard, int row, int column) {
        setNorthEast2SouthWest(chessBoard, row, column, true);
    }

    protected static void disableNorthEast2SouthWest(int[][] chessBoard, int row, int column) {
        setNorthEast2SouthWest(chessBoard, row, column, false);
    }

    protected static void setNorthEast2SouthWest(int[][] chessBoard,
                                                 int row,
                                                 int column,
                                                 boolean enable) {
        int rowOffset = -1;
        int columnOffset = 1;
        // North East
        while (row + rowOffset >= 0 && column + columnOffset < chessBoard.length) {
            if (chessBoard[row + rowOffset][column + columnOffset] != QUEUE_PLACED) {
                if (enable) {
                    enableCell(chessBoard, row + rowOffset, column + columnOffset);
                } else {
                    disableCell(chessBoard, row + rowOffset, column + columnOffset);
                }
            }
            rowOffset += -1;
            columnOffset += 1;
        }

        // South West
        rowOffset = +1;
        columnOffset = -1;
        while (row + rowOffset < chessBoard.length && column + columnOffset >= 0) {
            if (chessBoard[row + rowOffset][column + columnOffset] != QUEUE_PLACED) {
                if (enable) {
                    enableCell(chessBoard, row + rowOffset, column + columnOffset);
                } else {
                    disableCell(chessBoard, row + rowOffset, column + columnOffset);
                }
            }
            columnOffset += -1;
            rowOffset += 1;
        }
    }

    protected static void disableNorthWest2SouthEast(int[][] chessBoard, int row, int column) {
        setNorthWest2SouthEast(chessBoard, row, column, false);
    }

    protected static void enableNorthWest2SouthEast(int[][] chessBoard, int row, int column) {
        setNorthWest2SouthEast(chessBoard, row, column, true);
    }

    protected static void setNorthWest2SouthEast(int[][] chessBoard,
                                                 int row,
                                                 int column,
                                                 boolean enable) {
        int offset = -1;
        // North West
        while (row + offset >= 0 && column + offset >= 0) {
            if (chessBoard[row + offset][column + offset] != QUEUE_PLACED) {
                if (enable) {
                    enableCell(chessBoard, row + offset, column + offset);
                } else {
                    disableCell(chessBoard, row + offset, column + offset);
                }
            }
            offset += -1;
        }

        // South East
        offset = 1;
        while (row + offset < chessBoard.length && column + offset < chessBoard.length) {
            if (chessBoard[row + offset][column + offset] != QUEUE_PLACED) {
                if (enable) {
                    enableCell(chessBoard, row + offset, column + offset);
                } else {
                    disableCell(chessBoard, row + offset, column + offset);
                }
            }
            offset += 1;
        }
    }

    protected static void disableCell(int[][] chessBoard, int row, int col) {
        assert chessBoard[row][col] != QUEUE_PLACED;
        chessBoard[row][col] = chessBoard[row][col] >= DISABLE_ONCE ?
                chessBoard[row][col] + 1 : DISABLE_ONCE;
    }

    protected static void enableCell(int[][] chessBoard, int row, int col) {
        if (chessBoard[row][col] == EMPTY) return;

        assert chessBoard[row][col] >= DISABLE_ONCE : "chessBoard[" + row + "][" + col + "]:" +
                chessBoard[row][col];
        chessBoard[row][col] = chessBoard[row][col] == DISABLE_ONCE ? 0 :
                chessBoard[row][col] - 1;
    }

    protected static void disableRow(int[][] chessBoard, int row) {
        setRow(chessBoard, row, false);
    }

    protected static void enableRow(int[][] chessBoard, int row) {
        setRow(chessBoard, row, true);
    }

    protected static void setRow(int[][] chessBoard, int row, boolean enable) {
        for (int col = 0; col < chessBoard.length; col++) {
            if (chessBoard[row][col] != QUEUE_PLACED) {
                if (enable) {
                    enableCell(chessBoard, row, col);
                } else {
                    disableCell(chessBoard, row, col);
                }
            }
        }
    }

    protected static void enableColumn(int[][] chessBoard, int column) {
        setColumn(chessBoard, column, true);
    }

    protected static void disableColumn(int[][] chessBoard, int column) {
        setColumn(chessBoard, column, false);
    }

    protected static void setColumn(int[][] chessBoard, int column, boolean enable) {
        for (int row = 0; row < chessBoard.length; row++) {
            if (chessBoard[row][column] != QUEUE_PLACED) {
                if (enable) {
                    enableCell(chessBoard, row, column);
                } else {
                    disableCell(chessBoard, row, column);
                }
            }
        }
    }

    protected static List<String> buildResult(int[][] chessBoard) {
        int rows = chessBoard.length;
        int columns = chessBoard[0].length;
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < rows; i++) {
            builder.setLength(0);
            for (int j = 0; j < columns; j++) {
                if (chessBoard[i][j] == QUEUE_PLACED) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
}
