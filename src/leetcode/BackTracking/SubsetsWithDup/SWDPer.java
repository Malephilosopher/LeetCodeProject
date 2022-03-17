package leetcode.BackTracking.SubsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWDPer {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(used, nums, 0, path, result);
        return result;
    }

    public void backtracking(boolean[] used, int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result)
    {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
            {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(used, nums, i + 1, path, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
