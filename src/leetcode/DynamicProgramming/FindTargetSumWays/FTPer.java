package leetcode.DynamicProgramming.FindTargetSumWays;

import java.util.Arrays;

public class FTPer {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if ((S + sum) % 2 == 1) return 0;
        if (Math.abs(S) > sum) return 0;
        int target = (sum + S) / 2;
        //初始化dp数组
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //开始遍历
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if(j < nums[i]) dp[j] = dp[j - 1];
                else{
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
