package Duplicate;

import java.util.HashMap;
import java.util.TreeSet;

// https://leetcode.com/problems/contains-duplicate-iii/#/description
// 220 Contains duplicate III
// Difference between nums[i] and nums[j] is at most t  // difference between 0 and t are treat
// as same value
// Difference between i and j is at most k.  // k sized sliding window
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long reposition = nums[i] - Integer.MIN_VALUE;
            long bucket = reposition / (t + 1);
            if (map.get(bucket) != null || map.get(bucket - 1) != null && reposition - map.get
                    (bucket - 1) <= t || map.get(bucket+1) != null && map.get(bucket+1) - reposition <= t)
                return true;
            if (map.size() > k) {
                map.remove((nums[i - k] - Integer.MIN_VALUE) / (t + 1));
            }
            map.put(bucket, reposition);
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        return false;
    }
}
