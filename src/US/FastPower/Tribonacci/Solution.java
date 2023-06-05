package US.FastPower.Tribonacci;

public class Solution {

    //https://leetcode.com/problems/n-th-tribonacci-number/

    int N = 3;
    public int[][] mul(int[][] a, int[][] b){

        int[][] c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }
        return c;

    }
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[][] mat = {
                {1, 1, 1},
                {1, 0, 0},
                {0, 1, 0}
        };
        int[][] ans = {
                {1, 0, 0},
                {0 ,1, 0},
                {0, 0, 1}
        };
        //fast power
        int k = n - 2;
        while (k > 0){
            if((k & 1) == 1)ans = mul(ans, mat);
            mat = mul(mat, mat);
            k >>= 1;
        }

        return ans[0][0] + ans[0][1];


    }
}
