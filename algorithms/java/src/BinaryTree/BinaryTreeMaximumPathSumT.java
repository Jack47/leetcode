package BinaryTree;

public class BinaryTreeMaximumPathSumT {
    int max;

    int maxPathSumInner(TreeNode root) { // max value, included root
        if (root == null) return 0;
        int left = maxPathSumInner(root.left);
        int right = maxPathSumInner(root.right);
        int joinLeft = left + root.val;
        int joinRight = right + root.val;

        max = Math.max(left + right + root.val, max);
        max = Math.max(joinLeft, max);
        max = Math.max(joinRight, max);
        max = Math.max(root.val, max);
        return Math.max(root.val, Math.max(joinLeft, joinRight)); // return the max value
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumInner(root);
        return max;
    }
}
