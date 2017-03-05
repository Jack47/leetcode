package StringRelated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseVowelsOfaStringTest{
    @Test
    public void test() {
        ReverseVowelsOfaString sol = new ReverseVowelsOfaString();
        String result = sol.reverseVowels("leetcode");
        assertEquals("leotcede", result);

        result = sol.reverseVowels("speak english");
        assertEquals("spiek anglesh", result);

        result = sol.reverseVowels("Haha");
        assertEquals("Haha", result);

        result = sol.reverseVowels("Do not touch it");
        assertEquals("Di nut tooch ot", result);
    }
}

