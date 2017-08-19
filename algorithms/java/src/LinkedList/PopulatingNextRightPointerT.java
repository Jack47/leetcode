package LinkedList;

public class PopulatingNextRightPointerT {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode nextLevel = root.left;
        TreeLinkNode curLevel = root;
        while (nextLevel != null) {
            while (curLevel != null) {
                curLevel.left.next = curLevel.right;
                if (curLevel.next != null) {
                    curLevel.right.next = curLevel.next.left;
                }
                curLevel = curLevel.next;
            }
            curLevel = nextLevel;
            nextLevel = nextLevel.left;
        }
    }
}
