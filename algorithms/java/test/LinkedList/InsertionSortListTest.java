package LinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsertionSortListTest {
    @Test
    public void test() {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode head = null;
        ListNode result = insertionSortList.insertionSortList(head);
        assertEquals(null, result);

        head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(0);
        result = insertionSortList.insertionSortList(head);
        assertEquals(0, result.val);
        assertEquals(1, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);

        head = new ListNode(4);
        head.next = new ListNode(19);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(-3);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next = new ListNode(15);
        result = insertionSortList.insertionSortList(head);
        assertEquals(-3, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
        assertEquals(8, result.next.next.next.next.next.val);
        assertEquals(11, result.next.next.next.next.next.next.val);
        assertEquals(14, result.next.next.next.next.next.next.next.val);
        assertEquals(15, result.next.next.next.next.next.next.next.next.val);
        assertEquals(19, result.next.next.next.next.next.next.next.next.next.val);
    }
}
