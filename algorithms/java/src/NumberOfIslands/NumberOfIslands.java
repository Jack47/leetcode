package NumberOfIslands;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i,j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int ii = i;
            int jj = j;
            switch (k) {
                case 0:
                    ii++;break;
                case 1:
                    ii--;break;
                case 2:
                    jj++;break;
                case 3:
                    jj--;break;
            }
            if (ii >= 0 && ii < grid.length &&
                    jj >= 0 && jj < grid[0].length &&
                    !visited[ii][jj] && grid[i][j] == '1') {
                dfs(grid, ii, jj, visited);
            }
        }
    }
}
