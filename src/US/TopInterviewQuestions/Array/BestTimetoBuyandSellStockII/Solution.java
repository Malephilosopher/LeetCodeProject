package US.TopInterviewQuestions.Array.BestTimetoBuyandSellStockII;

import java.util.ArrayList;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/

    public int maxProfit(int[] prices) {
        ArrayList<Integer> priceGain = new ArrayList<Integer>();

        for(int idx = 0 ; idx < prices.length-1; idx++){

            if( prices[idx] < prices[idx+1] ){
                priceGain.add( prices[idx+1]- prices[idx]);
            }

        }
        return priceGain.stream().mapToInt(n->n).sum();

    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Solution s= new Solution();
        System.out.println(s.maxProfit(prices));
    }
}
