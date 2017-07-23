package DynamicProgramming;

public class FreedomTrail {
    String ring;
    String key;
    int[][] cache;

    int dfs(int p, int q) {
        if (p == key.length()) return 0;
        if (cache[p][q] > 0) return cache[p][q];

        int clockWiseStep = 0;
        int antiClockWiseStep = 0;
        int i, j;

        for (i = q; ring.charAt(i) != key.charAt(p); clockWiseStep++) {
            i = (i + 1) % ring.length();
        }

        for (j = q; ring.charAt(j) != key.charAt(p); antiClockWiseStep++) {
            j = (j - 1 + ring.length()) % ring.length();
        }

        if (i == j) {
            cache[p][q] = Math.min(clockWiseStep, antiClockWiseStep) + 1 + dfs(p + 1, i);
        } else {
            int c = clockWiseStep + 1 + dfs(p + 1, i);
            int a = antiClockWiseStep + 1 + dfs(p + 1, j);
            cache[p][q] = Math.min(c, a);
        }
        return cache[p][q];
    }

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        cache = new int[key.length()][ring.length()];
        return dfs(0, 0);
    }
}
