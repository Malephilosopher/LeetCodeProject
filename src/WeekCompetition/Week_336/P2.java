package WeekCompetition.Week_336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P2 {

    //https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/description/


    public int maxScore(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0] > 0 ? 1 : 0;
        Arrays.sort(nums);
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = nums[n - i - 1];
        }
        long[] prefix = new long[n];
        prefix[0] = nums1[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums1[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(prefix[i] > 0)ans++;
        }
        return ans;

    }
}
