package LinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MergeTwoSortedListTest {
    @Test
    public void test() {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode listNode1 = null;
        ListNode listNode2 = null;
        ListNode result = mergeTwoSortedList.mergeTwoLists(listNode1, listNode2);
        assertEquals(null, result);

        listNode1 = new ListNode(1);
        listNode2 = null;
        result = mergeTwoSortedList.mergeTwoLists(listNode1, listNode2);
        assertEquals(listNode1, result);

        listNode1.next = new ListNode(3);
        listNode2 = new ListNode(-1);
        listNode1.next.next = new ListNode(5);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(4);
        result = mergeTwoSortedList.mergeTwoLists(listNode1, listNode2);
        assertEquals(listNode2, result);
        assertEquals(1, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
    }
}
