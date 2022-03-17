package leetcode.DynamicProgramming.CombinationSum4;

public class CSPer {

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0 && dp[i] < Integer.MAX_VALUE - dp[i - nums[j]]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
