package BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointerT {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        TreeLinkNode dummyNode = new TreeLinkNode(0);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode pre = dummyNode;
            while (size > 0) {
                TreeLinkNode cur = q.poll();
                pre.next = cur;
                pre = cur;
                if (cur.left != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
    }
}
