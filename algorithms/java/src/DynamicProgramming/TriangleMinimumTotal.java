package DynamicProgramming;

import java.util.List;

public class TriangleMinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size()];
        int minimum = Integer.MAX_VALUE;
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> elem = triangle.get(i);
            for (int j = elem.size()-1; j >= 0; j--) {
                int small = Integer.MAX_VALUE;
                if (j >= 1) {
                    small = Math.min(small, dp[j - 1] + elem.get(j));
                }
                if (j <= i-1) {
                    small = Math.min(small, dp[j] + elem.get(j));
                }
                dp[j] = small;
            }
        }
        for(int m : dp) {
            minimum = Math.min(m, minimum);
        }
        return minimum;
    }
}
