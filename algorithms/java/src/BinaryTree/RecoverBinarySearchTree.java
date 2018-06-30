package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree {
    TreeNode first, second, pre;

    void inOrderVisit(TreeNode root) {
        if (root == null) return;
        inOrderVisit(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
                // in case two adjacent cells are swapped
                second = root;
            } else { // non-adjacent cells are swapped
                second = root;
            }
        }
        pre = root;
        inOrderVisit(root.right);
    }

    public void recoverTreeON(TreeNode root) {
        if (root == null) return;
        inOrderVisit(root);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode lastPop = cur;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && (lastPop != cur.left && lastPop != cur.right)) {// push left
                stack.push(cur.left);
            } else if (cur.right != null && lastPop != cur.right && (cur.left == null || lastPop
                    == cur.left)) { // push right
                // visit cur
                stack.push(cur.right);
            } else { // pop
                // visit cur if it's left child
                lastPop = stack.pop();
            }
        }
    }
}
