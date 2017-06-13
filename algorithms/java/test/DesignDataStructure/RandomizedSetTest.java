package DesignDataStructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomizedSetTest {
    @Test
    public void test() {
        RandomizedSet set = new RandomizedSet();
        boolean ret = set.insert(1);
        assertEquals(true, ret);

        ret = set.remove(2);
        assertEquals(false, ret);

        ret = set.insert(2);
        assertEquals(true, ret);

        int r = set.getRandom();
        // assertEquals(1, r);

        ret = set.remove(1);
        assertEquals(true, ret);

        ret = set.insert(2);
        assertEquals(false, ret);

        r = set.getRandom();
        // assertEquals(2, r);
    }
}
