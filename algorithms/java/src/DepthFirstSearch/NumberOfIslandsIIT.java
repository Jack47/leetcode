package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsIIT {
    int ij2Pos(int i, int j) {
        return i*this.board[0].length+ j + 1;
    }
    class IJ {
        int i;
        int j;
        public IJ(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    IJ pos2ij(int pos) {
        return new IJ((pos-1)/board[0].length, (pos-1)%board[0].length);
    }
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] board;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>(positions.length);
        board = new int[m][n];
        int count = 0;

        for(int[] pos : positions) {
            count++;
            int curParent = ij2Pos(pos[0], pos[1]); // new parent node
            board[pos[0]][pos[1]] = curParent;
            for(int[] dir : directions) {
                int i = pos[0]+dir[0];
                int j = pos[1]+dir[1];

                if(i >= 0 && i < board.length && j >=0 && j < board[0].length &&
                        board[i][j] > 0 && parent(i, j) != curParent) {// neighor exists and can union
                    int ijParent =  parent(i, j);// neighbor's parent node
                    count--;
                    IJ ij = pos2ij(curParent);
                    board[ij.i][ij.j] = ijParent;
                    curParent = ijParent;
                }
            }
            result.add(count);
        }
        return result;
    }
    int parent(int i, int j) {
        while(ij2Pos(i, j) != board[i][j]) { // not root
            IJ ij = pos2ij(board[i][j]);
            i = ij.i;
            j = ij.j;
        }

        return ij2Pos(i, j);
    }
}
