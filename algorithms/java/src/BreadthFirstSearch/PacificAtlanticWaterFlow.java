package BreadthFirstSearch;

import java.util.*;

public class PacificAtlanticWaterFlow {
    int[][] matrix;
    int m, n;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    void bfs(Deque<int[]> q, boolean[][] visited) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            // add unvisited neighbors to queue
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx <= m - 1 && ny >= 0 && ny <= n - 1 && !visited[nx][ny] &&
                        matrix[nx][ny] >= matrix[x][y]) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int height = matrix[x][y];
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx <= m - 1 && ny >= 0 && ny <= n - 1 &&
                    !visited[nx][ny] && matrix[nx][ny] >= height) {
                dfs(nx, ny, visited);
            }
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) return Collections.emptyList();
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pVisited);
            dfs(i, n - 1, aVisited);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pVisited);
            dfs(m - 1, j, aVisited);
        }

        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    public List<int[]> pacificAtlanticBfs(int[][] matrix) {
        if (matrix.length == 0) return Collections.emptyList();
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        Deque<int[]> pQueue = new ArrayDeque<>(m + n - 1);
        Deque<int[]> aQueue = new ArrayDeque<>(m + n - 1);
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            pQueue.offer(new int[]{0, j});
            aQueue.offer(new int[]{m - 1, j});
        }
        bfs(pQueue, pVisited);
        bfs(aQueue, aVisited);
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
}
