package StringRelated;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ReconstructOriginalDigitsFromEnglishTest {
    @Test
    public void testGetCurrentDigits() {
        ReconstructOriginalDigitsFromEnglish sol = new ReconstructOriginalDigitsFromEnglish();
        int[] currentDigits = sol.getCurrentDigits("one");
        int[] expected = new int[ReconstructOriginalDigitsFromEnglish.Total_Index];
        expected['o'-'a'] = 1;
        expected['n'-'a'] = 1;
        expected['e'-'a'] = 1;
        expected[sol.Total_Index - 1] = 3;
        assertArrayEquals(expected, currentDigits);

        currentDigits = sol.getCurrentDigits("onetwo");
        Arrays.fill(expected, 0);
        expected['o'-'a'] = 2;
        expected['n'-'a'] = 1;
        expected['e'-'a'] = 1;
        expected['t'-'a'] = 1;
        expected['w'-'a'] = 1;
        expected[sol.Total_Index - 1] = 6;
        assertArrayEquals(expected, currentDigits);

        currentDigits = sol.getCurrentDigits("twoonethree");
        Arrays.fill(expected, 0);
        expected['o'-'a'] = 2;
        expected['n'-'a'] = 1;
        expected['e'-'a'] = 3;
        expected['t'-'a'] = 2;
        expected['w'-'a'] = 1;
        expected['h'-'a'] = 1;
        expected['r'-'a'] = 1;
        expected[sol.Total_Index - 1] = 11;
        assertArrayEquals(expected, currentDigits);

        currentDigits = sol.getCurrentDigits("four");
        Arrays.fill(expected, 0);
        expected['o'-'a'] = 1;
        expected['f'-'a'] = 1;
        expected['u'-'a'] = 1;
        expected['r'-'a'] = 1;
        expected[sol.Total_Index - 1] = 4;
        assertArrayEquals(expected, currentDigits);

        currentDigits = sol.getCurrentDigits("fourtwoonethree");
        Arrays.fill(expected, 0);
        expected['o'-'a'] = 3;
        expected['n'-'a'] = 1;
        expected['e'-'a'] = 3;
        expected['t'-'a'] = 2;
        expected['w'-'a'] = 1;
        expected['h'-'a'] = 1;
        expected['r'-'a'] = 2;
        expected['f'-'a'] = 1;
        expected['u'-'a'] = 1;
        expected[sol.Total_Index - 1] = 15;
        assertArrayEquals(expected, currentDigits);

        currentDigits = sol.getCurrentDigits("fourtwoonethreefive");
        Arrays.fill(expected, 0);
        expected['o'-'a'] = 3;
        expected['n'-'a'] = 1;
        expected['e'-'a'] = 4;
        expected['t'-'a'] = 2;
        expected['w'-'a'] = 1;
        expected['h'-'a'] = 1;
        expected['r'-'a'] = 2;
        expected['f'-'a'] = 2;
        expected['u'-'a'] = 1;
        expected['i'-'a'] = 1;
        expected['v'-'a'] = 1;
        expected[sol.Total_Index - 1] = 19;
        assertArrayEquals(expected, currentDigits);

        currentDigits = sol.getCurrentDigits("fourtwoonethreefive");
        Arrays.fill(expected, 0);
        expected['o'-'a'] = 3;
        expected['n'-'a'] = 1;
        expected['e'-'a'] = 4;
        expected['t'-'a'] = 2;
        expected['w'-'a'] = 1;
        expected['h'-'a'] = 1;
        expected['r'-'a'] = 2;
        expected['f'-'a'] = 2;
        expected['u'-'a'] = 1;
        expected['i'-'a'] = 1;
        expected['v'-'a'] = 1;
        expected[sol.Total_Index - 1] = 19;
        assertArrayEquals(expected, currentDigits);
    }

    @Test
    public void testFormDigits() {
        ReconstructOriginalDigitsFromEnglish sol = new ReconstructOriginalDigitsFromEnglish();

        String s = sol.originalDigits("zero");
        assertEquals("0", s);
        s = sol.originalDigits("eight");
        assertEquals("8", s);
        s = sol.originalDigits("two");
        assertEquals("2", s);
        s = sol.originalDigits("six");
        assertEquals("6", s);


        s = sol.originalDigits("five");
        assertEquals("5", s);
        s = sol.originalDigits("seven");
        assertEquals("7", s);
        s = sol.originalDigits("nine");
        assertEquals("9", s);
        s = sol.originalDigits("one");
        assertEquals("1", s);
        s = sol.originalDigits("four");
        assertEquals("4", s);
        s = sol.originalDigits("three");
        assertEquals("3", s);

        s = sol.originalDigits("twoonethree");
        assertEquals("123", s);

        s = sol.originalDigits("eightsevensevensixfivefourthreethreetwooneone");
        assertEquals("11233456778", s);

        s = sol.originalDigits("sevensixfivefour");
        assertEquals("4567", s);

        //45679
        s = sol.originalDigits("ninefivesixsevenfour");
        assertEquals("45679", s);

        s = sol.originalDigits("nineeightsevensevensixfivefourthreethreetwooneone");
        assertEquals("112334567789", s);

        s = sol.originalDigits("onetwothreefourfivesixnineeightsevenonetwothreefourfivesixnineeightsevenonetwothreefourfivesixnineeightsevenonetwothreefour");
        assertEquals("1111222233334444555666777888999", s);
    }
}
