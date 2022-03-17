package leetcode.BackTracking.Subsets;

import java.util.ArrayList;
import java.util.List;

public class SPer {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, result);
        return result;
    }

    public void backtracking(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result)
    {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }


}
