package BinaryTree;

import java.util.*;

public class InOrderTraversal {
    public List<Integer> inorderTraversalNonRecursive(TreeNode root) {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode lastPop = root;
        s.push(root);
        while(!s.isEmpty()) {
            root = s.peek();
            if(root.left != null && lastPop != root.left && lastPop != root.right) {
                s.push(root.left);
            } else if(root.right != null && lastPop != root.right && (root.left == null || lastPop == root.left)) {
                result.add(root.val);
                s.push(root.right);
            } else {
                lastPop = s.pop();
                if(lastPop.right == null) {
                    result.add(lastPop.val);
                }
            }
        }
        return result;
    }
}
