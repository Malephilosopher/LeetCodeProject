package 剑指Offer.Day12;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[2];

        while (l < r){
            if(nums[r] < target - nums[l]){
                l++;
            }else if(nums[r] > target - nums[l]){
                r--;
            }else {
                ans[0] = nums[l];
                ans[1] = nums[r];
                return ans;
            }
        }
        return ans;
    }
}
