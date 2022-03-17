package leetcode.DynamicProgramming.ZeroOneBackpack;

public class ZPer {

    //用二维数组遍历
    public int biggestValue(int[] weight, int[] value, int bagWeight){
        int n = weight.length;
        //初始化数组
        int[][] dp = new int[n][bagWeight + 1];
        for (int i = bagWeight; i >= 0 ; i--) {
            dp[0][i] = dp[0][i - weight[0]] + value[0];
        }
        //开始遍历
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if(j < weight[0]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n - 1][bagWeight];

    }
}
