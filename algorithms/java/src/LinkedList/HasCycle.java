package LinkedList;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode c1 = head;
        ListNode c2 = head.next.next;
        while(c1 != null && c2 != null) {
            if(c1 == c2) return true;
            c1 = c1.next;
            c2 = c2.next != null ? c2.next.next : null;
        }
        return false;
    }
}
