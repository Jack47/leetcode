package DepthFirstSearch;

public class KnightProbability {
    int[][] dirs = new int[][]{{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1,
            -2}};
    int k, n;
    long[][][] cache = new long[25][25][101];

    long dfs(int i, int x, int y) {
        if (i == k) {
            return 1;
        }
        if (cache[x][y][i] > 0) return cache[x][y][i] - 1;
        int count = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n) {
                count += dfs(i + 1, nx, ny);
            }
        }
        cache[x][y][i] = count + 1;
        return count;
    }

    public double knightProbabilityDfs(int N, int K, int r, int c) {
        k = K;
        n = N;
        long count = dfs(0, r, c);
        return count / Math.pow(8, k);
    }

    public double knightProbability(int N, int K, int r, int c) {
        k = K;
        n = N;
        double[][] dp = new double[n][n];
        dp[r][c] = 1;
        for (int s = 0; s < k; s++) {
            double[][] temp = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if (ni >= 0 && ni < n &&
                                    nj >= 0 && nj < n) {
                                temp[ni][nj] += dp[i][j];
                            }
                        }
                    }
                }
            }
            dp = temp;
        }
        double count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += dp[i][j];
            }
        }
        return count / Math.pow(8, k);
    }
}
