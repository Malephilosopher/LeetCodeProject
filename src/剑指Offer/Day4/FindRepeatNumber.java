package 剑指Offer.Day4;

import java.util.Arrays;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) return nums[i];
        }
        return 0;
    }
}
