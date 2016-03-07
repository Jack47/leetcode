package SegmentTree;

/**
 * Min SegmentTree implementation.
 *
 */
public class SegmentTree {
    // Binary indexed tree
    protected int[] trees;
    protected int[] nums;

    public SegmentTree(final int[] nums) {
        if (nums.length == 0) return;

        // height is begin from 0.
        int height = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));
        int maximumNodes = (int) (Math.pow(2, height + 1) - 1);
        // Only use trees[1..]
        trees = new int[maximumNodes + 1];
        this.nums = nums;
        construct(1, nums.length, 1);
    }

    int construct(int i, int j, int count) {
        if (i == j) {
            trees[count] = i;
        } else {
            int median = i + (j - i) / 2;
            int left = construct(i, median, 2 * count);
            int right = construct(median + 1, j, 2 * count + 1);
            int min = Math.min(nums[left - 1], nums[right - 1]);
            trees[count] = nums[left - 1] == min ? left : right;
        }
        return trees[count];
    }

    int query(int i, int j) {
        // if (i == j) return nums[i];

        return nums[query(i + 1, j + 1, 1, nums.length, 1) - 1];
    }

    int query(int i, int j, int currentI, int currentJ, int count) {
        int median = currentI + (currentJ - currentI) / 2;
        if (currentI == i && currentJ == j) return trees[count];
        // Go left
        if (j <= median) {
            return query(i, j, currentI, median, 2 * count);
        } else if (i > median) {
            return query(i, j, median + 1, currentJ, 2 * count + 1);
        } else {
            int left = query(i, median, currentI, median, 2 * count);
            int right = query(median + 1, j, median + 1, currentJ, 2 * count + 1);
            int min = Math.min(nums[left - 1], nums[right - 1]);
            return nums[left - 1] == min ? left : right;
        }
    }
}
