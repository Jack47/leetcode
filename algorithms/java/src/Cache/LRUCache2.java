package Cache;

import java.util.HashMap;

public class LRUCache2 {
    class DLNode {
        int value;
        int key;
        DLNode next;
        DLNode prev;
        public DLNode(int k, int v) {
            key = k;
            value = v;
            next = prev = null;
        }
    }
    protected HashMap<Integer, DLNode> values;
    int capacity;
    DLNode head;
    DLNode tail;
    public LRUCache2(int capacity) {
        values = new HashMap<Integer, DLNode>();
        this.capacity = capacity;
        head = new DLNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        tail = new DLNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    protected void addToHead(DLNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    protected void remove(DLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        DLNode node = values.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }
    void put(int key, int value) {
        DLNode node = values.get(key);
        if (node == null) {
            if (values.size() == capacity) {
                values.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new DLNode(key, value);
        }  else { // only need to update value
            node.value = value;
            remove(node);
        }

        values.put(key, node);
        addToHead(node);
    }
}
