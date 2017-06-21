package LinkedList;

public class PopulatingNextRightPointersII {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode prev = dummyHead;
        while(root != null) {
            while(root != null) { // iterate one level
                if(root.left != null) {
                    prev.next = root.left;
                    prev = root.left;
                }
                if(root.right != null) {
                    prev.next = root.right;
                    prev = root.right;
                }
                root = root.next;
            }
            root = dummyHead.next;
            dummyHead.next = null;
            prev = dummyHead;
        }
    }
}
