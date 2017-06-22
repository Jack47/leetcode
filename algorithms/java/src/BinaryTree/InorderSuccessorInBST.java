package BinaryTree;

import java.util.Stack;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(p.right != null) { // right side's least number
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        } else { // need to find it's successor
            Stack<TreeNode> s = new Stack<TreeNode>();

            while(root != null && root != p) {
                if(root.val < p.val) {
                    root = root.right; // no successors
                } else {
                    s.push(root); // one of possible successors
                    root = root.left;
                }
            }
            return s.isEmpty() ? null : s.pop();
        }
    }
}
