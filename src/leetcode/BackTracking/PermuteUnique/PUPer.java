package leetcode.BackTracking.PermuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PUPer {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 1){
            path.add(nums[0]);
            ans.add(path);
            return ans;
        }
        Boolean[] used = new Boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums, used);
        return ans;
    }

    public void backtracking(int[] nums, Boolean[] used){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
