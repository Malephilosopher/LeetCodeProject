package leetcode.DynamicProgramming.Fib;

public class FOff {

    public int fib(int n) {
        if(n < 2) return n;
        int[][] res = matrixPow(new int[][]{{1, 1}, {1, 0}}, n - 1);
        return res[0][0];
    }

    public int[][] matrixPow(int[][] matrix, int pow){
        int[][] res = new int[][]{{1, 0}, {0, 1}};
        for (int i = 0; i < pow; i++) {
           res = matrixMultiply(matrix, res);
        }
        return res;
    }

    //定义一个矩阵乘法
    public int[][] matrixMultiply(int[][] a, int[][] b){
        int[][] ans = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return ans;
    }
}
