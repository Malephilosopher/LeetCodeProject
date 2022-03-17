package WeekCompetition.Week_277;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/23 10:41
 */
public class RearrangeArray {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Deque<Integer> positives = new LinkedList<>();
        Deque<Integer> negatives = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0){
                negatives.add(nums[i]);
            }else {
                positives.add(nums[i]);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                ans[i] = positives.poll();
            }else {
                ans[i] = negatives.poll();
            }
        }
        return ans;
    }
}
