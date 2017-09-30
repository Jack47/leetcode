package Greedy;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int end = pairs[0][1];
        int max = 1;
        int n = pairs.length;
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > end) {
                max++;
                end = pairs[i][1];
            } // else interleaving and pairs[i][1] >= end
        }
        return max;
    }
}
