package Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

// Least Frequently Used cache
// Design and implement a data structure for Least Frequently Used(LFU) cache. It should support
// the following operations: get and put
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
// otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache
// reaches its capacity, it should invalidate the least frequently used items before inserting a
// new item. For the purpose of this problem, when there is a tie (i.e.,
// two or more keys that have the same frequency), the least recently used key would be evicted.
public class LFUCache {
    protected class FreqNode {
        public FreqNode(int freq) {
            this.keys = new LinkedHashSet<Integer>();
            this.freq = freq;
            this.prev = null;
            this.next = null;
        }

        public LinkedHashSet<Integer> keys;
        public int freq;
        public FreqNode prev; // store prev FreqNode which has lower freq than this item.
        public FreqNode next; // store next FreqNode which has high freq than this item.
    }

    protected int capacity;
    protected FreqNode head; // store the head of the FreqNodes
    protected HashMap<Integer, Integer> values;
    protected HashMap<Integer, FreqNode> freqNodes; // fast retrieve (O(1)) one key's current
    // FreqNode

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        values = new HashMap<Integer, Integer>();
        freqNodes = new HashMap<Integer, FreqNode>();
    }

    public int get(int key) {
        if (values.get(key) == null) {
            return -1;
        }

        // Don't need freqNodes.remove(key) here,
        // Because freqNodes.put(key, freqNode.next) will override the original value;
        increaseFreq(key);
        return values.get(key);
    }
    // increase key's frequency
    // freqNode is used to quickly find key's neighbour
    protected void increaseFreq(int key) {
        FreqNode freqNode = freqNodes.get(key);
        if (freqNode.next != null && freqNode.next.freq == freqNode.freq + 1) {
            freqNode.next.keys.add(key);
        }
        else { //(freqNode.next == null || freqNode.next.freq > freqNode.freq)
            FreqNode tmp = new FreqNode(freqNode.freq + 1);
            tmp.keys.add(key);
            tmp.next = freqNode.next;
            tmp.prev = freqNode;
            if(freqNode.next != null) {
                freqNode.next.prev = tmp;
            }
            freqNode.next = tmp;
        }
        // Don't need freqNodes.remove(key) here,
        // Because freqNodes.put(key, freqNode.next) will override the original value;
        freqNodes.put(key, freqNode.next);

        deleteFromFreqNode(key, freqNode);
    }
    // delete key from freqNode and freqNodes
    protected void deleteFromFreqNode(int key, FreqNode freqNode) {
        freqNode.keys.remove(key);
        // un-reference this empty freqNode
        if (freqNode.keys.isEmpty()) {
            if (freqNode == head) {
                head = head.next;
            }
            if (freqNode.prev != null) {
                freqNode.prev.next = freqNode.next;
            }
            if (freqNode.next != null) {
                freqNode.next.prev = freqNode.prev;
            }
        }
    }
    protected void evictItem() {
        int evictKey = -1;
        for(int n : head.keys) {
            evictKey = n;
            break;
        }
        deleteFromFreqNode(evictKey, head);
        freqNodes.remove(evictKey);
        values.remove(evictKey);
    }
    protected void addToHead(int key) {
        if (head == null || head.freq > 0) {
            FreqNode n = new FreqNode(0);
            n.next = head;
            if (head != null) {
                head.prev = n;
            }
            head = n;
        }
        head.keys.add(key);
        freqNodes.put(key, head);
    }
    public void put(int key, int value) {
        if (capacity == 0) return;

        if(values.get(key) == null && capacity == values.size()) {
            evictItem();
        }
        // zero freq node
        if (values.get(key) == null) {
            addToHead(key);
        }
        values.put(key, value);

        increaseFreq(key);
    }
}
