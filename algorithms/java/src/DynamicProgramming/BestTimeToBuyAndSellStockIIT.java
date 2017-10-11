package DynamicProgramming;

public class BestTimeToBuyAndSellStockIIT {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int sum = 0;

        int i = 0;
        while (i < prices.length-1) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            int valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i];
            sum += peak - valley;
        }

        return sum;
    }
}
