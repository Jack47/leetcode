package BinaryTree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> result = new ArrayList<>();
        boolean left = true;
        while (!q.isEmpty()) {
            int size = q.size();
            result.clear();
            while (size > 0) {
                root = q.poll();
                if(left) {
                    result.add(root.val);
                } else {
                    result.add(0, root.val);
                }

                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }

                size--;
            }

            results.add(new ArrayList<>(result));
            left = !left;
        }
        return results;
    }
}
