package leetcode.LengthOfLIS;

import java.util.Arrays;

public class LOLPer {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int l = nums.length;
        int[] dp = new int[l];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
