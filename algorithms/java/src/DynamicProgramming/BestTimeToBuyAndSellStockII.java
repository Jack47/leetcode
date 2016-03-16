package DynamicProgramming;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int lowest = prices[0];
        int maxSoFar = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // ascending
            if (prices[i] - lowest > maxSoFar) {
                maxSoFar = prices[i] - lowest;
            }
            else { // descending
                lowest = prices[i];
                max += maxSoFar;
                maxSoFar = 0;
            }
        }

        max += maxSoFar;
        return max;
    }
}
