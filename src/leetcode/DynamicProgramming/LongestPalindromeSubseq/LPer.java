package leetcode.DynamicProgramming.LongestPalindromeSubseq;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/2 15:32
 */
public class LPer {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len < 2) return len;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
