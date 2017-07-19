package Array;

import java.util.HashMap;

public class MaximumSizeSubarraySum {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = Math.max(max, i + 1); // Although we may have sum - k == 0 exists in map,
                // but this choice should be the maximum
            } else if (map.containsKey(sum - k)) {
                int m = map.get(sum - k);
                max = Math.max(max, i - m);
            }
            map.put(sum, i);
        }

        return max;
    }
}