package leetcode.DynamicProgramming.MaxProfit2;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/22 15:13
 */
public class MPer {

    // 实现1：二维数组存储
    // 可以将每天持有与否的情况分别用 dp[i][0] 和 dp[i][1] 来进行存储
    // 时间复杂度：O(n)，空间复杂度O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        //第一天买入
        dp[0][0] = -prices[0];
        //第一天不买入
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            //dp[i][0]是第i天持有股票的情况，要么前一天已买入，要么今天买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //dp[i][1]是第i天不持有股票的情况， 要么前一天已卖出，要么今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }

    // 实现2：变量存储
    // 第一种方法需要用二维数组存储，有空间开销，其实关心的仅仅是前一天的状态，不关注更多的历史信息
    // 因此，可以仅保存前一天的信息存入 dp0、dp1 这 2 个变量即可
    // 时间复杂度：O(n)，空间复杂度O(1)
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];  // 定义变量，存储初始状态
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);    // 第 i 天，没有股票
            int newDp1 = Math.max(dp1, dp0 - prices[i]);    // 第 i 天，持有股票
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
