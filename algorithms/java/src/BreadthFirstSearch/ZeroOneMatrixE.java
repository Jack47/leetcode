package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZeroOneMatrixE {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrixE(int[][] matrix) {
        if (matrix.length == 0) return matrix;
        Deque<int[]> q = new ArrayDeque<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int level = 0;
        int[][] ret = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                    ret[i][j] = level;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size > 0) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                size--;
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && ret[nx][ny]
                            > level) {
                        ret[nx][ny] = Math.min(level, ret[nx][ny]);
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return ret;
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        // right-down
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE-1;
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]+1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]+1);
                    }
                }
            }
        }

        // left-up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]+1);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]+1);
                }
            }
        }
        return dp;
    }
}
