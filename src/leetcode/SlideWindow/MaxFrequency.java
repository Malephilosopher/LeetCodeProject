package leetcode.SlideWindow;

import java.util.Arrays;

public class MaxFrequency {

    int[] nums, sum;
    int n, k;
    public int maxFrequency(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        n = nums.length;
        Arrays.sort(nums);
        sum = new int[n + 1];//前缀和数组
        for (int i = 1; i <= n; i++) {
            //第i位是前i - 1位的和，方便后面计算区间和
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int left = 0, right = n;
        while (left < right){
            int mid = left + right + 1 >> 1;
            if(check(mid))left = mid;
            else right = mid - 1;
        }

        return right;
    }

    public boolean check(int len){
        for (int l = 0; l + len  - 1 < n; l++) {
            int r = l + len - 1;
            int curSum = sum[r + 1] - sum[l];
            int tarSum = nums[r] * len;
            if(tarSum - curSum <= k) return true;
        }
        return false;
    }
}
