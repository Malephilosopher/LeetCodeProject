package leetcode.SubArrayRanges;

public class SPer {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ret += maxVal - minVal;
            }
        }
        return ret;
    }
}
