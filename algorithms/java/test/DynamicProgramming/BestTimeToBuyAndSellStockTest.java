package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void test() {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int result = bestTimeToBuyAndSellStock.maxProfit(new int[]{1, 1, 3, 5, 2, 4, 7, 5});
        assertEquals(6, result);

        result = bestTimeToBuyAndSellStock.maxProfit(new int[]{1, 1, 3, 5, 0, 4, 7, 5});
        assertEquals(7, result);
    }
}
