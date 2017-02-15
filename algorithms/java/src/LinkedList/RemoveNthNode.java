package LinkedList;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Given a linked list, remove the nth node from the end of list and return its head
public class RemoveNthNode {
    private int n;
    private int reverseDepth;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        this.reverseDepth = 0;
        return visit(head);
    }

    private ListNode visit(ListNode head) {
        if (head != null) {
            ListNode next = visit(head.next);
            this.reverseDepth++;
            if (this.reverseDepth == this.n) {
                return next;
            } else {
                head.next = next;
            }
        }
        return head;
    }
}
