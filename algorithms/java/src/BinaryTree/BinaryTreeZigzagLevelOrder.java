package BinaryTree;

import java.util.*;

public class BinaryTreeZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrderI(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        boolean left = true;
        deque.add(root);
        int count = 1;
        int nextCount = 0;
        while (!deque.isEmpty()) {
            List<Integer> result = new ArrayList<Integer>(count);
            while (count > 0) {
                TreeNode c = left ? deque.pollFirst() : deque.pollLast();
                count--;
                result.add(c.value);
                if (left) {
                    if (c.left != null) {
                        deque.offerLast(c.left);
                        nextCount++;
                    }
                    if (c.right != null) {
                        deque.offerLast(c.right);
                        nextCount++;
                    }
                } else {
                    if (c.right != null) {
                        deque.offerFirst(c.right);
                        nextCount++;
                    }
                    if (c.left != null) {
                        deque.offerFirst(c.left);
                        nextCount++;
                    }
                }
            }
            ret.add(result);
            count = nextCount;
            nextCount = 0;
            left = !left;
        }
        return ret;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int size = 1;
        int nextSize = 0;
        boolean left = true;
        while (!q.isEmpty()) {
            nextSize = 0;
            List<Integer> res = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode c = q.poll();
                if (left) {
                    res.add(c.value);
                } else res.add(res.size() - 1, c.value);
                if (c.left != null) {
                    q.add(c.left);
                    nextSize++;
                }
                if (c.right != null) {
                    q.add(c.right);
                    nextSize++;
                }
                size--;
            }
            size = nextSize;
            result.add(res);
            left = !left;
        }
        return result;
    }
}
