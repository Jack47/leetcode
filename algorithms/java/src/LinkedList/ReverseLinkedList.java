package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode node) {
        ListNode prevNode = null;
        ListNode currentNode = node;

        while(currentNode != null) {
            ListNode t = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = t;
        }

        return prevNode;
    }
}
