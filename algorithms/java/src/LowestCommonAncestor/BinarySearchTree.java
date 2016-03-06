package LowestCommonAncestor;

import TreeNode.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
public class BinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null) return q;
        if (q == null) return p;
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val == p.val || root.val == q.val) return root;
        else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else return root;
    }
}
