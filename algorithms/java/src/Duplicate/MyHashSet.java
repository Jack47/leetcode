package Duplicate;

public class MyHashSet {

    protected class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    protected Node[] buckets;
    // buckets number
    protected int capacity;
    // elements number
    protected int size;

    public MyHashSet(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        buckets = new Node[capacity];
        this.capacity = capacity;
    }

    /**
     * add Integer to HashSet
     *
     * @param val
     * @return true if val added or false if it already exist.
     */
    public boolean add(Integer val) {
        int bin = getBin(val);
        if (buckets[bin] == null) {
            buckets[bin] = new Node(val);
            size++;
            return true;
        }
        Node prev = null;
        Node node = buckets[bin];
        while (node != null && node.val != val) {
            prev = node;
            node = node.next;
        }
        if (node != null) return false;
        prev.next = new Node(val);
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Integer val) {
        int bin = getBin(val);
        if (buckets[bin] == null) {
            return false;
        }
        Node node = buckets[bin];
        while (node != null && node.val != val) {
            node = node.next;
        }
        if (node != null) return true;
        return false;
    }

    public boolean remove(Integer val) {
        int bin = getBin(val);
        if (buckets[bin] == null) {
            return false;
        }
        Node prev = null;
        Node node = buckets[bin];
        while (node != null && node.val != val) {
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

    protected int getBin(Integer val) {
        return Math.abs(val.hashCode()) % capacity;
    }
}
