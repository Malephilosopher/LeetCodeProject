package leetcode.Find132Pattern;

import java.util.Deque;
import java.util.LinkedList;

/*
枚举1
O(n)
O(n)
 */
public class F1POff1 {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<>();
        int maxK = Integer.MIN_VALUE;
        candidateK.push(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if(nums[i] < maxK)
            {
                return true;
            }
            while(!candidateK.isEmpty() && nums[i] > candidateK.peek())
            {
                maxK = candidateK.pop();
            }
            if(nums[i] > maxK)
            {
                candidateK.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println(find132pattern(nums));
    }
}
