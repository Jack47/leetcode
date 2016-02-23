package AddBinary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddBinaryTest {
    @Test
    public void test() {
        AddBinary addBinary = new AddBinary();
        String expect = addBinary.addBinary("10", "1");
        assertEquals(expect, "11");

        expect = addBinary.addBinary("11", "0");
        assertEquals(expect, "11");

        expect = addBinary.addBinary("101", "1");
        assertEquals(expect, "110");

        expect = addBinary.addBinary("111", "1");
        assertEquals(expect, "1000");

        expect = addBinary.addBinary("1111", "1110");
        assertEquals(expect, "11101");
    }
}
