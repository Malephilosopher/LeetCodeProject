package leetcode.SlideWindow.MinimumDifference;

import java.util.Arrays;

public class MPer {

    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(k == 1 || n == 1) return 0;
        int left = 0;
        int right = k - 1;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        while (right < n){
            min = Math.min(min, (nums[right] - nums[left]));
            left++;
            right++;
        }
        return min;
    }
}
