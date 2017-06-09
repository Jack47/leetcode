package LinkedList;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {this.label = x;}
};
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        RandomListNode next = null;
        // 1. copy list
        while(cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        // 2. link random pinter
        cur = head;
        while(cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        // 3. extract new nodes
        RandomListNode nhead = head.next;
        RandomListNode ncur = nhead;
        cur = head;

        while(cur != null) {
            ncur.next = ncur.next.next;
            cur.next = cur.next.next;
            ncur = ncur.next;
            cur = cur.next;
        }
        return nhead;
    }
}
