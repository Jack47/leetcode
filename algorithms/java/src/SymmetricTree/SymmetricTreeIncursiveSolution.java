package SymmetricTree;

import TreeNode.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * If the tree is symmetric tree, then elements in every level is also symmetric.
 * So visit the three according to level order, then judge if every level is symmetric
 */
public class SymmetricTreeIncursiveSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelp(root.left, root.right);

    }
    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left != right) return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
