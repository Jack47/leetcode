package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecodeWaysT2Test {
    @Test
    public void test() {
        DecodeWaysT2 s = new DecodeWaysT2();
        int n = s.numDecodings(new String("122"));
        assertEquals(3, n);
    }
}
