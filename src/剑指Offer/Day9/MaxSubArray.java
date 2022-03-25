package 剑指Offer.Day9;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = -101;
        for(int i = 0; i < n; i++){
            int sum = nums[i];
            max = Math.max(max, sum);
            for(int j = i + 1; j < n; j++){
                if(nums[j] + sum < 0) break;
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
