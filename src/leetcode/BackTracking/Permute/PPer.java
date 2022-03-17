package leetcode.BackTracking.Permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PPer {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Boolean[] used = new Boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums, used);
        return ans;
    }

    public void backtracking(int[] nums, Boolean[] used){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PPer p = new PPer();
        int[] nums = {1, 2, 3};
        System.out.println(p.permute(nums));
    }
}
