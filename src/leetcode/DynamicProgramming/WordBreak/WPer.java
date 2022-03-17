package leetcode.DynamicProgramming.WordBreak;

import java.util.ArrayList;
import java.util.List;

public class WPer {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j,i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }

    public static void main(String[] args) {
        String s = "bb";
        WPer w = new WPer();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");
        System.out.println(w.wordBreak(s, wordDict));
    }
}
