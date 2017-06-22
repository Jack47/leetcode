package BinaryTree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> s;
    TreeNode cur;
    public BSTIterator(TreeNode root){
        s = new Stack<TreeNode>();
        cur = root;
    }
    public boolean hasNext() {
        if(cur != null) {// visit left first
            while (cur.left != null) {
                s.push(cur);
                cur = cur.left;
            }
            return true;
        } else if(cur == null && !s.isEmpty()){ // visit parent
            cur = s.pop();
            return true;
        } else {
            return false;
        }
    }
    public int next() {
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
