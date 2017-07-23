package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class FreeDomTrailTest {
    @Test
    public void test() {
        FreedomTrail t = new FreedomTrail();
        int min = t.findRotateSteps("godding", "gd");
        assertEquals(4, min);

        min = t.findRotateSteps("godding", "gdgnio");
        assertEquals(16, min);
    }
}
