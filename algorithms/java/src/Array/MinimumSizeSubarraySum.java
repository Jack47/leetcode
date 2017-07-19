package Array;

import java.util.TreeMap;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length];
        int sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i <= nums.length - 1; i++) {
            sum += nums[i];
            sums[i] = sum;
            if (sum == s) {
                min = Math.min(i + 1, min);
            }
            int key = map.floorKey(sum - s);
            if (sum - key >= s) {
                min = Math.min(min, i - map.get(key));
            }
            map.put(sum, i);
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
