package Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LRUCache {
    protected HashMap<Integer, Integer> values;
    // this ordered hashset is used to store the priority according to element's visit time.
    protected LinkedHashSet<Integer> evictOrder;
    protected int capacity;

    public LRUCache(int c) {
        capacity = c;
        values = new HashMap();
        evictOrder = new LinkedHashSet();
    }
    void updateEvictOrder(int key) {
        evictOrder.remove(key);
        evictOrder.add(key);
    }
    int get(int key) {
        if(values.containsKey(key)) {
            updateEvictOrder(key);
            return values.get(key);
        }
        return -1;
    }
    void put(int key, int value) {
        if (!values.containsKey(key) && values.size() == capacity) {
            int evictKey = 0;
            for (int n: evictOrder) {
                evictKey = n;
                break;
            }
            evictOrder.remove(evictKey);
            values.remove(evictKey);
        }
        values.put(key, value);
        updateEvictOrder(key);
    }
}
