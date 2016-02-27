package BigInteger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BigIntegerTest {
    @Test
    public void testDecimalStringDivision() {

        StringBuilder quotientBuilder = new StringBuilder();
        int remainder = BigInteger.divideDecimalString("192", 2, quotientBuilder);
        assertEquals(0, remainder);
        assertEquals("96", quotientBuilder.toString());

        quotientBuilder.setLength(0);
        remainder = BigInteger.divideDecimalString("193", 2, quotientBuilder);
        assertEquals(1, remainder);
        assertEquals("96", quotientBuilder.toString());

        quotientBuilder.setLength(0);
        remainder = BigInteger.divideDecimalString("193", 4, quotientBuilder);
        assertEquals(1, remainder);
        assertEquals("48", quotientBuilder.toString());

        quotientBuilder.setLength(0);
        remainder = BigInteger.divideDecimalString("493", 4, quotientBuilder);
        assertEquals(1, remainder);
        assertEquals("123", quotientBuilder.toString());

        quotientBuilder.setLength(0);
        remainder = BigInteger.divideDecimalString("1", 2, quotientBuilder);
        assertEquals(1, remainder);
        assertEquals("", quotientBuilder.toString());

        quotientBuilder.setLength(0);
        remainder = BigInteger.divideDecimalString("12", 11, quotientBuilder);
        assertEquals(1, remainder);
        assertEquals("1", quotientBuilder.toString());

        quotientBuilder.setLength(0);
        remainder = BigInteger.divideDecimalString("132", 11, quotientBuilder);
        assertEquals(0, remainder);
        assertEquals("12", quotientBuilder.toString());
    }

    @Test
    public void testAddDecimalString() {
        String sum = BigInteger.addDecimalString("1238", "");
        assertEquals("1238", sum);

        sum = BigInteger.addDecimalString("1238", "8321");
        assertEquals("9559", sum);

        sum = BigInteger.addDecimalString("999", "1");
        assertEquals("1000", sum);

        sum = BigInteger.addDecimalString("0", "0");
        assertEquals("0", sum);
    }

    @Test
    public void testMultiplyDecimalString() {
        String product = BigInteger.multiplyDecimalString("1238", 0);
        assertEquals("0", product);

        product = BigInteger.multiplyDecimalString("", 256);
        assertEquals("", product);

        product = BigInteger.multiplyDecimalString("89155099", 256);
        assertEquals("22823705344", product);

        product = BigInteger.multiplyDecimalString("1238", 1);
        assertEquals("1238", product);

        product = BigInteger.multiplyDecimalString("1238", 9);
        assertEquals("11142", product);

        product = BigInteger.multiplyDecimalString("1238", 19);
        assertEquals("23522", product);

        product = BigInteger.multiplyDecimalString("1238", 100);
        assertEquals("123800", product);
    }

    @Test
    public void testBinaryByteArray() {
        byte[] binaryByteArray = BigInteger.toBinaryByteArray("62");
        assertArrayEquals(new byte[]{0x3E}, binaryByteArray);

        binaryByteArray = BigInteger.toBinaryByteArray("130");
        assertArrayEquals(new byte[]{(byte) 0x82}, binaryByteArray);

        binaryByteArray = BigInteger.toBinaryByteArray("256");
        assertArrayEquals(new byte[]{0x01, 0x00}, binaryByteArray);

        binaryByteArray = BigInteger.toBinaryByteArray("1025");
        assertArrayEquals(new byte[]{0x04, 0x01}, binaryByteArray);

        binaryByteArray = BigInteger.toBinaryByteArray("1025");
        assertArrayEquals(new byte[]{0x04, 0x01}, binaryByteArray);

        binaryByteArray = BigInteger.toBinaryByteArray("025");
        assertArrayEquals(new byte[]{0x19}, binaryByteArray);
        // add more large decimal string test.
    }

    @Test
    public void testAdd() {
        BigInteger integer1 = new BigInteger(new byte[]{0x01, 0x01});
        BigInteger integer2 = new BigInteger(new byte[]{0x01, 0x01});
        BigInteger sum = integer1.add(integer2);
        assertEquals(new BigInteger(new byte[]{0x02, 0x02}), sum);

        integer1 = new BigInteger(new byte[]{(byte) 0xFF, 0x01});
        integer2 = new BigInteger(new byte[]{0x01, (byte) 0xFF});
        sum = integer1.add(integer2);
        assertEquals(new BigInteger(new byte[]{0x01, 0x01, 0x00}), sum);

        integer1 = new BigInteger("199902098990");
        integer2 = new BigInteger("123456789099");
        sum = integer1.add(integer2);
        assertEquals(new BigInteger("323358888089"), sum);
    }

    @Test
    public void testToString() {
        BigInteger integer = new BigInteger("198");
        assertEquals("198", integer.toString());

        integer = new BigInteger("382918238468192736");
        assertEquals("382918238468192736", integer.toString());

        integer = new BigInteger("38291823846819273641823746");
        assertEquals("38291823846819273641823746", integer.toString());

        integer = new BigInteger("0");
        assertEquals("0", integer.toString());

        integer = new BigInteger("10");
        assertEquals("10", integer.toString());
    }

    @Test
    public void testMultiply() {

        BigInteger integer1 = new BigInteger("198");
        BigInteger integer2 = new BigInteger("1");
        BigInteger product = integer1.multiply(integer2);
        assertEquals(new BigInteger("198"), product);

        integer1 = new BigInteger("198");
        integer2 = new BigInteger("12");
        product = integer1.multiply(integer2);
        assertEquals(new BigInteger("2376"), product);

        integer1 = new BigInteger(new byte[] {0});
        integer2 = new BigInteger(new byte[] {0x0B, (byte)0x9D, (byte)0x92});
        product = integer1.multiply(integer2);
        assertEquals(new BigInteger("0"), product);

        integer1 = new BigInteger(new byte[] {(byte)0xD5});
        integer2 = new BigInteger(new byte[] {0x0B, (byte)0x9D, (byte)0x92});
        product = integer1.multiply(integer2);
        assertEquals(new BigInteger("162142842"), product);

        integer1 = new BigInteger(new byte[] {0x03, (byte)0x00});
        integer2 = new BigInteger(new byte[] {0x0B, (byte)0x9D, (byte)0x92});
        product = integer1.multiply(integer2);
        assertEquals(new BigInteger("584627712"), product);

        integer1 = new BigInteger("981");
        integer2 = new BigInteger("761234");
        product = integer1.multiply(integer2);
        assertEquals(new BigInteger("746770554"), product);

        integer1 = new BigInteger("0");
        integer2 = new BigInteger("761234");
        product = integer1.multiply(integer2);
        assertEquals(new BigInteger("0"), product);
    }
}
