package Cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LFUCacheTest {
    @Test
    public void testPut() {
        LFUCache cache = new LFUCache(2);
        // TODO update exist item
        cache.put(1, 2);
        // items: [0]=>nil, [1]=>(1,2)
        // evict key order: <1>
        assertEquals(1, cache.head);
        assertEquals(1, cache.zeroFreqTail);
        assertEquals(1, cache.capacity);
        assertEquals(-1, cache.items[1].next);
        assertEquals(-1, cache.items[1].prev);

        cache.put(3, 4);
        // items: [0]=>(3, 4), [1]=>(1,2)
        // evict key order: <1[1], 3[0]>
        assertEquals(1, cache.head);
        assertEquals(0, cache.zeroFreqTail);
        assertEquals(2, cache.capacity);
        assertEquals(0, cache.items[1].next);
        assertEquals(-1, cache.items[1].prev);
        assertEquals(-1, cache.items[0].next);
        assertEquals(1, cache.items[0].prev);

        assertEquals(2, cache.get(1));
        assertEquals(1, cache.items[1].freq);
        // items: [0]=>(3, 4: 0), [1]=>(1,2: 1)
        // evict key order: <3[0], 1[1]>
        assertEquals(0, cache.head);
        assertEquals(0, cache.zeroFreqTail);
        assertEquals(-1, cache.items[1].next);
        assertEquals(0, cache.items[1].prev);
        assertEquals(1, cache.items[0].next);
        assertEquals(-1, cache.items[0].prev);


        assertEquals(4, cache.get(3));
        // items: [0]=>(3, 4: 1), [1]=>(1,2: 1)
        // evict key order: <1[1], 3[0]>
        assertEquals(1, cache.head);
        assertEquals(-1, cache.zeroFreqTail);
        assertEquals(0, cache.items[1].next);
        assertEquals(-1, cache.items[1].prev);
        assertEquals(-1, cache.items[0].next);
        assertEquals(1, cache.items[0].prev);

        cache.put(5, 6);
        // items: [0]=>(3, 4: 1), [1]=>(5,6: 0)
        // evict key order: <5[1], 3[0]>
        assertEquals(1, cache.head);
        assertEquals(1, cache.zeroFreqTail);
        assertEquals(0, cache.items[1].next);
        assertEquals(-1, cache.items[1].prev);
        assertEquals(-1, cache.items[0].next);
        assertEquals(1, cache.items[0].prev);
        assertEquals(-1, cache.get(1));
        assertEquals(6, cache.get(5)); // fre = 1
        assertEquals(4, cache.get(3)); // freq = 2

        cache.put(7, 8);
        assertEquals(-1, cache.get(5));
        assertEquals(4, cache.get(3));
        assertEquals(8, cache.get(7));


        cache = new LFUCache(3);
        cache.put(1, 2);
        cache.put(3, 4);

        assertEquals(2, cache.get(1)); // freq 1
        // items: [0]=>(3, 4: 0), [1]=>(1, 2: 1)
        // evict key order: <3[0], 1[1]>
        assertEquals(0, cache.head);
        assertEquals(0, cache.zeroFreqTail);
        assertEquals(-1, cache.items[1].next);
        assertEquals(0, cache.items[1].prev);
        assertEquals(1, cache.items[0].next);
        assertEquals(-1, cache.items[0].prev);

        assertEquals(4, cache.get(3)); // freq 1
        // items: [0]=>(3, 4: 1), [1]=>(1, 2: 1)
        // evict key order: <1[1], 3[0]>

        cache.put(5, 6);               // freq 0
        // items: [0]=>(3, 4: 1), [1]=>(1, 2: 1), [2]=>(5, 6: 0)
        // evict key order: <5[2], 1[1], 3[0]>
        assertEquals(2, cache.head);
        assertEquals(2, cache.zeroFreqTail);
        assertEquals(1, cache.items[2].next);
        assertEquals(-1, cache.items[2].prev);
        assertEquals(0, cache.items[1].next);
        assertEquals(2, cache.items[1].prev);
        assertEquals(-1, cache.items[0].next);
        assertEquals(1, cache.items[0].prev);

        cache.put(7, 8);
        assertEquals(8, cache.items[2].value);
        // items: [0]=>(3, 4: 1), [1]=>(1, 2: 1), [2]=>(7, 8: 0)
        // evict key order: <7[2], 1[1], 3[0]>
        assertEquals(2, cache.head);
        assertEquals(2, cache.zeroFreqTail);
        assertEquals(1, cache.items[2].next);
        assertEquals(-1, cache.items[2].prev);
        assertEquals(0, cache.items[1].next);
        assertEquals(2, cache.items[1].prev);
        assertEquals(-1, cache.items[0].next);
        assertEquals(1, cache.items[0].prev);
        assertEquals(-1, cache.get(5));

        assertEquals(2, cache.get(1));
        assertEquals(4, cache.get(3));
        // items: [0]=>(3, 4: 2), [1]=>(1, 2: 1), [2]=>(7, 8: 0)
        // evict key order: <7[2], 1[1], 3[0]>
        assertEquals(2, cache.head);
        assertEquals(2, cache.zeroFreqTail);
        assertEquals(1, cache.items[2].next);
        assertEquals(-1, cache.items[2].prev);
        assertEquals(0, cache.items[1].next);
        assertEquals(2, cache.items[1].prev);
        assertEquals(-1, cache.items[0].next);
        assertEquals(1, cache.items[0].prev);

        assertEquals(8, cache.get(7)); // freq 1
        // items: [0]=>(3, 4: 2), [1]=>(1, 2: 1), [2]=>(7, 8: 1)
        // evict key order: <1[1], 7[2], 3[0]>

        cache.put(9, 10);               // evict 1
        // items: [0]=>(3, 4: 2), [1]=>(9, 10: 0), [2]=>(7, 8: 1)
        // evict key order: <9[1], 7[2], 3[0]>

        assertEquals(10, cache.get(9));
        // items: [0]=>(3, 4: 2), [1]=>(9, 10: 1), [2]=>(7, 8: 1)
        // evict key order: <7[2], 9[1], 3[0]>

        assertEquals(4, cache.get(3));
        // items: [0]=>(3, 4: 3), [1]=>(9, 10: 1), [2]=>(7, 8: 1)
        // evict key order: <7[2], 9[1], 3[0]>

        cache.put(12, 13);               // evict 7
        // items: [0]=>(3, 4: 3), [1]=>(9, 10: 1), [2]=>(12, 13: 0)
        // evict key order: <12[2], 9[1], 3[0]>
        assertEquals(-1, cache.get(7));               // evict 7
    }

}
