package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZeroOneMatrix {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) return matrix;
        Deque<int[]> q = new ArrayDeque<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int level = 0;
        int[][] ret = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // start position/level
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                size--;
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                ret[x][y] = level;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        // there contains duplicate cells
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            level++;
        }
        return ret;
    }
}
