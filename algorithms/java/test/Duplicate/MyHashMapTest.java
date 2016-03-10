package Duplicate;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MyHashMapTest {
    @Test
    public void test() {
        int capacity = 20;
        MyHashMap myHashMap = new MyHashMap(capacity);
        assertEquals(20, myHashMap.capacity);
        assertEquals(true, myHashMap.isEmpty());
        Integer value = myHashMap.get(2);
        assertEquals(null, value);

        boolean result = myHashMap.add(2, 22);
        assertEquals(true, result);
        assertEquals(1, myHashMap.size);

        result = myHashMap.add(2, 22);
        assertEquals(false, result);

        value= myHashMap.get(2);
        assertEquals(true, value);

        result = myHashMap.add(1, 11);
        assertEquals(true, result);
        assertEquals(2, myHashMap.size);

        result = myHashMap.add(3, 33);
        assertEquals(true, result);
        assertEquals(3, myHashMap.size);

        result = myHashMap.add(4, 44);
        assertEquals(true, result);
        assertEquals(4, myHashMap.size);

        result = myHashMap.add(1, 11);
        assertEquals(false, result);
        assertEquals(4, myHashMap.size);

        result = myHashMap.add(-5, -5);
        assertEquals(true, result);
        assertEquals(5, myHashMap.size);

        result = myHashMap.remove(-5);
        assertEquals(true, result);

        value = myHashMap.get(4);
        assertEquals(true, result);
        assertEquals(4, myHashMap.size);

        value= myHashMap.get(-4);
        assertEquals(false, value);

        result = myHashMap.remove(4);
        assertEquals(true, result);
        assertEquals(3, myHashMap.size);
        value= myHashMap.get(4);
        assertEquals(false, value);

        result = myHashMap.remove(3);
        assertEquals(true, result);
        value= myHashMap.get(3);
        assertEquals(false, value);
        assertEquals(2, myHashMap.size);

        result = myHashMap.remove(2);
        assertEquals(true, result);
        value= myHashMap.get(2);
        assertEquals(false, result);
        assertEquals(1, myHashMap.size);

        myHashMap.clear();
        result = myHashMap.isEmpty();
        assertEquals(true, result);
    }
}
