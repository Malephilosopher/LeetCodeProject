package leetcode.FirstUniqChar;

import java.util.Queue;

public class FUCPer {
    public int firstUniqChar(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
            {
                ans = i;
                break;
            }
            else ans = -1;
        }
        if(s.length() == 0)
        {
            ans = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        FUCPer f = new FUCPer();
        System.out.println(f.firstUniqChar("loveleetcode"));
    }
}
