package BinaryTree;

import java.util.*;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        while (root != null) {
            if (root.left != null) { // visit left child, save parent
                s.push(root);
                root = root.left;
            } else {
                ret.add(root.val);
                // visit right child
                root = root.right;
                while (root == null && !s.isEmpty()) {
                    root = s.pop();
                    ret.add(root.val);
                    root = root.right;
                }
            }
        }
        return ret;
    }
}
