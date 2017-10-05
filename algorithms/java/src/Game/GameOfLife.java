package Game;

public class GameOfLife {
    public enum Status {
        Live(1), Dead(0);
        private final int status;

        Status(int status) {
            this.status = status;
        }

        public int getValue() {
            return status;
        }

        public static Status valueOf(int status) {
            if (status == 1) {
                return Live;
            } else {
                return Dead;
            }
        }
    }

    public void gameOfLife(int[][] board) {
        int size = board.length * board[0].length;
        Status[] nextStatus = new Status[size];
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighBor = getLiveNeighBor(board, i, j);
                nextStatus[counter++] = getNextStatus(Status.valueOf(board[i][j]), liveNeighBor);
            }
        }

        counter = 0;
        for (int i =0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = nextStatus[counter++].getValue();
            }
        }
    }

    protected int getLiveNeighBor(int[][] board, int row, int column) {
        int liveNeighBor = 0;
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {
                int currentRow = row + rowOffset;
                int currentColumn = column + columnOffset;
                if ((currentRow == row && currentColumn == column) || currentRow < 0 ||
                        currentRow >= board.length || currentColumn < 0 || currentColumn >=
                        board[0].length)
                    continue;
                if (Status.valueOf(board[currentRow][currentColumn]) == Status.Live) {
                    liveNeighBor++;
                }
            }
        }
        return liveNeighBor;
    }

    protected Status getNextStatus(Status currentStatus, int liveNeighBor) {
        if (currentStatus == Status.Live) {
            if (liveNeighBor < 2) {
                return Status.Dead;
            } else if (liveNeighBor >= 2 && liveNeighBor <= 3) {
                return Status.Live;
            } else if (liveNeighBor > 3) {
                return Status.Dead;
            }
        } else {
            if (liveNeighBor == 3) {
                return Status.Live;
            }
        }
        return Status.Dead;
    }
}
