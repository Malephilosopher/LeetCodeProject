package US.DP.BackpackDP.CoinChange;

import java.util.Arrays;

public class Solution {

    //https://leetcode.com/problems/coin-change/
    //complete backpack
    public int coinChange(int[] coins, int amount) {
        /*
                    0  1  2  3  ...  amount
        coins[0]    0

        coins[1]    0

        coins[2]    0


         */
        Arrays.sort(coins);
        //dp[i] means the number of coins needed to make up amount i
        int[] dp = new int[amount + 1];
        int n = coins.length;
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < n; j++) {
                int coin = coins[j];
                if(coin > i)break;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

    int INF = 0x3f3f3f3f;
    public int coinChange1(int[] cs, int cnt) {
        int n = cs.length;
        int[] f = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) f[i] = INF;
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = val; j <= cnt; j++) {
                f[j] = Math.min(f[j], f[j - val] + 1);
            }
        }
        return f[cnt] == INF ? -1 : f[cnt];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
    }

}
