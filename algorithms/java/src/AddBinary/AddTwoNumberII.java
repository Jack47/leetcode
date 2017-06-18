package AddBinary;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumberII {
    ListNode result;

    int getLen(ListNode cur) {
        int ret = 0;
        while (cur != null) {
            ret++;
            cur = cur.next;
        }
        return ret;
    }

    int add(ListNode c1, ListNode c2) {
        int carrier = 0;
        if (c1.next != null) {
            carrier = add(c1.next, c2.next);

        }
        int sum = c1.val + c2.val + carrier;
        int val = sum % 10;
        carrier = sum / 10;
        ListNode h = new ListNode(val);
        h.next = result;
        result = h;
        return carrier;
    }

    int addCarrier(ListNode l1, int delta, int c) {
        if (delta == 0) return c;
        int carrier = c;
        if (delta > 1) {
            carrier = addCarrier(l1.next, delta - 1, c);
        }
        int sum = l1.val + carrier;
        ListNode t = new ListNode(sum % 10);
        t.next = result;
        result = t;
        carrier = sum / 10;
        return carrier;
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        if (len1 < len2) {
            ListNode t = l1;
            l1 = l2;
            l2 = t;
            int len = len1;
            len1 = len2;
            len2 = len;
        }
        int delta = len1 - len2;
        ListNode cur1 = l1;
        while (delta > 0) {
            cur1 = cur1.next;
            delta--;
        }
        int carrier = add(cur1, l2);
        if (carrier > 0) {
            carrier = addCarrier(l1, len1 - len2, carrier);
            if (carrier > 0) {
                ListNode t = new ListNode(carrier);
                t.next = result;
                result = t;
            }
        }

        return result;
    }

    // Very simply solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        ListNode c = l1;
        while (c != null) {
            s1.push(c.val);
            c = c.next;
        }
        c = l2;
        while (c != null) {
            s2.push(c.val);
            c = c.next;
        }
        int carrier = 0;
        ListNode result = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = 0;
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            sum += carrier;

            carrier = sum / 10;
            ListNode t = new ListNode(sum % 10);
            t.next = result;
            result = t;
        }
        if (carrier > 0) {
            ListNode t = new ListNode(carrier);
            t.next = result;
            result = t;
        }
        return result;
    }
}
