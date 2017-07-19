package Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCacheT {
    class Freq {
        LinkedHashSet<Integer> keys;
        Freq next;

        Freq() {
            keys = new LinkedHashSet<>();
            next = null;
        }
    }

    Freq head;
    int cap;
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Freq> freq;

    public LFUCacheT(int capacity) {
        head = new Freq();
        cap = capacity;
        cache = new HashMap<>(cap);
        freq = new HashMap<>();
    }

    void increaseFreq(int key) {
        Freq f = freq.get(key);
        if (f.next == null) {
            f.next = new Freq();
        }
        f.keys.remove(key);
        f.next.keys.add(key);
        freq.put(key, f.next);
    }

    void initFreq(int key) {
        if (head.next == null) {
            head.next = new Freq();
        }
        head.next.keys.add(key);
        freq.put(key, head.next);
    }

    void erase() {
        int key = 0;
        Freq c = head.next;
        while(c.keys.size() == 0) {
            c = c.next;
        }
        for (int k : c.keys) {
            key = k;
            break;
        }
        c.keys.remove(key);
        cache.remove(key);
        freq.remove(key);
    }

    public int get(int key) {
        if(cap <= 0) return -1;
        Integer value = cache.get(key);
        if (value == null) return -1;
        increaseFreq(key);
        return value;
    }

    public void put(int key, int value) {
        if(cap <= 0) return;
        Integer v = cache.get(key);
        if (v == null) {
            if (cache.size() == cap) {
                erase();
            }
            initFreq(key);
        } else {
            increaseFreq(key);
        }
        cache.put(key, value);
    }

}
