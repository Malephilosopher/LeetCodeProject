package leetcode.BackTracking.CombinationSum;

import java.util.*;

public class CSPer {

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(0, 0, candidates, target, path, result);
        return result;
    }

    public static void backtracking(int sum, int startIndex, int[] candidates, int target, List<Integer> path, List<List<Integer>> result){
        if(sum > target) return;
        if(sum == target)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(sum, i, candidates, target, path, result);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
