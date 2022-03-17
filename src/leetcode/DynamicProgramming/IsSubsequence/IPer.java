package leetcode.DynamicProgramming.IsSubsequence;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/28 10:29
 */
public class IPer {

    public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[n1][n2] == n1;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IPer i = new IPer();
        System.out.println(i.isSubsequence(s, t));
    }
}
