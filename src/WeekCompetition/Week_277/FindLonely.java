package WeekCompetition.Week_277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/23 10:52
 */
public class FindLonely {

    public List<Integer> findLonely(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(nums[0]);
            return ans;
        }
        Arrays.sort(nums);
        if(nums[0] != nums[1] && nums[1] != nums[0] + 1){
            ans.add(nums[0]);
        }
        for (int i = 1; i < n - 1; i++) {
            int num = nums[i];
            if(nums[i - 1] != num - 1 && nums[i - 1] != num && nums[i + 1] != num && nums[i + 1] != num + 1){
                ans.add(num);
            }
        }
        if(nums[n - 2] != nums[n - 1] && nums[n - 2] != nums[n - 1] - 1){
            ans.add(nums[n - 1]);
        }
        return ans;
    }
}
