package TicTacToe;

public class TicTacToe {
    int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }

    boolean rowWin(int row, int player) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    boolean colWin(int col, int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    boolean crossWin(int row, int col, int player) {
        boolean ret = true;
        if (row == col) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[i][i] != player) {
                    ret = false;
                    break;
                };
            }
            if (row != board.length/2) { // there is no center point
                return ret;
            };
        }
        if (col == board[0].length - row - 1) {
            for (int r = 0; r <= board[0].length-1; r++) {
                int c = board[0].length - 1 - r;
                if (board[r][c] != player) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (rowWin(row, player) || colWin(col, player) || crossWin(row, col, player)) {
            return player;
        }
        return 0;
    }
}
