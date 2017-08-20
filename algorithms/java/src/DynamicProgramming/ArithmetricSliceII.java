package DynamicProgramming;

import java.util.HashMap;

public class ArithmetricSliceII {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                long diff = (long)nums[j] - nums[i];
                if(diff < Integer.MAX_VALUE && diff > Integer.MIN_VALUE) {
                    int d = (int) diff;
                    int pre = dp[j].getOrDefault(d, 0);
                    int cur = dp[i].getOrDefault(d, 0) + (pre + 1);
                    if(pre +1 >= 2) { // length must >= 3
                        count += pre; //
                    }
                    dp[i].put(d, cur);
                }
            }
        }
        return count;
    }
}
