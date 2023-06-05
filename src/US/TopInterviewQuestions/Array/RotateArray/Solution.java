package US.TopInterviewQuestions.Array.RotateArray;

import java.util.Arrays;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/

    public void rotate(int[] nums, int k) {
        int start = 0; // start pointer
        k = k % nums.length; // middle pointer
        int end = nums.length - 1; // end pointer

        reverse(nums, start, end - k); //  first half of array for reverse {1, 2, 3, 4} => {4, 3, 2, 1}
        reverse(nums, nums.length - k, end); //  second half of array for reverse {5, 6, 7} => {7, 6, 5}
        reverse(nums, start, end); //  third step flip the entire array {4, 3, 2, 1, 7, 6, 5} => {5, 6, 7, 1, 2, 3, 4}
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start++] ^= nums[end--];
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = new int[]{-1,-100,3,99};

        new Solution().rotate(nums, 3);
        new Solution().rotate(nums1, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }
}
