package BitManipulation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BinaryWatchTest {
    @Test
    public void test() {
        BinaryWatch bw = new BinaryWatch();
        List<String> results = bw.readBinaryWatch(0);
        assertEquals("", new ArrayList<String>() {
            {
                add("0:00");
            }
        }, results);

        results = bw.readBinaryWatch(1);
        assertEquals(new ArrayList<String>() {
            {
                add("0:01");
                add("0:02");
                add("0:04");
                add("0:08");
                add("0:16");
                add("0:32");
                add("1:00");
                add("2:00");
                add("4:00");
                add("8:00");
            }
        }, results);

        results = bw.readBinaryWatch(9);
        assertEquals(Collections.<String>emptyList(), results);
    }
}
