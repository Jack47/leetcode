package SegmentTree;

import java.util.HashSet;

public class CountOfRangeSums {
    class TreeNode {
        long lower, upper;
        int count;
        TreeNode left, right;

        TreeNode(long lower, long upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    // s, e is the index of vals
    TreeNode constructSGT(Long[] vals, int s, int e) {
        if (s > e) return null;
        if (s == e) return new TreeNode(vals[s], vals[e]);
        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode(vals[s], vals[e]);
        root.left = constructSGT(vals, s, m);
        root.right = constructSGT(vals, m + 1, e);
        return root;
    }

    void update(TreeNode root, long val) {
        root.count++; // may have duplicate, so should not be root.count = 1
        if (root.lower == root.upper) {
            return;
        }
        if (val <= root.left.upper) {
            update(root.left, val);
        } else {
            update(root.right, val);
        }
    }

    int search(TreeNode root, long lower, long upper) {
        if(root == null || lower > root.upper || upper < root.lower) return 0;
        if (lower <= root.lower && upper >= root.upper) return root.count;
        long m = root.left.upper;
        if (lower >= m + 1) {
            return search(root.right, lower, upper);
        } else if (upper <= m) {
            return search(root.left, lower, upper);
        } else {
            return search(root.left, lower, m) + search(root.right, m + 1, upper);
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;
        HashSet<Long> sums = new HashSet<>(nums.length + 1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums.add(sum);
        }
        Long[] allSum = new Long[sums.size()];
        // Why must be 'Long' instead of 'long'
        allSum = sums.toArray(allSum);
        TreeNode root = constructSGT(allSum, 0, allSum.length - 1);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, sum); // sum[i]
            sum -= nums[i]; // sum[i-1]
            count += search(root, lower + sum, upper + sum);
        }
        return count;
    }
}
