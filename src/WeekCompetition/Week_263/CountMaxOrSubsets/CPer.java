package WeekCompetition.Week_263.CountMaxOrSubsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/17 10:48
 */
public class CPer {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    public int countMaxOrSubsets(int[] nums) {
        map = new HashMap<>();
        int n = nums.length;
        list = new ArrayList<>();
        dfs(nums, 0);
        int max = 0;
        for (int sum: map.keySet()) {
            max = Math.max(max, sum);
        }
        return map.get(max);
    }

    public void dfs(int[] nums, int start){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum |= list.get(i);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);


        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
