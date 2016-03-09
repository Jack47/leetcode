package LinkedList;

/**
 * Sort a linked list using insertion sort
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode nextNode = insertionSortList(head.next);
        ListNode prevNode = null;
        ListNode newHead = (nextNode != null && nextNode.val < head.val) ? nextNode : head;

        while(nextNode!= null && nextNode.val < head.val) {
            prevNode = nextNode;
            nextNode = nextNode.next;
        }
        if (prevNode != null) {
            prevNode.next = head;
        }
        head.next = nextNode;
        return newHead;
    }
}
