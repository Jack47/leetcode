package BinarySearch;

/**
 * Given a sorted array of integers, find the staring and ending position of a given target value
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * https://leetcode.com/problems/search-for-a-range/
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;
        int ret = -1;
        int start = 0;
        int end = nums.length - 1;
        do {
            ret = binarySearch(nums, start, end, target - 1);
            // search right region
            if (ret + 1 == nums.length) break;
            start = ret + 1;
        } while (nums[ret] != target);
        if (nums[ret] == target) {
            result[0] = ret;
        }

        start = 0;
        end = nums.length - 1;
        do {
            ret = binarySearch(nums, start, end, target + 1);
            // search left region
            if (ret - 1 < 0) break;
            end = ret - 1;
        } while (nums[ret] != target);
        if (nums[ret] == target) {
            result[1] = ret;
        }
        return result;
    }

    protected int binarySearch(int[] nums, int left, int right, int target) {
        int start = left;
        int end = right;
        while (start <= end) {
            int median = start + (end - start) / 2;
            if (nums[median] < target) {
                start = median + 1;
            } else if (nums[median] > target) {
                end = median - 1;
            } else {
                return median;
            }
        }
        return start > right ? right : start;
    }
}
