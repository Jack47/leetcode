package Duplicate;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MyHashSetTest {
    @Test
    public void test() {
        int capacity = 20;
        MyHashSet myHashSet = new MyHashSet(capacity);
        assertEquals(20, myHashSet.capacity);
        assertEquals(true, myHashSet.isEmpty());
        boolean result = myHashSet.contains(2);
        assertEquals(false, result);

        result = myHashSet.add(2);
        assertEquals(true, result);
        assertEquals(1, myHashSet.size);

        result = myHashSet.add(2);
        assertEquals(false, result);

        result = myHashSet.contains(2);
        assertEquals(true, result);

        result = myHashSet.add(1);
        assertEquals(true, result);
        assertEquals(2, myHashSet.size);

        result = myHashSet.add(3);
        assertEquals(true, result);
        assertEquals(3, myHashSet.size);

        result = myHashSet.add(4);
        assertEquals(true, result);
        assertEquals(4, myHashSet.size);

        result = myHashSet.add(1);
        assertEquals(false, result);
        assertEquals(4, myHashSet.size);

        result = myHashSet.add(-5);
        assertEquals(true, result);
        assertEquals(5, myHashSet.size);

        result = myHashSet.remove(-5);
        assertEquals(true, result);

        result = myHashSet.contains(4);
        assertEquals(true, result);
        assertEquals(4, myHashSet.size);

        result = myHashSet.contains(-4);
        assertEquals(false, result);

        result = myHashSet.remove(4);
        assertEquals(true, result);
        assertEquals(3, myHashSet.size);
        result = myHashSet.contains(4);
        assertEquals(false, result);

        result = myHashSet.remove(3);
        assertEquals(true, result);
        result = myHashSet.contains(3);
        assertEquals(false, result);
        assertEquals(2, myHashSet.size);

        result = myHashSet.remove(2);
        assertEquals(true, result);
        result = myHashSet.contains(2);
        assertEquals(false, result);
        assertEquals(1, myHashSet.size);

        myHashSet.clear();
        result = myHashSet.isEmpty();
        assertEquals(true, result);
    }
}
