package Duplicate;

import java.util.TreeSet;

public class ContainsDuplicateIIIT {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t < 0 || k >= nums.length) return false;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(set.size() > k +1) {
                set.remove(nums[i-k-1]);
            }
            Integer ceilKey = set.ceiling(nums[i]); // difference is at most t
            if (ceilKey != null && Math.abs(ceilKey-nums[i]) <= t) { // position difference
            // is at most k
                return true;
            }
            Integer floorKey = set.floor(nums[i]);
            if (floorKey != null && Math.abs(floorKey - nums[i]) <= k) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
