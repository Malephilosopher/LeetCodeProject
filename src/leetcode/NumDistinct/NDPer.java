package leetcode.NumDistinct;

import java.util.HashMap;

//错误解法（字典法）
public class NDPer {
    public static int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int ans = 0;
        if(n1 < n2 || (n1 == n2 && !s.equals(t)))
        {
            return 0;
        }
        HashMap<Character, Integer> dicOft = getDictionary(t);
        HashMap<Character, Integer> dicOfs = getDictionary(s);
        for (char c: dicOft.keySet()) {
            if(dicOfs.get(c) == 0)
            {
                return 0;
            }else if(dicOfs.get(t.charAt(0)) > 1) {
                ans += dicOfs.get(t.charAt(0)) - 1;
            } else if(dicOfs.get(c) > 1){
                ans += dicOfs.get(c);
            }
        }
        return ans;

    }

    private static HashMap<Character, Integer> getDictionary(String t) {
        int n = t.length();
        HashMap<Character, Integer> dicOft = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(dicOft.containsKey(t.charAt(i)))
            {
                dicOft.replace(t.charAt(i), dicOft.get(t.charAt(i)) + 1);
                continue;
            }
            dicOft.put(t.charAt(i), 1);
        }
        return dicOft;
    }

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s, t));
    }
}
