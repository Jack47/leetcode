package Cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LRUCache2Test {
    @Test
    public void test() {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // evict order: <2, 1>
        assertEquals(1, cache.get(1));

        // evict order: <1, 2>
        cache.put(3, 3);

        // evict order: <3, 1>
        assertEquals(-1, cache.get(2));

        // evict order: <3, 1>
        cache.put(4, 4);
        // evict order: <4, 3>

        assertEquals(-1, cache.get(1));

        assertEquals(3, cache.get(3));
        // evict order: <4, 1>
        assertEquals(4, cache.get(4));
        // evict order: <1, 4>

        cache = new LRUCache2(2);
        cache.put(2, 1);
        cache.put(3, 2);
        // evict order: <3, 2>
        assertEquals(2, cache.get(3));
        assertEquals(1, cache.get(2));
        // evict order: <2, 3>
        cache.put(4, 3);
        // evict order: <2, 4>
        assertEquals(1, cache.get(2));

        // evict order: <2, 4>
        assertEquals(-1, cache.get(3));

        assertEquals(3, cache.get(4));
    }
}