package US.TopInterviewQuestions.Array.RemoveDuplicatesfromSortedArray;

import java.util.Arrays;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int pre = -101;
        int k = n;
        int i = 0;
        while(i < k) {
            if(nums[i] == pre){
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                k--;
            }else {
                pre = nums[i];
                i++;
            }
        }

        return k;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
        int[] expectedNums = {0, 1, 2, 3, 4}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }
}
