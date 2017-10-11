package DepthFirstSearch;

public class MaxAreaOfIsland {
    int[][] grid;
    int m, n;
    int max;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int count;
    void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n
                    && grid[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    // start an island
                    count = 0;
                    dfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}
