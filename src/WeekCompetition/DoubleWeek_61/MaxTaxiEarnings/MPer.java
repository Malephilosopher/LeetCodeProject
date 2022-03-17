package DoubleWeek_61.MaxTaxiEarnings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/18 23:28
 */
public class MPer {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int len = rides.length;
        int index = 0;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (index < rides.length && rides[index][1] <= i){
                dp[i] = Math.max(dp[i], dp[rides[index][0]] + rides[index][1] - rides[index][0] + rides[index][2]);
                index++;
            }
        }
        return dp[n];

    }
}
