package BinaryTree;

import java.util.Stack;

public class BSTIteratorT {
    Stack<TreeNode> s;
    TreeNode lastPop;
    int nextVal;
    public BSTIteratorT(TreeNode root) {
        s = new Stack<>();
        if(root != null) {
            s.push(root);
            lastPop = root;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        boolean has = false;
        while(!s.isEmpty()) {
            TreeNode root = s.peek();
            if(root.left != null && lastPop != root.left && lastPop != root.right) {
                s.push(root.left);
            } else if(root.right != null && (root.left == null || lastPop == root.left) && lastPop != root.right) {
                nextVal = root.val;
                has = true;
                s.push(root.right);
                break;
            } else {
                root = s.pop();
                lastPop = root;
                if(root.right == null) {
                    nextVal = root.val;
                    has = true;
                    break;
                }
            }
        }
        return has;
    }

    /** @return the next smallest number */
    public int next() {
        return nextVal;
    }
}
