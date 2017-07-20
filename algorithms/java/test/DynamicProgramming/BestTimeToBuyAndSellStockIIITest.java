package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class BestTimeToBuyAndSellStockIIITest {
    @Test
    public void test() {
        BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
        int max = s.maxProfit(new int[]{2,1,4});
        assertEquals(3, max);
    }
}
