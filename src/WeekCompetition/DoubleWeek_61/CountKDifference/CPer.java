package DoubleWeek_61.CountKDifference;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/18 23:04
 */
public class CPer {

    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(Math.abs(nums[i] - nums[j]) == k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
