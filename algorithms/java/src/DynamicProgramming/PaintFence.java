package DynamicProgramming;

public class PaintFence {
    public int numWays(int n, int k) {
        if(k == 0 || n == 0) return 0;
        int keep = 0;
        int change = k;
        for(int i = 2; i <= n; i++) {
            int t = keep;
            keep = change;
            change = t * (k-1) + change*(k-1);
        }
        return keep+change;
    }
}
