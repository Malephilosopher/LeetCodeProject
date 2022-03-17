package leetcode.DynamicProgramming.MaxSubArray;


/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/28 9:42
 */
public class MPer {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int sum = 0;
        for (int num: nums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
