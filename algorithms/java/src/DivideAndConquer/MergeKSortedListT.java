package DivideAndConquer;

public class MergeKSortedListT {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode merge(ListNode[] lists, int s, int e) {
        if (s > e) return null;
        if (s == e) return lists[s];
        int m = s + (e - s) / 2;
        ListNode left = merge(lists, s, m);
        ListNode right = merge(lists, m + 1, e);
        ListNode head = new ListNode(0); // dummy head;
        ListNode pre = head;
        while (left != null || right != null) {
            if (right == null || left != null && left.val <= right.val) {
                pre.next = left;
                pre = pre.next;
                left = left.next;
            } else {
                pre.next = right;
                pre = pre.next;
                right = right.next;
            }
        }
        pre.next = null;
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
}
