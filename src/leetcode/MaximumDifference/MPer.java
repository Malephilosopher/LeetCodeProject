package leetcode.MaximumDifference;

import java.util.Arrays;

public class MPer {

    //前缀最小值
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        int ans = -1;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, nums[i] - min[i]);
        }
        if(ans <= 0) ans = -1;
        return ans;
    }
}
