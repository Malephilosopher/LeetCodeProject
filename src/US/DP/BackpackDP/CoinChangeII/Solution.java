package US.DP.BackpackDP.CoinChangeII;

public class Solution {


    //https://leetcode.com/problems/coin-change-ii/


    public int change(int amount, int[] coins) {
        int n = coins.length;

        //dp[i] represents the number of combinations that make up the amount i
        int[] dp = new int[amount + 1];
        /*
        not choose:
        dp[j]
        choose:
        dp[j - coins[i]]
         */
        dp[0] = 1;
        for (int i = 0; i < n; i++) {

            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }

        }

        return dp[amount];

    }
}
