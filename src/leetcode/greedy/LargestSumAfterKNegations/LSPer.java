package leetcode.greedy.LargestSumAfterKNegations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3ms 80% 37.7MB 70%
 */
public class LSPer {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if(nums[i] <= 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        if(k > 0){
            Arrays.sort(nums);
            while(k > 0){
                nums[0] = -nums[0];
                k--;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
