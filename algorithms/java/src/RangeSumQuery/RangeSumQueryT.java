package RangeSumQuery;

public class RangeSumQueryT {
    class TreeNode {
        int sum;
        int start;
        int end;
        TreeNode left, right;

        TreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    int[] nums;
    TreeNode root;

    TreeNode construct(int s, int e) {
        if (s > e) return null;
        if (s == e) return new TreeNode(s, e, nums[s]);
        TreeNode root = new TreeNode(s, e, 0);
        // it's a full binary tree, so at here the left and right child must both exist
        int m = s + (e - s) / 2;
        root.left = construct(s, m);
        root.right = construct(m + 1, e);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    int getSum(TreeNode root, int s, int e) {
        if (s == root.start && e == root.end) return root.sum;
        int m = root.start + (root.end-root.start) / 2;
        if (s > m) {
            return getSum(root.right, s, e);
        } else if (e <= m) {
            return getSum(root.left, s, e);
        } else {
            return getSum(root.left, s, m) + getSum(root.right, m + 1, e);
        }
    }

    void update(TreeNode root, int i, int delta) {
        root.sum += delta;
        if (root.start == root.end) { // i must == root.start
            return;
        }
        int m = root.start + (root.end - root.start) / 2;

        if (i <= m) {
            update(root.left, i, delta);
        } else {
            update(root.right, i, delta);
        }
    }

    public void update(int i, int val) {
        int delta = val - this.nums[i];
        update(root, i, delta);
        this.nums[i] = val;
    }

    public RangeSumQueryT(int[] nums) {
        this.nums = nums;
        root = construct(0, nums.length - 1);
    }
    public int sumRange(int i, int j) {
        if(root == null) return -1;
        return getSum(root, i, j);
    }
}
