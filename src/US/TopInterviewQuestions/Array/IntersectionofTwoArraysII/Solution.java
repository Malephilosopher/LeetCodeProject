package US.TopInterviewQuestions.Array.IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[n2];
        for (int i = 0; i < n1; i++) {
            int num = nums1[i];
            for (int j = 0; j < n2; j++) {
                if(nums2[j] == num && !used[j]){
                    ans.add(num);
                    used[j] = true;
                    break;
                }
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    /*
    Follow up:

        What if the given array is already sorted? How would you optimize your algorithm?
        During the traversing, if met the number which is already larger than the target, immediately stop

        What if nums1's size is small compared to nums2's size? Which algorithm is better?


        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */
}
