package leetcode.DynamicProgramming.ZeroOneBackpack;

public class ZOff {
    
    //使用一维数组遍历(滚动数组)
    public int biggestValue(int[] weight, int[] value, int bagWeight){
        int n = weight.length;
        //初始化数组
        int[] dp = new int[bagWeight + 1];
        //开始遍历
        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        ZOff zOff = new ZOff();
        System.out.println(zOff.biggestValue(weight, value, bagWeight));
    }
    
}
