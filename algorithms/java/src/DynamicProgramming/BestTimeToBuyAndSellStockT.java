package DynamicProgramming;

public class BestTimeToBuyAndSellStockT {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        int smallest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // sell out happens only in ascending
            if (prices[i] >= prices[i - 1]) {
                max = Math.max(prices[i] - smallest, max);
            } else { // sell in happens only in descending
                smallest = Math.min(prices[i], smallest);
            }
        }
        return max;
    }

    public int maxProfitAnother(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int bought = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                max = Math.max(prices[i] - bought, max); // sell out when has profit
            } else {
                bought = prices[i]; // buy in when is smaller
            }
        }
        return max;
    }
}
