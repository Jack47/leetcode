package LinkedList;

public class PopulatingNextRightPointerIIT {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curLevel = root;
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        while (curLevel != null) {
            TreeLinkNode pre = dummyHead;
            while (curLevel != null) {
                if(curLevel.left != null) {
                    pre.next = curLevel.left;
                    pre = curLevel.left;
                }
                if (curLevel.right != null) {
                    pre.next = curLevel.right;
                    pre = curLevel.right;
                }
                curLevel = curLevel.next;
            }
            curLevel = dummyHead.next;
            dummyHead.next = null;
        }
    }
}
