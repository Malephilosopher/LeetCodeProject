package leetcode.DynamicProgramming.StoneGame;

public class Solution {


    //https://leetcode.com/problems/stone-game/description/

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) { //枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { //枚举左端点
                int r = l + len - 1;
                int a = piles[l - 1] - dp[l + 1][r];
                int b = piles[r - 1] - dp[l][r - 1];
                dp[l][r] = Math.max(a, b);
            }
        }

        return dp[1][n] > 0;
    }
}
