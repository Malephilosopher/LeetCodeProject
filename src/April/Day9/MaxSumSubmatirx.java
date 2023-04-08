package April.Day9;

import java.util.TreeSet;

public class MaxSumSubmatirx {

    public int maxSumSubmatrix(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        // 预处理前缀和
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        // 遍历子矩阵的上边界
        for (int top = 1; top <= m; top++) {
            // 遍历子矩阵的下边界
            for (int bot = top; bot <= m; bot++) {
                // 使用「有序集合」维护所有遍历到的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                // 遍历子矩阵的右边界
                for (int r = 1; r <= n; r++) {
                    // 通过前缀和计算 right
                    int right = sum[bot][r] - sum[top - 1][r];
                    // 通过二分找 left
                    Integer left = ts.ceiling(right - k);
                    if (left != null) {
                        int cur = right - left;
                        ans = Math.max(ans, cur);
                    }
                    // 将遍历过的 right 加到有序集合
                    ts.add(right);
                }
            }
        }
        return ans;
    }


}
