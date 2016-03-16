package DynamicProgramming;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void testBestTimeToBuyAndSellStock() {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int result = bestTimeToBuyAndSellStock.maxProfit(new int[]{1, 1, 3, 5, 2, 4, 7, 5});
        assertEquals(6, result);

        result = bestTimeToBuyAndSellStock.maxProfit(new int[]{2, 1, 3, 5, 1, 4, 7, 5});
        assertEquals(6, result);

        result = bestTimeToBuyAndSellStock.maxProfit(new int[]{1, 2, 4});
        assertEquals(3, result);
    }
    @Test
    public void testBestTimeToBuyAndSellStockII() {
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        int result = bestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 1, 3, 5, 2, 4, 7, 5});
        assertEquals(9, result);

        result = bestTimeToBuyAndSellStockII.maxProfit(new int[]{2, 1, 3, 5, 1, 4, 7, 5});
        assertEquals(10, result);

        result = bestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 2, 4});
        assertEquals(3, result);
    }
}
