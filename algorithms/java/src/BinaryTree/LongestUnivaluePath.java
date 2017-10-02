package BinaryTree;

public class LongestUnivaluePath {
    int postOrderVisit(TreeNode root) {
        if (root == null) return 0;
        int left = postOrderVisit(root.left);
        int right = postOrderVisit(root.right);
        int cur = 1; // can always start from root
        int ret = 1;
        // join left child
        if (left > 0 && root.left.val == root.val) {
            cur += left;
            ret = left + 1;
        }
        // join right child
        if (right > 0 && root.right.val == root.val) {
            cur += right;
            // choose max of join left or right
            ret = Math.max(ret, right + 1);
        }
        max = Math.max(cur, max);
        return ret;
    }

    int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        postOrderVisit(root);
        return max - 1;
    }
}
