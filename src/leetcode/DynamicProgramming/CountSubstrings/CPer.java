package leetcode.DynamicProgramming.CountSubstrings;

import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/2 14:52
 */
public class CPer {

    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        ans++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }

//    public boolean isPalindrome(String s){
//        int l = 0;
//        int r = s.length() - 1;
//        while (l < r){
//            if(s.charAt(l) != s.charAt(r)){
//                return false;
//            }
//            l++;
//            r--;
//        }
//        return true;
//    }
}
