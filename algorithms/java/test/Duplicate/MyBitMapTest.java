package Duplicate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyBitMapTest {
    @Test
    public void test() {
        int sizeInBits = 2018;
        MyBitMap myBitMap = new MyBitMap(sizeInBits);
        boolean result = myBitMap.test(2);
        assertEquals(result, false);

        myBitMap.set(2);
        result = myBitMap.test(2);
        assertEquals(result, true);

        myBitMap.set(1024);
        result = myBitMap.test(1024);
        assertEquals(result, true);

        result = myBitMap.test(2018);
        assertEquals(result, false);

        myBitMap.clear(2);
        result = myBitMap.test(2);
        assertEquals(result, false);

        myBitMap.set(2018);
        result = myBitMap.test(2018);
        assertEquals(result, true);

        myBitMap.clear(1024);
        result = myBitMap.test(1024);
        assertEquals(result, false);

        myBitMap.set(-4);
        result = myBitMap.test(-4);
        assertEquals(result, true);
    }
}
