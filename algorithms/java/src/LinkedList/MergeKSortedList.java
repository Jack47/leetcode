package LinkedList;

public class MergeKSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1 = cur1 != null ? cur1 : cur2;
        cur.next = cur1;
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        return mergeLists(lists, 0, lists.length-1);
    }
    public ListNode mergeLists(ListNode[] lists, int i, int j) {
        if (i > j) return null;
        if (i == j) return lists[i];
        if (j == i + 1) return mergeTwoLists(lists[i], lists[j]);
        else {
            int m = i + (j-i)/2;
            ListNode l1 = mergeLists(lists, i, m);
            ListNode l2 = mergeLists(lists, m+1, j);
            return mergeTwoLists(l1, l2);
        }
    }
}
