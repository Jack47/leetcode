package LinkedList;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) { // have k nodes, satisfy condition
            ListNode c = head;
            ListNode prev = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode t = c.next;
                c.next = prev;
                prev = c;
                c = t;
            }
            head = prev;
        }
        return head; // the old head if doesn't have k nodes, else return new head.
    }
}
