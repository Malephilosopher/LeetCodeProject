package leetcode.DynamicProgramming.ClimbStairs;

public class CSPer {

    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = Math.max(dp[0] * 2,  dp[1]);
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
