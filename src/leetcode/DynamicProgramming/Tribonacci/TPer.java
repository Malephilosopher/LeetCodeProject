package leetcode.DynamicProgramming.Tribonacci;

public class TPer {

    public int tribonacci(int n) {
        if(n == 0) return n;
        if(n <= 2) return 1;
        int[][] ans = pow(new int[][]{{1, 1, 1},{1, 0 ,0}, {0, 1, 0}}, n);
        return ans[2][0] + ans[2][1];
    }

    public int[][] pow(int[][] m, int n){
        int[][] ans = m;
        for (int i = 0; i < n - 1; i++) {
            ans = multiply(m, ans);
        }
        return ans;
    }

    public int[][] multiply(int[][] a, int[][] b){
        int[][] ans = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return ans;
    }
}
