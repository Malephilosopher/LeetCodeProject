package US.TopInterviewQuestions.Array.SingleNumber;

import java.util.Arrays;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/

    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i += 2) {
            if(i == n - 1)return nums[i];
            if(nums[i] != nums[i + 1])return nums[i];
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(new Solution().singleNumber(nums));
    }
}
