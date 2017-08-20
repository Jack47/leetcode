package AddBinary;

public class AddTwoNumbersT {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int carrier = 0;
        while (l1 != null || l2 != null) {
            int n = 0;
            if (l1 != null && l2 != null) {
                n = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                n = l2.val;
                l2 = l2.next;
            } else {
                n = l1.val;
                l1 = l1.next;
            }
            n += carrier;
            carrier = n / 10;
            n = n % 10;
            pre.next = new ListNode(n);
            pre = pre.next;
        }
        if (carrier > 0) { // don't forget this carrier
            pre.next = new ListNode(carrier);
        }
        return dummy.next;
    }
}
