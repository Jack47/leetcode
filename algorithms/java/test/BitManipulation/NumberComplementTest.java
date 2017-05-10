package BitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberComplementTest {
    @Test
    public void test() {
        NumberComplement sol = new NumberComplement();
        int result = sol.findComplement(2);
        assertEquals(1, result);

        result = sol.findComplement(3);
        assertEquals(0, result);

        result = sol.findComplement(4);
        assertEquals(3, result);
    }
}
