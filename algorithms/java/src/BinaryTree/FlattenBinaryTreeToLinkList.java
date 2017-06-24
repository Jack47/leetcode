package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkList {
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new LinkedList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null) {
            nodes.add(root);
            if (root.left != null) {
                s.push(root);
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else { //
                do {
                    root = s.isEmpty() ? null : s.pop().right;
                } while (root == null && !s.isEmpty());
            }
        }
        TreeNode dummyHead = new TreeNode(0);
        TreeNode pre = dummyHead;
        for (TreeNode c : nodes) {
            c.left = null;
            c.right = null;
            pre.right = c;
            pre = c;
        }
        dummyHead.right = null;
    }
}
