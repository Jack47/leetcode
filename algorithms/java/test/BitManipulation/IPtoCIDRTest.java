package BitManipulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IPtoCIDRTest {
    @Test
    public void test() {
        IPtoCIDR iPtoCIDR = new IPtoCIDR();
        List<String> ret = iPtoCIDR.ipToCIDR("225.0.0.7", 10);
        List<String> expected = new ArrayList<>();
        expected.add("225.0.0.7/32"); //1
        expected.add("225.0.0.8/29");// 8
        expected.add("225.0.0.16/32"); // 1
        assertEquals(expected, ret);

        ret = iPtoCIDR.ipToCIDR("225.0.0.7", 13);
        expected = new ArrayList<>();
        expected.add("225.0.0.7/32"); //1
        expected.add("225.0.0.8/29");// 8
        expected.add("225.0.0.16/30"); // 4
        assertEquals(expected, ret);

        ret = iPtoCIDR.ipToCIDR("1.1.1.0", 4);
        expected = new ArrayList<>();
        expected.add("1.1.1.0/30");
        assertEquals(expected, ret);

        ret = iPtoCIDR.ipToCIDR("1.1.1.7", 10);
    }
    @Test
    public void test2() {
        IPtoCIDR iPtoCIDR = new IPtoCIDR();
        List<String> ret = iPtoCIDR.ipToCIDRS("225.0.0.7", 10);
        List<String> expected = new ArrayList<>();
        expected.add("225.0.0.7/32"); //1
        expected.add("225.0.0.8/29");// 8
        expected.add("225.0.0.16/32"); // 1
        assertEquals(expected, ret);

        ret = iPtoCIDR.ipToCIDRS("225.0.0.7", 13);
        expected = new ArrayList<>();
        expected.add("225.0.0.7/32"); //1
        expected.add("225.0.0.8/29");// 8
        expected.add("225.0.0.16/30"); // 4
        assertEquals(expected, ret);

        ret = iPtoCIDR.ipToCIDRS("1.1.1.0", 4);
        expected = new ArrayList<>();
        expected.add("1.1.1.0/30");
        assertEquals(expected, ret);

        ret = iPtoCIDR.ipToCIDRS("1.1.1.7", 10);
    }
}
