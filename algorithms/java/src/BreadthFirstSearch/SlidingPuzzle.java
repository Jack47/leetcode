package BreadthFirstSearch;

import java.util.TreeMap;

public class SlidingPuzzle {
    int puzzle2int(int[][] board) {
        int ret = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                ret = ret*10 + board[i][j];
            }
        }
        return ret;
    }
    public int slidingPuzzle(int[][] board) {
        // puzzle2int -> mini steps to solve
        TreeMap<Integer, Integer> solved = new TreeMap<Integer, Integer>();
        int maxCount = board.length*board[0].length;
        int maxSteps = 0;
        for(int i = maxCount; i >= 2; i--) {
            maxSteps *= i;
        }
        int count = 1;
        int dst = puzzle2int(board);
        System.out.printf("dst: %d", dst);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(count < maxCount) {
                    board[i][j] = count++;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        solved.put(puzzle2int(board), 0);
        return bfs(dst, board, board.length-1, board[0].length-1, 0, solved, maxSteps);
    }
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    //
    void swap(int[][]board, int i, int j, int ni, int nj) {
        int t = board[ni][nj];
        board[i][j] = t;
        board[ni][nj] = 0;
    }
    int bfs(int dst, int[][]board, int row, int col, int curStep, TreeMap<Integer, Integer> solved, int maxSteps) {
        System.out.printf("curStep\t", curStep);
        if(solved.get(dst) != null) {
            return solved.get(dst);
        }
        if (curStep > maxSteps) {
            return -1;
        }
        for(int[] dir : directions) { // swap with adjacent cell
            int nrow = row +dir[0];
            int ncol = col+dir[1];
            if(nrow >=0 && nrow < board.length &&
                    ncol >=0 && ncol < board[0].length) {
                swap(board, row, col, nrow, ncol);
                int nid = puzzle2int(board);
                if(solved.get(nid) == null) { // new step
                    solved.put(nid, curStep + 1);
                    if(nid == dst) {
                        return curStep+1;
                    }
                    int ret = bfs(dst, board, nrow, ncol, curStep+1, solved, maxSteps);
                    if(ret > 0) {
                        return ret;
                    }
                    solved.remove(nid); // backtrack
                }
                swap(board, nrow, ncol, row, col); // backtrack
            }
        }
        return -1;
    }
}
