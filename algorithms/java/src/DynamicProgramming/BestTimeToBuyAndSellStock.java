package DynamicProgramming;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;

        // II = 2
        int sellBeforeIIMax = 0;
        int sellOnIIMax = Math.max(prices[1]-prices[0], 0);
        int sellBeforeIISellDay = 0;

        // I = 2
        int sellBeforeIMax = sellBeforeIIMax;
        int sellBeforeISellDay = sellBeforeIISellDay;
        int sellOnIMax = sellOnIIMax;

        for (int i = 3; i < prices.length; i++) {
            sellBeforeIIMax = Math.max(sellOnIMax, sellBeforeIMax);
            sellOnIIMax = Math.max(sellOnIMax+prices[i]-prices[i-1], sellBeforeIMax+prices[sellBeforeISellDay]-prices[i]);
            sellBeforeIISellDay = sellBeforeIIMax == sellOnIMax ? i-1 : sellBeforeISellDay;

            sellBeforeIMax = sellBeforeIIMax;
            sellBeforeISellDay = sellBeforeIISellDay;
            sellOnIMax = sellOnIIMax;
        }

        return Math.max(sellOnIMax, sellBeforeIMax);
    }
}
