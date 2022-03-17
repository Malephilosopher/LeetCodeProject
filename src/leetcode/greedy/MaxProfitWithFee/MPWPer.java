package leetcode.greedy.MaxProfitWithFee;

public class MPWPer {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 情况二：相当于买入
            pre = Math.min(pre, prices[i]);
            // 情况三：保持原有状态（因为此时买则不便宜，卖则亏本）
            if(prices[i] - pre - fee <= 0){
                continue;
            }
            // 计算利润，可能有多次计算利润，最后一次计算利润才是真正意义的卖出
            if(prices[i] - pre - fee > 0){
                    profit += prices[i] - pre - fee;
                    pre = prices[i] - fee; // 情况一，这一步很关键
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] profit = {1, 3, 7, 5, 10, 3};
        MPWPer mpwPer = new MPWPer();
        System.out.println(mpwPer.maxProfit(profit, 3));
    }
}
