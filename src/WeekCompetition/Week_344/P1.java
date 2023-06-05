package WeekCompetition.Week_344;

import java.util.HashSet;

public class P1 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        var suf = new int[n + 1];
        var s = new HashSet<Integer>();
        for (int i = n - 1; i > 0; i--) {
            s.add(nums[i]);
            suf[i] = s.size();
        }

        s.clear();
        var ans = new int[n];
        for (int i = 0; i < n; i++) {
            s.add(nums[i]);
            ans[i] = s.size() - suf[i + 1];
        }
        return ans;

    }
}
