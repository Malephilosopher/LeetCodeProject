package US.TopInterviewQuestions.Array.ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean out = set.add(nums[i]);
            if(!out)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2};
        System.out.println(new Solution().containsDuplicate1(nums));
    }
}
