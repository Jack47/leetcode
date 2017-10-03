package Game;

public class GuessNumberIIT {
    int[][] cache;
    int minCost(int i, int j) {
        if(i >= j) { // got it
            return 0;
        }
        if(cache[i][j] > 0) return cache[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            int r = k + Math.max(minCost(i, k - 1), minCost(k+1, j));
            min = Math.min(r, min);
        }
        cache[i][j] = min;
        return min;
    }
    public int getMoneyAmount(int n) {
        cache = new int[n+1][n+1];
        return minCost(1, n);
    }
}
