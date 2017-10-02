package DepthFirstSearch;

public class OutOfBoundaryPaths {

    int[][][] cache;

    int dfs(int i, int x, int y) {
        if (i == steps) {
            return 0;
        }
        if (cache[x][y][i] > 0) return cache[x][y][i] - 1;
        int count = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m &&
                    ny >= 0 && ny < n) {
                count += dfs(i + 1, nx, ny);
                count = count % Mod;
            } else {
                count++;
            }
        }
        cache[x][y][i] = count % Mod + 1;
        return cache[x][y][i] - 1;
    }

    public int findPathsDfs(int m, int n, int N, int i, int j) {
        this.m = m;
        this.n = n;
        this.steps = N;
        cache = new int[m][n][steps];
        return dfs(0, i, j);
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int Mod = (int) Math.pow(10, 9) + 7;
    int m, n, steps;

    public int findPaths(int m, int n, int N, int x, int y) {
        this.m = m;
        this.n = n;
        this.steps = N;

        int[][] dp = new int[m][n];
        dp[x][y] = 1; // start position
        int result = 0;
        for (int k = 0; k < N; k++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) { //
                        for (int[] dir : dirs) {
                            int nx = i + dir[0];
                            int ny = j + dir[1];
                            if (nx < 0 || nx == m ||
                                    ny < 0 || ny == n) {
                                result += dp[i][j] % Mod;
                                result = result % Mod;
                            } else {
                                temp[nx][ny] += dp[i][j] % Mod;
                                temp[nx][ny] = temp[nx][ny] % Mod;
                            }
                        }
                    }
                }
            }
            dp = temp;
        }
        return result;
    }
}
