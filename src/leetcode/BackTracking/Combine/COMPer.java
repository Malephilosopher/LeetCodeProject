package leetcode.BackTracking.Combine;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class COMPer {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtracking(n, k, 1, path, result);
        return result;
    }

    public void backtracking(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> result){
        //终止条件
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtracking(n, k, i + 1, path, result);
            path.removeLast();
        }
    }

}
