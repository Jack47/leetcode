package DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopesT {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] length = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int h = envelopes[i][1];
            int idx = Arrays.binarySearch(length, 0, max, h);
            if (idx < 0) {
                idx = -idx - 1;
            }

            length[idx] = h;
            if(idx +1 > max) {
                max = idx+1;
            }
        }
        return max;
    }
}
