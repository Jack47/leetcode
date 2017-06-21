package LinkedList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(2);
        dummyHead.next = head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = dummyHead;

        while(second != null) {
            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
            first = prev.next;
            second = first != null ? first.next : null;
        }
        return dummyHead.next;
    }
}
