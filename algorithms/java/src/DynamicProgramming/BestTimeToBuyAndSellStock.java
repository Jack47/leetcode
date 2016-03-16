package DynamicProgramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        // II = 2
        int sellBeforeIIMax = 0;
        int sellOnIIMax = Math.max(prices[1]-prices[0], 0);
        int sellBeforeIISellDay = 0;

        // I = 2
        int sellBeforeIMax = sellBeforeIIMax;
        int sellBeforeISellDay = sellBeforeIISellDay;
        int sellOnIMax = sellOnIIMax;

        for (int i = 2; i < prices.length; i++) {
            sellOnIIMax = Math.max(0, Math.max(sellOnIMax+prices[i]-prices[i-1], sellBeforeIMax+prices[i]-prices[sellBeforeISellDay]));
            sellBeforeIIMax = Math.max(sellOnIMax, sellBeforeIMax);
            sellBeforeIISellDay = sellBeforeIIMax == sellOnIMax ? i-1 : sellBeforeISellDay;

            sellBeforeIMax = sellBeforeIIMax;
            sellBeforeISellDay = sellBeforeIISellDay;
            sellOnIMax = sellOnIIMax;
        }

        return Math.max(sellOnIMax, sellBeforeIMax);
    }
}
