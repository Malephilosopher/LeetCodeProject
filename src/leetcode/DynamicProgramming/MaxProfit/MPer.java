package leetcode.DynamicProgramming.MaxProfit;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/22 11:18
 */
public class MPer {

    //贪心
    public int maxProfit(int[] prices) {
        int start = prices[0];
        int n = prices.length;
        int pre = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] < start){
                start = prices[i];
                continue;
            }
            pre = Math.max(pre, prices[i] - start);
        }
        return pre;
    }
}
