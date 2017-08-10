package BinaryTree;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        innerMaxPathSum(root);
        return max;
    }

    int innerMaxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = innerMaxPathSum(root.left);
        int right = innerMaxPathSum(root.right);
        int down = Math.max(left + right + root.val, Math.max(left+root.val, right+root.val));
        int up = Math.max(left + root.val, Math.max(root.val, right + root.val));
        max = Math.max(max, Math.max(down, up));

        return up;
    }
}
