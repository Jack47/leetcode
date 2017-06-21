package LinkedList;

public class PopulatingNextRightPointersInEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode prev = root;
        while(prev != null) {
            TreeLinkNode cur = prev; // it's the every level's leading node
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            prev = prev.left;
        }
    }
}
