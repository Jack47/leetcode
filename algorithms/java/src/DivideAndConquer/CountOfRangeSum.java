package DivideAndConquer;

import java.util.Arrays;

public class CountOfRangeSum {
    int lower, upper;

    // sum range of [s+1, e]
    int mergeCount(long[] sums, int s, int e) {
        if (s >= e) return 0;
        int m = s + (e - s) / 2;
        int count = 0;
        count += mergeCount(sums, s, m);
        count += mergeCount(sums, m+1, e);
        int i = m+1, j = m+1;
        for (int left = s; left <= m; left++) {
            while (i <= e && sums[i] - sums[left] < lower) i++; // we needs bigger
            while (j <= e && sums[j] - sums[left] <= upper) j++; // [, j-1] , j
            count += j - i;
        }
        Arrays.sort(sums, s, e+1);
        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1]; // [0,1,..n]
        // sums[0] is zero, it can help use a lot
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        this.lower = lower;
        this.upper = upper;

        return mergeCount(sums, 0, sums.length-1); //
    }
}
