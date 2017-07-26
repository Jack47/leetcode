package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode lastPop = null;

        while(root != null) {
            s.push(root);
            if(root.left != null && lastPop != root.left) {
                s.push(root.left);
                lastPop = root.left;
            } else if(root.right != null && lastPop != root.right) {
                s.push(root.right);
                lastPop = root.right;
            } else {

            }
        }
        return result;
    }
}
