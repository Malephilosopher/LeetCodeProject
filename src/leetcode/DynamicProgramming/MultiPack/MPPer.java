package leetcode.DynamicProgramming.MultiPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MPPer {

    /*
    第一种方法，将多重背包转化为01背包，将每个物品拆分成一个
     */
    public int multiPack(List<Integer> weight, List<Integer> value, List<Integer> nums, int bagWeight){
        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1){
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }
        
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.size(); i++) {
            for (int j = bagWeight; j >= weight.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        List<Integer> weight = new ArrayList<>();
        weight.add(1);
        weight.add(3);
        weight.add(4);
        List<Integer> value = new ArrayList<>();
        value.add(15);
        value.add(20);
        value.add(30);
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(2);
        int bagWeight = 10;
        MPPer mpPer = new MPPer();
        System.out.println(mpPer.multiPack(weight, value, nums, bagWeight));
    }


}
