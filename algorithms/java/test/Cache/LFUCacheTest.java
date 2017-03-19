package Cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LFUCacheTest {
    @Test
    public void testPuts() {
        LFUCache cache = new LFUCache(10);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        // items: [0]=>(10, 5: 0), [3]=>(3,17: 0), [6]=>(6, 11: 0), [9]=>(9, 10: 0)
        // evict key order: <3[0], 1[1]>

        cache.get(13);
        cache.put(2, 19);
        // items: [0]=>(10, 5: 0), [2]=>(2,19: 0) [3]=>(3,17: 0), [6]=>(6, 11: 0), [9]=>(9, 10: 0)

        cache.get(2);
        cache.get(3);
        // items: [0]=>(10, 5: 0), [2]=>(2,19: 1) [3]=>(3,17: 1), [6]=>(6, 11: 0), [9]=>(9, 10: 0)
        cache.put(5, 25); // 10
        // items: [0]=>(10, 5: 0), [2]=>(2,19: 1) [3]=>(3,17: 1), [5]=>(5, 25: 0), [6]=>(6,
        // 11: 0), [9]=>(9, 10: 0)

        cache.get(8);
        cache.put(9, 22);
        // items: [0]=>(10, 5: 0), [2]=>(2,19: 1) [3]=>(3,17: 1), [5]=>(5, 25: 0), [6]=>(6,
        // 11: 0), [9]=>(9, 22: 0)

        cache.put(5, 5);
        // items: [0]=>(10, 5: 0), [2]=>(2,19: 1) [3]=>(3,17: 1), [5]=>(5, 5: 0), [6]=>(6,
        // 11: 0), [9]=>(9, 22: 0)

        cache.put(1, 30);
        // items 7: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [5]=>(5,
        // 5: 0), [6]=>(6, 11: 0), [9]=>(9, 22: 0)

        cache.get(11);
        cache.put(9, 12);
        // items: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [5]=>(5,
        // 5: 0), [6]=>(6, 11: 0), [9]=>(9, 12: 0)
        cache.get(7);

        cache.get(5);
        // items: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 11: 0), [9]=>(9, 12: 0)

        cache.get(8);
        cache.get(9); // 20
        // items: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 11: 0), [9]=>(9, 12: 1)

        cache.put(4, 30);
        // items 8: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [4]=>(4,
        // 30: 0), [5]=>(5, 5: 1), [6]=>(6, 11: 0), [9]=>(9, 12: 1)

        cache.put(9, 3);
        // items: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 11: 0), [9]=>(9, 3: 1)

        cache.get(9);
        // items: [0]=>(10, 5: 0), [1] =>(1, 30: 0), [2]=>(2,19: 1), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 11: 0), [9]=>(9, 3: 2)

        cache.get(10);
        // items: [0]=>(10, 5: 1), [1] =>(1, 30: 0), [2]=>(2,19: 0), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 11: 0), [9]=>(9, 3: 2

        cache.get(10);
        // items: [0]=>(10, 5: 2), [1] =>(1, 30: 0), [2]=>(2,19: 0), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 11: 0), [9]=>(9, 3: 2

        cache.put(6, 14);
        // items: [0]=>(10, 5: 2), [1] =>(1, 30: 0), [2]=>(2,19: 0), [3]=>(3,17: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 14: 0), [9]=>(9, 3: 2

        cache.put(3, 1);
        // items: [0]=>(10, 5: 2), [1] =>(1, 30: 0), [2]=>(2,19: 0), [3]=>(3,1: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 14: 0), [9]=>(9, 3: 2

        cache.get(3);
        // items: [0]=>(10, 5: 2), [1] =>(1, 30: 0), [2]=>(2,19: 0), [3]=>(3,1: 2), [5]=>(5,
        // 5: 1), [6]=>(6, 14: 0), [9]=>(9, 3: 2

        cache.put(10, 11);
        // items: [0]=>(10, 11: 2), [1] =>(1, 30: 0), [2]=>(2,19: 0), [3]=>(3,1: 1), [5]=>(5,
        // 5: 1), [6]=>(6, 14: 0), [9]=>(9, 3: 2

        cache.get(8); // 30

        cache.put(2, 14);
        // items 8: [0]=>(10, 11: 2), [1] =>(1, 30: 0), [2]=>(2,14: 0), [3]=>(3,1: 1), [4]=>(4,
        // 30: 0), [5]=>(5, 5: 1), [6]=>(6, 14: 0), [9]=>(9, 3: 2

        cache.get(1);
        cache.get(5);
        cache.get(4);
        // items: [0]=>(10, 11: 2), [1] =>(1, 30: 2), [2]=>(2,14: 0), [3]=>(3,1: 1), [5]=>(5,
        // 5: 2), [6]=>(6, 14: 0), [9]=>(9, 3: 2
        cache.put(11, 4);
        // items 9: [0]=>(10, 11: 2), [1] =>(1, 30: 0), [2]=>(2,14: 0), [3]=>(3,1: 1), [4]=>(4,
        // 30: 0), [5]=>(5, 5: 1), [6]=>(6, 14: 0), [7]=>(11, 4: 0), [9]=>(9, 3: 2

        cache.put(12, 24);
        // items 9: [0]=>(10, 11: 2), [1] =>(1, 30: 0), [2]=>(2,14: 0), [3]=>(3,1: 1), [4]=>(4,
        // 30: 0), [5]=>(5, 5: 1), [6]=>(6, 14: 0), [7]=>(11, 4: 0), [8]=>(12, 24: 0), [9]=>(9, 3: 2

        cache.put(5, 18);
        cache.get(13);
        cache.put(7, 23);
        cache.get(8);
        cache.get(12);
        cache.put(3, 27);
        cache.put(2, 12);
        cache.get(5);
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.get(6);

    }

    @Test
    public void testPut1() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 2);
        // items: 0 => <1>
        assertEquals(1, cache.freqNodes.size());
        assertEquals(1, cache.freqNodes.get(1).keys.size());
        assertEquals(cache.freqNodes.get(1), cache.head);
        assertEquals(2, cache.capacity);
        assertEquals(null, cache.freqNodes.get(1).next);
        assertEquals(null, cache.freqNodes.get(1).prev);


        cache.put(3, 4);
        // items: 0 => <3, 1>
        assertEquals(2, cache.freqNodes.size());
        assertEquals(2, cache.freqNodes.get(1).keys.size());
        assertEquals(cache.freqNodes.get(1), cache.head);
        assertEquals(cache.freqNodes.get(3), cache.head);

        assertEquals(2, cache.capacity);
        assertEquals(null, cache.freqNodes.get(1).next);
        assertEquals(null, cache.freqNodes.get(1).prev);
        assertEquals(cache.freqNodes.get(1), cache.freqNodes.get(3));
        assertEquals(0, cache.freqNodes.get(1).freq);
        assertEquals(2, cache.freqNodes.get(1).keys.size());


        assertEquals(2, cache.get(1));
        // items: 0 => <3>,   1 => <1>
        assertEquals(2, cache.freqNodes.size());
        assertEquals(1, cache.freqNodes.get(1).keys.size());
        assertEquals(1, cache.freqNodes.get(3).keys.size());
        assertEquals(1, cache.freqNodes.get(1).freq);

        // items: 0 =>(3),  1 => (1)
        assertEquals(null, cache.freqNodes.get(1).next);
        assertEquals(cache.freqNodes.get(3), cache.freqNodes.get(1).prev);
        assertEquals(null, cache.freqNodes.get(1).next);
        assertEquals(cache.freqNodes.get(1), cache.freqNodes.get(3).next);
        assertEquals(null, cache.freqNodes.get(3).prev);


        assertEquals(4, cache.get(3));
        // items: 1 => <1, 3>
        assertEquals(cache.freqNodes.get(3), cache.freqNodes.get(1));
        assertEquals(2, cache.freqNodes.size());
        assertEquals(null, cache.freqNodes.get(1).next);
        assertEquals(null, cache.freqNodes.get(3).prev);
        assertEquals(2, cache.freqNodes.get(3).keys.size());

        cache.put(5, 6);
        // items: 0 => <5>,  1 => <3>
        assertEquals(2, cache.freqNodes.size());
        assertEquals(1, cache.freqNodes.get(3).keys.size());
        assertEquals(1, cache.freqNodes.get(5).keys.size());
        assertEquals(null, cache.freqNodes.get(1));
        assertEquals(null, cache.freqNodes.get(3).next);
        assertEquals(1, cache.freqNodes.get(3).freq);
        assertEquals(0, cache.freqNodes.get(5).freq);
        assertEquals(cache.freqNodes.get(3), cache.freqNodes.get(5).next);
        assertEquals(1, cache.freqNodes.get(5).keys.size());


        cache.put(7, 8);
        // items: 0 => <7>,  1 => <3>
        assertEquals(2, cache.freqNodes.size());
        assertEquals(1, cache.freqNodes.get(7).keys.size());
        assertEquals(1, cache.freqNodes.get(3).keys.size());
        assertEquals(null, cache.freqNodes.get(3).next);
        assertEquals(1, cache.freqNodes.get(3).freq);
        assertEquals(0, cache.freqNodes.get(7).freq);
        assertEquals(cache.freqNodes.get(3), cache.freqNodes.get(7).next);
        assertEquals(1, cache.freqNodes.get(7).keys.size());

        cache = new LFUCache(3);
        cache.put(1, 2);
        assertEquals(1, cache.freqNodes.size());
        assertEquals(cache.head, cache.freqNodes.get(1));
        cache.put(3, 4);
        // items: 0 => <1, 3>
        assertEquals(2, cache.freqNodes.size());
        assertEquals(2, cache.get(1));
        assertEquals(4, cache.get(3));
        // items: 1 => <1, 3>
        assertEquals(2, cache.freqNodes.size());
        assertEquals(cache.head, cache.freqNodes.get(1));
        assertEquals(cache.freqNodes.get(3), cache.freqNodes.get(1));

        cache.put(5, 6);
        // items: 0 => <5> 1 => <1, 3>
        assertEquals(cache.head, cache.freqNodes.get(5));
        assertEquals(cache.freqNodes.get(5).next, cache.freqNodes.get(1));

        cache.put(7, 8);
        // items: 0 => <7> 1 => <1, 3>
        assertEquals(cache.head, cache.freqNodes.get(7));
        assertEquals(null, cache.freqNodes.get(5));
        assertEquals(-1, cache.get(5));

        assertEquals(cache.freqNodes.get(7).next, cache.freqNodes.get(1));


        assertEquals(2, cache.get(1));
        // items: 0 => <7>, 1 => <3>, 2=> <1>
        assertEquals(cache.head, cache.freqNodes.get(7));
        assertEquals(cache.head.next, cache.freqNodes.get(3));
        assertEquals(cache.head.next.next, cache.freqNodes.get(1));

        assertEquals(4, cache.get(3));
        // items: 0 => <7>, 2=> <1, 3>
        assertEquals(cache.head, cache.freqNodes.get(7));

        assertEquals(8, cache.get(7));
        // items: 1 => <7> 2 => <1, 3>
        assertEquals(cache.head, cache.freqNodes.get(7));
        assertEquals(1, cache.freqNodes.get(7).keys.size());
        assertEquals(2, cache.freqNodes.get(1).keys.size());

        cache.put(9, 10);
        // items: 0 => <9> 2 => <1, 3>
        assertEquals(cache.head, cache.freqNodes.get(9));
        assertEquals(10, cache.get(9));
        // items: 1 => <9> 2 => <1, 3>
        assertEquals(cache.head, cache.freqNodes.get(9));
        assertEquals(4, cache.get(3));
        // items: 1 => <9> 2 => <1>, 3 => <3>
        assertEquals(cache.head, cache.freqNodes.get(9));
        assertEquals(cache.head.next, cache.freqNodes.get(1));
        assertEquals(cache.head.next.next, cache.freqNodes.get(3));

        cache.put(12, 13);
        // items: 0 => <12> 2 => <1>, 3 => <3>
        assertEquals(cache.head, cache.freqNodes.get(12));
        assertEquals(-1, cache.get(9));

        cache = new LFUCache(3);
        cache.put(1, 11);
        cache.put(2, 12);
        cache.put(0, 10);
        cache.put(0, 20);

        assertEquals(20, cache.get(0));
        assertEquals(11, cache.get(1));
        assertEquals(12, cache.get(2));

        cache = new LFUCache(0);
        cache.put(0, 1);
        cache.get(0);

        cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);
        cache.put(1, 1);
        cache.put(4, 1);

        assertEquals(2, cache.get(2));
    }
    @Test
    public void testPut2() {
        LFUCache cache = new LFUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        // items 0 => <2, 1>
        cache.put(2,3);
        // items 0 => <2, 1>
        cache.put(4,1);
        // items 0 => <2, 1>

    }
    @Test
    public void testPut3() {
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
