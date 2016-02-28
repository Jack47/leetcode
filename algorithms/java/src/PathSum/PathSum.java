package PathSum;

import TreeNode.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int currentSum = 0;
        return visit(root, currentSum, sum);

    }
    public boolean visit(TreeNode root, int currentSum, int sum) {
        assert root != null;
        currentSum += root.val;
        if (root.left == null && root.right == null) {
            return currentSum == sum;
        }
        if ( root.left != null && visit(root.left, currentSum, sum) ||
             root.right != null && visit(root.right, currentSum, sum)) {
            return true;
        }
        return false;
    }
}
