package StringRelated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class MiniParserTest {
    @Test
    public void test() {
        MiniParserT m = new MiniParserT();
        NestedInteger r = m.deserialize("[324,[323,[322]]]");
        assertEquals(Integer.valueOf(324), r.getList().get(0).getInteger());
        StringBuilder sb = new StringBuilder();
        r.printNi(r, sb);
        System.out.println(sb);
        r = m.deserialize("[]");
        assertEquals(false, r.isInteger());
        assertNotEquals(null, r.getList());
        //assertEquals(null, r.getList().get(0));
        sb = new StringBuilder();
        r.printNi(r, sb);
        System.out.println(sb);
    }
}
