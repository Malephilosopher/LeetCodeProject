package leetcode.DynamicProgramming.KnightProbability;

public class KOff {

    private static final int[][] DIRS = new int[][]{{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][2];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j][0] = 1.0;
        for(int i = 1; i <= k; i++)
            for(int r = 0; r < n; r++)
                for(int c = 0; c < n; c++) {
                    //如果是偶数就更新dp[r][c][0],奇数就dp[r][c][1]
                    dp[r][c][i & 1] = 0;
                    for(int[] dir: DIRS) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n)
                            dp[r][c][i & 1] += dp[nr][nc][(i - 1) & 1]/8;
                    }
                }
        return dp[row][column][k & 1];
    }
}
