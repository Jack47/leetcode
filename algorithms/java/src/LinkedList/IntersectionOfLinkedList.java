package LinkedList;

public class IntersectionOfLinkedList {
    int getLen(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        while(lenA > lenB) {
            lenA--;
            headA = headA.next;
        }
        while(lenA < lenB) {
            lenB--;
            headB = headB.next;
        }
        while(headA != headB && headA != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA != headB ? null : headA;
    }
}
