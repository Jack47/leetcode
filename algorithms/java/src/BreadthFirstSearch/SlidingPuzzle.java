package BreadthFirstSearch;

import java.util.*;

public class SlidingPuzzle {
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

    class Context {
        int x,y; // coordinate of zero
        int[][]board;
        public Context(int x, int y, int[][]board) {
            this.x = x;
            this.y = y;
            this.board = board;
            assert(this.board[x][y] == 0);
        }
    }

    public int slidingPuzzle(int[][] board) {
        // puzzle2int -> mini steps to solve
        Map<String, Integer> solved = new HashMap<String, Integer>();
        int maxCount = board.length*board[0].length;
        int count = 1;
        String dst = Arrays.deepToString(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(count < maxCount) {
                    board[i][j] = count++;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        if (dst == Arrays.deepToString(board)) {
            return 0;
        }
        solved.put(Arrays.deepToString(board), 0); // avoid to fall back
        Deque<Context> q = new LinkedList<>();
        q.add(new Context(board.length-1, board[0].length-1, board)); // right bottom corner
        int curStep = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            curStep++;
            while(size > 0) {
                size--;
                Context ctx = q.poll();
                board = ctx.board;
                // collect candidates
                for (int[] dir : directions) { // swap with adjacent cell
                    int nrow = ctx.x+ dir[0];
                    int ncol = ctx.y+ dir[1];
                    if (nrow >= 0 && nrow < board.length &&
                            ncol >= 0 && ncol < board[0].length) {
                        swap(board, ctx.x, ctx.y, nrow, ncol);
                        String nid = Arrays.deepToString(board);
                        if (solved.get(nid) == null) { // prune, has new step
                            if(nid.equals(dst)) {
                                return curStep;
                            }
                            solved.put(nid, curStep);
                            int[][]newBoard = deepCopy(board);
                            q.add(new Context(nrow, ncol, newBoard));
                        }
                        swap(board, nrow, ncol, ctx.x, ctx.y); // backtrack
                    }
                }
            }
        }
        return -1;
    }
    int[][] deepCopy(int[][] board) {
        int[][] ret = new int[board.length][];
        for(int i = 0; i < board.length; ++i) {
            ret[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return ret;
    }
    void swap(int[][]board, int i, int j, int ni, int nj) {
        int tn = board[ni][nj];
        int t = board[i][j];
        board[i][j] = tn;
        board[ni][nj] = t;
    }
}
