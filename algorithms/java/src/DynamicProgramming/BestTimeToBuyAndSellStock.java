package DynamicProgramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int bought = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length;i++) {
            if(prices[i] > bought) {
                max = Math.max(prices[i] - bought, max); // sell out when has profit
            } else {
                bought = prices[i]; // buy in when is smaller
            }
        }
        return max;
    }
}
