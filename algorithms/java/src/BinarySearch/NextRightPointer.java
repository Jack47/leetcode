package BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode pre = null;
            while (size > 0) {
                TreeLinkNode c = q.poll();
                c.next = pre;
                pre = c.next;
                if (c.right != null) {
                    q.offer(c.right);
                }
                if (c.left != null) {
                    q.offer(c.left);
                }
            }
        }
    }
}
