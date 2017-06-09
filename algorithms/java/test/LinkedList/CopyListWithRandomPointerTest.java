package LinkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CopyListWithRandomPointerTest {
    @Test
    public void test() {
        CopyListWithRandomPointer cp = new CopyListWithRandomPointer();
        RandomListNode head = new RandomListNode(2);
        head.next = new RandomListNode(3);
        head.next.next = new RandomListNode(4);
        head.random = head.next.next;

        RandomListNode nhead = cp.copyRandomList(head);
        assertEquals(2, nhead.label);
        assertEquals(4, nhead.random.label);
        assertEquals(3, nhead.next.label);
    }
}
