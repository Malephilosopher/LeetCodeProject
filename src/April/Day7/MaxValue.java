package April.Day7;

import java.util.Arrays;

public class MaxValue {

    public int maxValue(int[][] es, int k) {
        int n = es.length;
        Arrays.sort(es, (a, b)->a[1]-b[1]);
        // f[i][j] 代表考虑前 i 个事件，选择不超过 j 的最大价值
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int[] ev = es[i - 1];
            int s = ev[0], e = ev[1], v = ev[2];

            // 通过「二分」，找到第 i 件事件之前，与第 i 件事件不冲突的事件
            // 对于当前事件而言，冲突与否，与 j 无关
            int l = 1, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                int[] prev = es[mid - 1];
                if (prev[1] < s) l = mid;
                else r = mid - 1;
            }
            int last = (r > 0 && es[r - 1][1] < s) ? r : 0;

            for (int j = 1; j <= k; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[last][j - 1] + v);
            }
        }
        return f[n][k];
    }
}
