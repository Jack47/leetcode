package LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointerT {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode root = new RandomListNode(0); // dummy head;
        RandomListNode prev = root;
        RandomListNode t = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while(t != null) {
            prev.next = new RandomListNode(t.label);
            map.put(t, prev.next);
            prev = prev.next;
            t = t.next;
        }
        t = head;
        RandomListNode cur = root.next;
        while(cur != null) {
            cur.random = map.get(t.random);
            t = t.next;
            cur = cur.next;
        }
        return root.next;
    }
}
