package StringRelated;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ValidNumberTest {
    @Test
    public void test() {
        ValidNumber validNumber = new ValidNumber();
        boolean result = validNumber.isNumber("0");
        assertEquals(true, result);

        result = validNumber.isNumber("0.1");
        assertEquals(true, result);

        result = validNumber.isNumber(" 0.1 ");
        assertEquals(true, result);

        result = validNumber.isNumber("abc");
        assertEquals(false, result);

        result = validNumber.isNumber("1 a");
        assertEquals(false, result);

        result = validNumber.isNumber("2e10");
        assertEquals(true, result);

        result = validNumber.isNumber("2e10");
        assertEquals(true, result);

        result = validNumber.isNumber("2e-10");
        assertEquals(true, result);

        result = validNumber.isNumber("-2e-10");
        assertEquals(true, result);

        result = validNumber.isNumber("-2e--10");
        assertEquals(false, result);

        result = validNumber.isNumber("-2e-1-0");
        assertEquals(false, result);

        result = validNumber.isNumber("-200");
        assertEquals(true, result);

        result = validNumber.isNumber("e");
        assertEquals(false, result);

        result = validNumber.isNumber("e9");
        assertEquals(false, result);

        result = validNumber.isNumber("3.");
        assertEquals(true, result);

        result = validNumber.isNumber(".1");
        assertEquals(true, result);

        result = validNumber.isNumber(".");
        assertEquals(false, result);

        result = validNumber.isNumber("+.8");
        assertEquals(true, result);

        result = validNumber.isNumber("+1.e8");
        assertEquals(true, result);

        result = validNumber.isNumber("+46.e8");
        assertEquals(true, result);

        result = validNumber.isNumber("+.8e10");
        assertEquals(true, result);
    }
}
