package leetcode.BackTracking.LetterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LCPer {

    private static final HashMap<Integer, String> keyboard = new HashMap<>();

    static {
        keyboard.put(1, "");
        keyboard.put(2, "abc");
        keyboard.put(3, "def");
        keyboard.put(4, "ghi");
        keyboard.put(5, "jkl");
        keyboard.put(6, "mno");
        keyboard.put(7, "pqrs");
        keyboard.put(8, "tuv");
        keyboard.put(9, "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        if(digits.length() == 0) return ans;
        backtracking(s, digits, 0, ans);
        return ans;
    }

    public void backtracking(StringBuilder s, String digits, int index, List<String> ans){
        if(s.length() == digits.length())
        {
            ans.add(s.toString());
            return;
        }
        int digit = Integer.parseInt(digits.substring(index, index + 1));
        String letters = keyboard.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            s.append(letters.charAt(i));
            backtracking(s, digits, index + 1, ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
