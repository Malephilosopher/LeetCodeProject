package Week_259.SumOfBeauties;

import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/19 11:18
 */
public class SPer {

    public int sumOfBeauties(int[] nums) {
        int beauties = 0;
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }
        rightMin[nums.length - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMax[i] && nums[i] < rightMin[i]) {
                beauties += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                beauties += 1;
            }
        }
        return beauties;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 4};
        SPer s = new SPer();
        System.out.println(s.sumOfBeauties(nums));
    }
}
