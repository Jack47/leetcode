package DynamicProgramming;

import java.util.HashMap;

public class ArithmetricSliceIIT {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff < Integer.MAX_VALUE && diff > Integer.MIN_VALUE) {
                    int ndiff = (int) diff;
                    int cur = dp[i].getOrDefault(ndiff, 0);
                    int pre = dp[j].getOrDefault(ndiff, 0);
                    // delta = pre + 1
                    dp[i].put(i, cur + pre + 1);
                    if (pre + 1 >= 2) {
                        // 2 diff means 3 number, form a answer
                        count += pre + 1 - 1;
                    }
                }
            }
        }
        return count;
    }
}
