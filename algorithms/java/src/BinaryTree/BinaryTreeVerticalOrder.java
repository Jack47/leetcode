package BinaryTree;

import java.util.*;

public class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        TreeMap<Integer, List<Integer>> verticalMap = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qL = new LinkedList<>();
        q.add(root);
        qL.add(0); // start with level 0

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode n = q.poll();
                Integer level = qL.poll();
                List<Integer> r = verticalMap.getOrDefault(level, new ArrayList<Integer>());
                r.add(n.val);
                verticalMap.put(level, r);
                if (n.left != null) {
                    q.offer(n.left);
                    qL.offer(level - 1);
                }
                if (n.right != null) {
                    q.offer(n.right);
                    qL.offer(level + 1);
                }
                size--;
            }
        }
        List<List<Integer>> result = new ArrayList<>(verticalMap.size());
        for (Integer key : verticalMap.keySet()) {
            result.add(verticalMap.get(key));
        }
        return result;
    }
}
