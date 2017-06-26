package SegmentTree;

public class RangeSumQuery {
    class SegmentTreeNode {
        SegmentTreeNode left, right;
        int start, end;
        int sum;

        SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    SegmentTreeNode root;

    public RangeSumQuery(int[] nums) {
        if(nums.length > 0) {
            root = buildTree(nums, 0, nums.length - 1); //
        }
    }

    SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) { // nums.length == 0;
            return null;
        }
        if(start == end) {
            return new SegmentTreeNode(start, end, nums[start], null, null);
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = buildTree(nums, start, mid);
        SegmentTreeNode right = buildTree(nums, mid + 1, end);
        return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
    }

    public void update(int i, int val) {
        if(root == null) return;
        update(root, i, val);
    }

    int update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end && root.start == i) {
            int delta = val - root.sum;
            root.sum = val;
            return delta;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i <= mid) {
            int delta = update(root.left, i, val);
            root.sum += delta;
            return delta;
        } else {
            int delta = update(root.right, i, val);
            root.sum += delta;
            return delta;
        }
    }

    public int sumRange(int i, int j) {
        if(root == null) return 0;
        return sumRange(root, i, j);
    }

    int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) return root.sum;
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start > mid) {
            return sumRange(root.right, start, end);
        } else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
    }
}
