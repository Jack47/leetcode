package BinaryTree;

public class ConvertSortedListToBinarySearchTree {
    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }
    TreeNode construct(ListNode head, int len) {
        if(len == 1) return new TreeNode(head.val);
        if(len == 0) return null;

        int median = 0 + (len-1)/2;
        ListNode cur = head;
        int count = 0;
        while(count < median) {
            count++;
            cur = cur.next;
        }
        TreeNode root = new TreeNode(cur.val);
        root.left = construct(head, median);
        root.right = construct(cur.next, len-median-1);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }

        return construct(head, len);
    }
}
