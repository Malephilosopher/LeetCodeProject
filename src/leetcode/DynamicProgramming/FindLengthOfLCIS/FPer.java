package leetcode.DynamicProgramming.FindLengthOfLCIS;

import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/25 14:07
 */
public class FPer {

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
