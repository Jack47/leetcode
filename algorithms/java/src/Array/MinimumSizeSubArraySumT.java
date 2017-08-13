package Array;

import java.util.Arrays;
import java.util.TreeMap;

public class MinimumSizeSubArraySumT {
    public int minSubArrayLenTreeMap(int s, int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                min = Math.min(min, i + 1);
            }
            Integer n = map.floorKey(sum - s);
            if (n != null) {
                int j = map.get(n);
                min = Math.min(i - j, min);
            }
            map.put(sum, i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLenT(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                sum[i] = sum[i - 1] + nums[i];
            }
            if (sum[i] < s) continue;
            min = Math.min(min, i + 1);

            int n = Arrays.binarySearch(sum, 0, i, sum[i] - s);
            if (n >= 0) {
                min = Math.min(i - n, min);
            }
            if (n <= -2) {
                n = -n - 1; // -1 => 0, -2 => 1
                min = Math.min(i - n + 1, min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(j < nums.length) {
            if (j > 0) {
                sum[j] = sum[j - 1] + nums[j];
            }
            while(i <= j && sum[j]-sum[i] + nums[i] >= s) {
                min = Math.min(j-i+1, min);
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
