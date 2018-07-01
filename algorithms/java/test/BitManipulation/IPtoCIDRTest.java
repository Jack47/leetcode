package BitManipulation;

import org.junit.Test;

import java.util.List;

public class IPtoCIDRTest {
    @Test
    public void test() {
        IPtoCIDR iPtoCIDR = new IPtoCIDR();
        List<String> ret = iPtoCIDR.ipToCIDR("225.0.0.7", 10);
    }
}
