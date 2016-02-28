package SumRootToLeafNumbers;

import TreeNode.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {
    protected int sum;
    public int sumNumbers(TreeNode root) {
        int num = 0;
        sum = 0;
        if (root != null) {
            visit(root, num);
        }
        return sum;
    }
    protected void visit(TreeNode root, int num) {
        if (root == null) return;

        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }

        visit(root.left, num);
        visit(root.right, num);
    }
}
