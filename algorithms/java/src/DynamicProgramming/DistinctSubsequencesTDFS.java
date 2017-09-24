package DynamicProgramming;

public class DistinctSubsequencesTDFS {
    String s, t;
    int[][] cache;

    int dfs(int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (cache[i][j] > 0) return cache[i][j] - 1;
        int count = 0;
        for (int k = i; k < s.length() && s.length() - k >= t.length() - j; k++) {
            if (s.charAt(k) == t.charAt(j)) {
                count += dfs(k + 1, j + 1);
            }
        }
        cache[i][j] = count + 1;
        return cache[i][j] - 1;
    }

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        if (s.length() == 0 || t.length() == 0) return 0;
        cache = new int[s.length()][t.length()];
        return dfs(0, 0);
    }
}
