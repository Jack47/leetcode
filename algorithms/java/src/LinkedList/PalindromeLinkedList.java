package LinkedList;

public class PalindromeLinkedList {
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if(head.next.next == null)  return head.val == head.next.val;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            slow = slow.next; // consume middle node when length is odd
        }
        ListNode nh = reverse(slow);
        ListNode c1 = head;
        ListNode c2 = nh;
        while (c2 != null && c1.val == c2.val) {
            c1 = c1.next;
            c2 = c2.next;
        }
        return c2 == null;
    }
}
