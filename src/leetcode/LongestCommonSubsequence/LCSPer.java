package leetcode.LongestCommonSubsequence;

/*
10ms 84.20% O(mn)
42.3MB 45.95% O(mn)
 */
public class LCSPer {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }



    public static void main(String[] args) {
        String text1 = "bl", text2 = "yby";
        System.out.println(longestCommonSubsequence(text2, text1));
    }

}
