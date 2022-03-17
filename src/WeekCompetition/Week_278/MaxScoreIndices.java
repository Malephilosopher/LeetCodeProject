package WeekCompetition.Week_278;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/30 10:34
 */
public class MaxScoreIndices {

    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        int[] prefixSum = new int[n + 1];
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            if(nums[i - 1] == 0){
                prefixSum[i] = pre + 1;
                pre = prefixSum[i];
            }
        }
        int[] suffixSum = new int[n + 1];
        pre = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(nums[i] == 1){
                suffixSum[i] = pre + 1;
                pre = suffixSum[i];
            }
        }
        for (int i = 0; i <= n; i++) {
            int score = prefixSum[i] + suffixSum[i];
            scores.add(score);
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, scores.get(i));
        }
        for (int i = 0; i <= n; i++) {
            if(scores.get(i) == max){
                ans.add(i);
            }
        }
        return ans;
    }
}
