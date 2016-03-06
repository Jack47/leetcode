package RangeSumQuery;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * Given an integer array nums, find the sum of the elements between indices i and j, inclusive.
 * 1. You may assume that the array does not change
 * 2. There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    protected final int[] nums;
    // sums[i] means the sum between [0~i];
    protected int[] sums;
    boolean initialized;
    public RangeSumQueryImmutable(final int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        initialized = false;
    }

    public int sumRange(int i, int j) {
        if (!initialized) {
            int sum = 0;
            for(int k = 0; k < nums.length; k++) {
                sum += nums[k];
                sums[k] = sum;
            }
            initialized = true;
        }
        return sums[j] - ( i > 0 ? sums[i-1] : 0);
    }

}
