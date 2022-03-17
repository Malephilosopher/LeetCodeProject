package leetcode.greedy.MaxProfit;

public class MPPer {

    public int maxProfit(int[] prices) {
        int sum = 0;
        int pre = prices[0];
        for (int i = 1;i < prices.length;i++) {
            int price = prices[i];
            if(price - pre <= 0){
                pre = price;
                continue;
            }
            if(i < prices.length - 1 && prices[i + 1] < price){
                sum += price - pre;
                pre = prices[i + 1];
                i = i + 1;
                continue;
            }
            if(i == prices.length - 1){
                sum += price - pre;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MPPer mpPer = new MPPer();
        System.out.println(mpPer.maxProfit(prices));
    }
}
