package leetcode.MaxNumberOfBalloons;

import java.util.HashMap;
import java.util.Map;

public class MPer {

    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int ans = 0;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            count[c - 'a']++;
        }


        while (count[1] > 0 && count[0] > 0 && count[11] > 1 && count[14] > 1 && count[13] > 0){
            ans++;
            count[0]--;
            count[1]--;
            count[11] -= 2;
            count[14] -= 2;
            count[13]--;
        }
        return ans;



    }
}
