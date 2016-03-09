package LinkedList;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode current1 = head == l1 ? l1.next : l2.next;
        ListNode current2 = head == l1 ? l2 : l1;
        ListNode current = head;
        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }

            current = current.next;
        }
        if (current1 != null) current.next = current1;
        if (current2 != null) current.next = current2;

        return head;
    }
}
