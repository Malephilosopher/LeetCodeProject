package April.Day30;

public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        if(n == 1)return 0;

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max - min <= k * 2)return 0;
        return max - min - 2 * k;


    }
}
