package DepthFirstSearch;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs_exist(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean dfs_exist(char[][] board,
                                String word,
                                int kth,
                                int row,
                                int col,
                                boolean visited[][]) {
        if (kth >= word.length() -1) return true;
        if (visited[row][col]) return false;
        visited[row][col] = true;

        // try next step
        for (int d = 0; d < 4; d++) {
            int r = row;
            int c = col;
            switch (d) {
                case 0:
                    r++;
                    break;
                case 1:
                    r--;
                    break;
                case 2:
                    c++;
                    break;
                case 3:
                    c--;
                    break;
            }
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length &&
                    !visited[r][c] && word.charAt(kth + 1) == board[r][c]) {
                if (dfs_exist(board, word, kth + 1, r, c, visited)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;
        return false;
    }
}
