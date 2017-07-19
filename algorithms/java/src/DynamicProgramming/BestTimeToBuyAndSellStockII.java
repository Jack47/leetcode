package DynamicProgramming;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int boughtPrice = prices[0];
        int curProfit = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > boughtPrice) {
                int profit = prices[i] - boughtPrice;
                if (profit > curProfit) {
                    curProfit = profit;
                } else { // descending
                    max += curProfit;
                    boughtPrice = prices[i];
                    curProfit = 0;
                }
            } else {
                boughtPrice = prices[i];
            }
        }

        max += curProfit;
        return max;
    }
}
