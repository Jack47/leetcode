package StringToInteger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyAtoITest {
    @Test
    public void testMyAtoITest() {
        Integer.parseInt();
        // ordinary value
        MyAtoi myAtoi = new MyAtoi();
        int num = myAtoi.myAtoi("123");
        assertEquals(num, 123);

        num = myAtoi.myAtoi("-123");
        assertEquals(num, -123);

        num = myAtoi.myAtoi("+123");
        assertEquals(num, 123);

        num = myAtoi.myAtoi("-0");
        assertEquals(num, 0);

        // max value
        int maxValue = 0x7FFFFFFF; // Integer.MAX_VALUE
        num = myAtoi.myAtoi(String.valueOf(maxValue));
        assertEquals(num, maxValue);

        // min value
        int minValue = 0x80000000;
        num = myAtoi.myAtoi(String.valueOf(minValue));
        assertEquals(num, minValue);

        // overflow / out of range
        num = myAtoi.myAtoi(String.valueOf(maxValue+1L));
        assertEquals(num, 0x7FFFFFFF);

        num = myAtoi.myAtoi(String.valueOf(minValue-1L));
        assertEquals(num, 0x80000000);

        num = myAtoi.myAtoi("9223372036854775809");
        assertEquals(2147483647, num);
        // error format
        num = myAtoi.myAtoi("skdald071");
        assertEquals(0, num);

        num = myAtoi.myAtoi("-+7");
        assertEquals(0, num);

        // skip
        num = myAtoi.myAtoi("-7F");
        assertEquals(-7, num);
    }
}
