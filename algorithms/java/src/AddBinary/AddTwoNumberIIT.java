package AddBinary;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumberIIT {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        while(l1 != null) {
            s1.offerLast(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.offerLast(l2.val);
            l2 = l2.next;
        }

        ListNode next = null;
        int carrier = 0;
        while(s1.size() > 0 || s2.size() > 0) {
            int n;
            if(s1.size() > 0 && s2.size() > 0) {
                n = carrier + s1.pollLast() + s2.pollLast();
            } else if(s1.size() > 0) {
                n = carrier + s1.pollLast();
            } else {
                n = carrier + s2.pollLast();
            }
            ListNode cur = new ListNode(n%10);
            cur.next = next;
            next = cur;
            carrier = n/10; // 0 or 1
        }
        if (carrier > 0) {
            ListNode cur = new ListNode(carrier);
            cur.next = next;
            next = cur;
        }
        return next;
    }
}
