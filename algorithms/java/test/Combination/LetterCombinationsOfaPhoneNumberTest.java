package Combination;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class LetterCombinationsOfaPhoneNumberTest {
    @Test
    public void test() {
        LetterCombinationsOfaPhoneNumber letterCombinationsOfaPhoneNumber = new LetterCombinationsOfaPhoneNumber();
        List<String> result = letterCombinationsOfaPhoneNumber.letterCombinations("3");
        assertEquals(3, result.size());
        assertEquals("d", result.get(0));
        assertEquals("e", result.get(1));
        assertEquals("f", result.get(2));

        result = letterCombinationsOfaPhoneNumber.letterCombinations("30");
        assertEquals(0, result.size());

        result = letterCombinationsOfaPhoneNumber.letterCombinations("38");
        assertEquals(9, result.size());
        assertEquals("dt", result.get(0));
        assertEquals("du", result.get(1));
        assertEquals("dv", result.get(2));
        assertEquals("et", result.get(3));
        assertEquals("eu", result.get(4));
        assertEquals("ev", result.get(5));
        assertEquals("ft", result.get(6));
        assertEquals("fu", result.get(7));
        assertEquals("fv", result.get(8));

        result = letterCombinationsOfaPhoneNumber.letterCombinations("013");
        assertEquals(0, result.size());

        result = letterCombinationsOfaPhoneNumber.letterCombinations("");
        assertEquals(0, result.size());
    }
}
