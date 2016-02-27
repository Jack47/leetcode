package AdditiveNumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditiveNumberTest {
    @Test
    public void testAdditiveNumber() {
        AdditiveNumber number = new AdditiveNumber();

        boolean result = number.isAdditiveNumber("199100199", 1, 2);
        assertEquals(true, result);

        result = number.isAdditiveNumber("19910019", 1, 2);
        assertEquals(false, result);

        result = number.isAdditiveNumber("199100199");
        assertEquals(true, result);

        result = number.isAdditiveNumber("112358");
        assertEquals(true, result);

        result = number.isAdditiveNumber("123");
        assertEquals(true, result);

        result = number.isAdditiveNumber("1234");
        assertEquals(false, result);

        result = number.isAdditiveNumber("211738", 2, 2);
        assertEquals(true, result);

        result = number.isAdditiveNumber("211738");
        assertEquals(true, result);
    }

}
