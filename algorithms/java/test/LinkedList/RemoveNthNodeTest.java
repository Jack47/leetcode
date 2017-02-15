package LinkedList;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class RemoveNthNodeTest {
    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode current = new ListNode(2);
        root.next = current;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(4);

        RemoveNthNode remove = new RemoveNthNode();
        root = remove.removeNthFromEnd(root, 2);
        assertEquals(1, root.val);
        assertEquals(2, root.next.val);
        assertEquals(4, root.next.next.val);
        assertEquals(null, root.next.next.next);

        root = remove.removeNthFromEnd(root, 3);
        assertEquals(2, root.val);
        assertEquals(4, root.next.val);
        assertEquals(null, root.next.next);

        root = remove.removeNthFromEnd(root, 0);
        assertEquals(2, root.val);
        assertEquals(4, root.next.val);
        assertEquals(null, root.next.next);

        root = remove.removeNthFromEnd(root, 1);
        assertEquals(2, root.val);
        assertEquals(null, root.next);
    }
}
