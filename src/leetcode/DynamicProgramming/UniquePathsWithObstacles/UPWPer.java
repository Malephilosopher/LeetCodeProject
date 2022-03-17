package leetcode.DynamicProgramming.UniquePathsWithObstacles;

public class UPWPer {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(m == 1){
            for (int i = 0; i < n; i++) {
                if(obstacleGrid[0][i] == 1){
                    return 0;
                }
            }
            return 1;
        }
        if(n == 1){
            for (int i = 0; i < n; i++) {
                if(obstacleGrid[i][0] == 1){
                    return 0;
                }
            }
            return 1;
        }
        dp[1][0] = 1;
        dp[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[m - 1][n - 1];
    }
}
