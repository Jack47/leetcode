package SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * If the tree is symmetric tree, then elements in every level is also symmetric.
 * So visit the three according to level order, then judge if every level is symmetric
 *
 * We can also use two queue to store the root's left and right nodes we need to judge.
 * In this way, we can avoid call isArraySymmetic;
 */
public class SymmetricTreeIterativeSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        int count = 1;
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            TreeNode node = levelQueue.poll();
            count--;
            if (node != null) {
                levelQueue.add(node.left);
                levelQueue.add(node.right);
            }
            if (count == 0 && levelQueue.size() > 0) {
                if (!isArraySymmetic(levelQueue.toArray(new TreeNode[levelQueue.size()]))) {
                    return false;
                }
                count = levelQueue.size();
            }
        }
        return true;
    }

    protected boolean isArraySymmetic(TreeNode[] array) {
        assert array != null;
        if (array.length == 0 || array.length == 1) return true;
        for (int i = 0; i < (array.length + 1) / 2; i++) {
            TreeNode node1 = array[i];
            TreeNode node2 = array[array.length - 1 - i];
            if (node1 != node2) {
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val){
                    return false;
                }
            }
        }
        return true;
    }
}
