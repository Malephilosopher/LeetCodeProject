package 剑指Offer.Day8;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int pre = 0;
        int ans = 0;
        int cost = prices[0];
        if(prices.length <= 1) return 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(pre, prices[i] - cost);
            pre = ans;
            cost = Math.min(cost, prices[i]);
        }
        return ans;

    }
}
