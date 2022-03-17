package leetcode.DynamicProgramming.MaxProfit4;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/23 13:47
 */
public class MOff {

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];

        //初始化
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        //从前往后遍历天数
        for (int i = 1; i < n; i++) {
            //每次遍历两个，奇和偶，奇是买入，偶是卖出
            for (int j = 0; j < 2 * k - 1; j += 2) {
                //第i天买入，要么是前一天已买入，要么是今天买入
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                //第i天卖出，要么是前一天已卖出，要么是今天卖出
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[n - 1][k * 2];
    }
}
