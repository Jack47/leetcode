package Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueWithFixedArrayTest {
    @Test
    public void test() {
        QueueWithFixedArray qwfa = new QueueWithFixedArray(5);
        assertEquals(0, qwfa.size());

        qwfa.offer(2);
        assertEquals(1, qwfa.size());

        qwfa.offer(3);
        qwfa.offer(4);
        qwfa.offer(5);
        qwfa.offer(6);
        assertEquals(5, qwfa.size());

        qwfa.offer(7);
        assertEquals(6, qwfa.size());

        assertEquals(new Integer(2), qwfa.poll());
        assertEquals(5, qwfa.size());
        assertEquals(new Integer(3), qwfa.poll());
        assertEquals(4, qwfa.size());
        assertEquals(new Integer(4), qwfa.poll());
        assertEquals(3, qwfa.size());
        assertEquals(new Integer(5), qwfa.poll());
        assertEquals(2, qwfa.size());
        assertEquals(new Integer(6), qwfa.poll());
        assertEquals(1, qwfa.size());
    }
}
