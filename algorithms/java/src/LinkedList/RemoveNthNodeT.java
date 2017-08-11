package LinkedList;

public class RemoveNthNodeT {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        int count = 0;
        while(count < n-1) {
            fast = fast.next;
            count++;
        }
        while(fast !=null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
}
