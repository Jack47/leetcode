package Math;

import org.junit.Test;

public class RearrangeStringKDistanceApartTest {
    @Test
    public void test() {
        RearrangeStringKDistanceApart sol = new RearrangeStringKDistanceApart();
        sol.rearrangeString("aabbcc", 3);
        sol.rearrangeString("abc", 0);
        sol.rearrangeString("abcc", 0);
        sol.rearrangeString("a", 2);
        sol.rearrangeString("aabbcc", 2);
    }

}
