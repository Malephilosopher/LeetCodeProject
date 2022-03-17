package leetcode.DynamicProgramming.Rob;

public class RPer {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = 2; i < n + 2; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }
        return dp[n + 1];
    }
}
