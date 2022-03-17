package leetcode.DynamicProgramming.KnightProbability;

public class KPer {

    int[][] dirs = new int[][]{{-1,-2},{-1,2},{1,-2},{1,2},{-2,1},{-2,-1},{2,1},{2,-1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1.0;
            }
        }

        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir: dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if(r < n && r >= 0 && c < n && c >= 0){
                            dp[i][j][p] += dp[r][c][p - 1] / 8;
                        }
                    }
                }
            }
        }
        return dp[row][column][k];
    }
}
