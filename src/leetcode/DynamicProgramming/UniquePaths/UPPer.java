package leetcode.DynamicProgramming.UniquePaths;

public class UPPer {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        if(m == 1 || n == 1){
            return 1;
        }
        dp[1][0] = 1;
        dp[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[m - 1][n - 1];

    }
}
