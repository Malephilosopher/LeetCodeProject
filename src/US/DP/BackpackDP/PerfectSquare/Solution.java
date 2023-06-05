package US.DP.BackpackDP.PerfectSquare;

public class Solution {

    //https://leetcode.com/problems/perfect-squares/


    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
                dp[i] = min + 1;
            }
        }

        return dp[n];


    }


}
