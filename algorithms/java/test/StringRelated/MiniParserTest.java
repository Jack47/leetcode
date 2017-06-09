package StringRelated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MiniParserTest {
    @Test
    public void test() {
        MiniParser m = new MiniParser();
        NestedInteger r = m.deserialize("[324,[323,[322]]]");
        assertEquals(Integer.valueOf(324), r.getList().get(0).getInteger());

        r = m.deserialize("[]");
        assertEquals(false, r.getList().isEmpty());
        assertEquals(null, r.getList().get(0).getList());
    }
}
