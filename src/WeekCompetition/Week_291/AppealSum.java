package WeekCompetition.Week_291;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AppealSum {



    public long appealSum(String s) {
        int n = s.length();
        long ans = 0;
        int[] a = new int[26];
        Arrays.fill(a, -1);
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = i - a[s.charAt(i) - 'a'];
            a[s.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        for (int d: diff) {
            ans += d;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "code";
    }
}
