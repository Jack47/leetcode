package Cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // evict order: <1, 2>
        assertEquals(1, cache.get(1));

        // evict order: <2, 1>
        cache.put(3, 3);

        // evict order: <3, 1>
        assertEquals(-1, cache.get(2));

        // evict order: <3, 1>
        cache.put(4, 4);
        // evict order: <4, 1>

        cache.get(1);
        // evict order: <4, 1>

        cache.get(3);
        // evict order: <4, 1>
        cache.get(4);
        // evict order: <1, 4>
    }
}
