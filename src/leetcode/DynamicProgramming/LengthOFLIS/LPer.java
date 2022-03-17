package leetcode.DynamicProgramming.LengthOFLIS;

import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/25 13:52
 */
public class LPer {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
