package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    boolean isSymmetricInner(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricInner(left.left, right.right) && isSymmetricInner(left.right, right.left);
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetricInner(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }
}
