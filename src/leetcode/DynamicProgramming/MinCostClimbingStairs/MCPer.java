package leetcode.DynamicProgramming.MinCostClimbingStairs;

public class MCPer {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            int sum = cost[i] + Math.min(dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = sum;
        }
        dp[1] = Math.min(dp[0], dp[1]);
        return dp[1];
    }
}
