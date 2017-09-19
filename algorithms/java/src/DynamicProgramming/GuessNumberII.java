package DynamicProgramming;

public class GuessNumberII {
    int[][] cache;
    int minCost(int i, int j) {
        // i==j: we can guess with one shot
        // i > j: this is abnormal case
        if(i >= j) return 0;
        if(cache[i][j] > 0) return cache[i][j];
        int result = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            int cost = k + Math.max(minCost(i, k-1), minCost(k+1, j));
            result = Math.min(cost, result);
        }
        cache[i][j] = result;
        return result;
    }
    public int getMoneyAmount(int n) {
        cache = new int[n+1][n+1];
        return minCost(1, n);
    }
}
