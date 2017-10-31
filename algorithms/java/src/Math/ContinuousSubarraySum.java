package Math;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum1(int[] nums, int k) {
        // corner case
        if (nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[] sums = new int[n + 1];
        if (k == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
            if (i > 0 && sums[i + 1] % k == 0) return true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int sum = sums[i + 1] - sums[j];
                if (sum % k == 0) return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = k == 0 ? sum : sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
