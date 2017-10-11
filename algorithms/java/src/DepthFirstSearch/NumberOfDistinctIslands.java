package DepthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NumberOfDistinctIslands {
    int m, n;

    int[][] grid;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    List<int[]> curPath;

    void normalize(List<int[]> island) {
        int x = island.get(0)[0];
        int y = island.get(0)[1];
        island.get(0)[0] = 0;
        island.get(0)[1] = 0;
        for (int i = 1; i < island.size(); i++) {
            island.get(i)[0] = island.get(i)[0] - x;
            island.get(i)[1] = island.get(i)[1] - y;
        }
    }

    String toString(List<int[]> island) {
        normalize(island);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < island.size(); i++) {
            int x = island.get(i)[0];
            int y = island.get(i)[1];
            int index = x * 50 + y;
            sb.append(Integer.toString(index) + ",");

        }
        return sb.toString();
    }

    void dfs(int x, int y) {
        visited[x][y] = true;
        curPath.add(new int[]{x, y});
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        HashSet<String> allPaths = new HashSet<>();
        curPath = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    curPath.clear();
                    dfs(i, j);
                    allPaths.add(toString(curPath));
                }
            }
        }
        return allPaths.size();
    }
}
