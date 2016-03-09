package LinkedList;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class ReverseLinkedListTest {
    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode current = new ListNode(2);
        root.next = current;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(4);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        root = reverseLinkedList.reverseList(root);
        assertEquals(4, root.val);
        assertEquals(3, root.next.val);
        assertEquals(2, root.next.next.val);
        assertEquals(1, root.next.next.next.val);
    }
}
