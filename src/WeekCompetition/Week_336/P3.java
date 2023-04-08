package WeekCompetition.Week_336;

import java.util.HashMap;

public class P3 {

    //https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/description/

    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        var cnt = new HashMap<Integer, Integer>();
        cnt.put(s, 1); // s[0]
        for (int x : nums) {
            s ^= x;
            ans += cnt.getOrDefault(s, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;

    }
}
