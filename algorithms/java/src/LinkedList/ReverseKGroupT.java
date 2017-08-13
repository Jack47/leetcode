package LinkedList;

public class ReverseKGroupT {
    public ListNode reverseKGroupNonRecursive(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        if(k >= len || k == 1) return head;

        int groups = len/k;
        cur = head;
        ListNode dummy = new ListNode(0);
        ListNode preTail = dummy; // tail of the previous group
        ListNode pre = null;
        while(groups > 0) {
            len = 0;
            ListNode next = null;
            head = cur;
            while(len < k) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                len++;
            }
            preTail.next = pre; // link previous two groups
            preTail = head; // new
            groups--;
        }
        preTail.next = cur;
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count < k) {
            count++;
            cur = cur.next;
        }
        if(count < k) {
            return head;
        }

        cur = head;
        ListNode prev = null;

        while(count > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }

        head.next = reverseKGroup(cur, k); //
        return prev;
    }
}
