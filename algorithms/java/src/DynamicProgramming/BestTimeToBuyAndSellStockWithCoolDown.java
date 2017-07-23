package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;

        int buy = 0;
        int sell = 0;
        int rest = 0;
        buy = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            int preRest = rest;
            rest = Math.max(rest, sell);
            sell = buy+prices[i];
            buy = Math.max(buy, preRest-prices[i]);
        }
        return Math.max(rest, sell);
    }
}
