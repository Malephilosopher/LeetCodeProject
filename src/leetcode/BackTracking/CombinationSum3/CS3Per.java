package leetcode.BackTracking.CombinationSum3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CS3Per {

    public List<List<Integer>> combinationSum3(int k, int n) {
         if(n == 0 || k == 0) return null;
         List<List<Integer>> ans = new ArrayList<>();
         Deque<Integer> path = new ArrayDeque<>();
         backtracking(k, n, 1, 0, path, ans);
         return ans;
    }

    public void backtracking(int k, int n, int startIndex, int sum, Deque<Integer> path, List<List<Integer>> ans){
        if(path.size() == k)
        {
            if(sum == n){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.addLast(i);
            backtracking(k, n, i + 1, sum, path, ans);
            path.removeLast();
            sum -= i;
        }
    }

}
