package leetcode.DynamicProgramming.MaxProfitWithForzen;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/23 14:04
 */
public class MPer {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],Math.max( dp[i - 1][3], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][3], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][3],Math.max(dp[n - 1][1], dp[n - 1][2]));

    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
