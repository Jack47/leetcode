package Duplicate;

public class MyHashMap {
    protected class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    protected Node[] buckets;
    // buckets number
    protected int capacity;
    // elements number
    protected int size;

    public MyHashMap(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        buckets = new Node[capacity];
        this.capacity = capacity;
    }

    /**
     * add <key, value>
     *
     * @param val
     * @return true if key added or false if it already exist.
     */
    public boolean add(Integer key, Integer val) {
        int bin = getBin(key);
        if (buckets[bin] == null) {
            buckets[bin] = new Node(key, val);
            size++;
            return true;
        }
        Node prev = null;
        Node node = buckets[bin];
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if (node != null) return false;
        prev.next = new Node(key, val);
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer get(Integer key) {
        int bin = getBin(key);
        if (buckets[bin] == null) {
            return null;
        }
        Node node = buckets[bin];
        while (node != null && node.key != key) {
            node = node.next;
        }
        if (node != null) return node.val;
        return null;
    }

    public boolean remove(Integer key) {
        int bin = getBin(key);
        if (buckets[bin] == null) {
            return false;
        }
        Node prev = null;
        Node node = buckets[bin];
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if (node != null) {
            if (prev == null) {
                buckets[bin] = null;
            }
            else {
                prev.next = node.next;
            }
            size--;
            return true;
        }
        return false;
    }

    public void clear() {
        for (Node node : buckets) {
            node = null;
        }
        size = 0;
    }

    protected int getBin(Integer key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
