package leetcode.greedy.MaxSubArray;

import leetcode.Calculator.CPer;

public class MSAPer {

    public int maxSubArray(int[] nums) {
        int count = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if(count > result){
                result = count;
            }
            if(count <= 0) count = 0;
        }
        return result;
    }
}
