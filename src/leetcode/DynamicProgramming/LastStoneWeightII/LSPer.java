package leetcode.DynamicProgramming.LastStoneWeightII;

import java.util.Arrays;

public class LSPer {

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                if(j < stones[i]) dp[j] = dp[j - 1];
                else {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return Math.abs(dp[target] - (sum - dp[target]));
    }
}
