package BinaryTree;

import java.util.Stack;

public class ValidBinarySearchTree {
    public boolean isValidBSTNonRecursive(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root != null) {
            while (root != null) { // push parent, visit left child
                s.push(root);
                root = root.left;
            }
            while (root == null && !s.isEmpty()) {
                root = s.pop();
                if (pre != null && pre.val >= root.val) return false;
                pre = root;
                root = root.right; // try right side
            }
        }
        return true;
    }
    TreeNode pre;
    boolean isValid(TreeNode root) {
        if(root == null) return true;
        boolean left = isValid(root.left);
        if(!left) return false;
        if(pre != null && root.val <= pre.val) return false;
        pre = root;
        return isValid(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        pre = null;
        // return isValid(root);
        return isValidBST(root, null, null);
    }
    boolean isValidBST(TreeNode root, Integer lowBound, Integer hiBound) {
        if(root == null) return true;
        if(lowBound != null && lowBound >= root.val) return false;
        if(hiBound != null && hiBound <= root.val) return false;
        return isValidBST(root, lowBound, root.val) && isValidBST(root, root.val, hiBound);
    }
}
