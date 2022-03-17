package leetcode.BackTracking.Partition;

import java.util.ArrayList;
import java.util.List;

public class PPer {

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if(s.length() == 0){
            return ans;
        }
        int n = s.length();
        backtracking(s, path, ans, n);
        return ans;
    }

    public static void backtracking(String s, List<String> path, List<List<String>> ans, int n){
        if(sameLength(path, n)){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(0, i + 1);
            if(isPalindromes(cur)){
                path.add(cur);
            }else {
                continue;
            }
            String remain = s.substring(i + 1);
            backtracking(remain, path, ans, n);
            path.remove(path.size() - 1);
        }

    }

    public static boolean isPalindromes(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString().equals(s);
    }

    public static boolean sameLength(List<String> path, int n){
        for (String str: path) {
            n -= str.length();
        }
        return n == 0;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
