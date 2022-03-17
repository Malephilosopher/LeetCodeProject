package leetcode.BackTracking.CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSPer {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Boolean> used = new ArrayList<>(candidates.length);
        for (int i = 0; i < candidates.length; i++) {
            used.add(false);
        }
        Arrays.sort(candidates);
        if(candidates.length == 0) return result;
        backtracking(0, 0, candidates, target, path, result, used);
        return result;
    }

    public static void backtracking(int sum, int startIndex, int[] candidates, int target, List<Integer> path,
                                    List<List<Integer>> result, List<Boolean> used){
        if(sum == target)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used.get(i - 1)) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used.set(i, true);
            backtracking(sum, i + 1, candidates, target, path, result, used);
            sum -= candidates[i];
            used.set(i, false);
            path.remove(path.size() - 1);
        }

    }
}
